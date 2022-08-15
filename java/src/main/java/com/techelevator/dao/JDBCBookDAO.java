package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookAlreadyExistsException;
import com.techelevator.model.BookNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@Component
public class JDBCBookDAO implements BookDAO{

    private JdbcTemplate jdbcTemplate;

    public JDBCBookDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Book> retrieveAllBooks(int userId) {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM master_table " +
                "JOIN inventory ON inventory.book_id = master_table.book_id " +
                "JOIN users ON users.user_id = master_table.user_id " +
                "WHERE master_table.user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);  //, principal.userId);

        while(results.next()) {

            Book book = mapRowToBook(results);
            books.add(book);
        }
        return books;
    }

    /** Takes in the book to add to the user's inventory, checks if it already exists in the database
     *  If it already exists, create the
     *
     *
     * @param newBook the book to add to the inventory
     * @param userId the user currently logged in
     */
    @Override
    public void addBook(Book newBook, int userId) throws BookAlreadyExistsException{
        Integer id = null;
        int tempListId = 1; //todo create the real list id method

        String bookCheckSQL= "SELECT * FROM inventory WHERE book_isbn = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(bookCheckSQL, newBook.getIsbn());
        if(results.next()){
            id = results.getInt("book_id");


            if(checkForMasterList(id, userId,tempListId)) {
                throw new BookAlreadyExistsException();
            }

        }
        else {
            String bookSQL = "INSERT INTO inventory (book_isbn, book_title, book_author, book_genre) " +
                    "VALUES(?,?,?,?) RETURNING book_id;";
            id = jdbcTemplate.queryForObject(bookSQL, Integer.class,
                newBook.getIsbn(),
                newBook.getTitle(),
                newBook.getAuthor(),
                newBook.getGenre()
            );
        }

        String masterSQL = "INSERT INTO master_table (book_id, user_id, list_id) " +
                "VALUES (?,?,?);";
        jdbcTemplate.update(masterSQL,
                id,
                userId,
                tempListId);

    }

    @Override
    public void deleteBook(int bookToDeleteId, Principal principal) throws BookNotFoundException{  //website.com/mybooks/123
        //retrieve where the Book ID in the database matches the ones we're trying to delete
        String bookIdSQL = "SELECT book_id FROM inventory WHERE book_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(bookIdSQL, bookToDeleteId);

        //check if the book at the ID we're trying to delete actually exists in the database

        if(results.next()){
            //if it exists we have the bookId to delete now, send another SQL query
            String sql = "DELETE FROM inventory WHERE book_id = ?";
            jdbcTemplate.update(sql, bookToDeleteId);
        }
        else{
            throw new BookNotFoundException();
        }

    }


    private boolean checkForMasterList(int bookId, int userId, int listId){

        String sql = "SELECT * " +
                "FROM master_table " +
                "WHERE book_id = ? AND user_id = ? AND list_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId, userId, listId);  //, principal.userId);

        return results.next();
    }



    private Book mapRowToBook(SqlRowSet results) {
        Book book = new Book();

        book.setAuthor(results.getString("book_author"));
        book.setTitle(results.getString("book_title"));
        book.setBookId(results.getInt("book_id"));
        book.setIsbn(results.getString("book_isbn"));
        book.setGenre(results.getString("book_genre"));
        //book.setUserId(results.getInt("user_id"));

        return book;
    }
}

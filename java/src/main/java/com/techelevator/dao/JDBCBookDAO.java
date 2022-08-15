package com.techelevator.dao;

import com.techelevator.model.Book;
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
                "FROM inventory " +
                //"JOIN users ON users.userid = inventory.userid";
                "WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);  //, principal.userId);

        while(results.next()) {

            Book book = mapRowToBook(results);
            books.add(book);
        }
        return books;
    }

//    @Override
//    public List<Book> retrieveCustomList(int userId, int listId) {
//        List<Book> books = new ArrayList<>();
//
//        String sql = "SELECT * " +
//                "FROM inventory " +
//                "LEFT JOIN lists ON lists.user_id = inventory.user_id" +
//                "WHERE user_id = ?;";
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, listId);  //, principal.userId);
//
//        while(results.next()) {
//
//            Book book = mapRowToBook(results);
//            books.add(book);
//        }
//        return books;
//
//    }

    @Override
    public Book addBook(Book newBook, int userId){
        String bookSQL = "INSERT INTO inventory (book_isbn, user_id, book_title, book_author, book_genre) " +  //TODO add the userID from principal
                "VALUES(?,?,?,?,?) RETURNING book_id";
        //Integer id =
                jdbcTemplate.queryForObject(bookSQL, Integer.class,
                newBook.getIsbn(),
                userId,
                newBook.getTitle(),
                newBook.getAuthor(),
                newBook.getGenre()
                );
        //newBook.setBookId(id);
        return newBook;

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



    private Book mapRowToBook(SqlRowSet results) {
        Book book = new Book();

        book.setAuthor(results.getString("book_author"));
        book.setTitle(results.getString("book_title"));
        book.setBookId(results.getInt("book_id"));
        book.setIsbn(results.getString("book_isbn"));
        book.setGenre(results.getString("book_genre"));
        book.setUserId(results.getInt("user_id"));

        return book;
    }
}

package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookAlreadyExistsException;
import com.techelevator.model.BookNotFoundException;
import com.techelevator.model.ReadingList;
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

    /** Create A List */

    @Override
    public int createList(Principal principal, ReadingList listName) {

        String addListName = principal.getName() + "|" + listName.getListName();

        String sql = "INSERT INTO reading_list (list_name) " +
                "VALUES(?) RETURNING list_id;";

        return jdbcTemplate.queryForObject(sql, Integer.class, addListName);


    }

    @Override
    public List<ReadingList> retrieveReadingLists(Principal principal) {
        List<ReadingList> readingList = new ArrayList<>();

        String listName;
        int usernameLength = principal.getName().length() + 1;

        String sql = "SELECT * FROM reading_list " +
                "WHERE list_name ILIKE ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal.getName() + '%');
        while(results.next()) {
            ReadingList list = new ReadingList();

            list.setListId(results.getString("list_id"));

            listName = results.getString("list_name").substring(usernameLength);


            list.setListName(listName);
            readingList.add(list);
        }


        return readingList;
    }

    @Override
    public void updateBookList(Book bookToUpdate, int userId) {
        int bookId = bookToUpdate.getBookId();
        int listId = bookToUpdate.getReadingListId();
        String sql = "UPDATE master_table SET list_id = ? WHERE book_id = ? AND user_id = ?;";
        jdbcTemplate.update(sql, listId, bookId, userId);

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
        int listId = 1; //todo create the real list id method

        String bookCheckSQL= "SELECT * FROM inventory WHERE book_isbn = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(bookCheckSQL, newBook.getIsbn());
        if(results.next()){
            id = results.getInt("book_id");


            if(checkForMasterList(id, userId,listId)) {
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
                listId);

    }

    /** Add a book to a custom reading list */

    //need ability for user to create a new list. (INSERT)
    //once they have the new list - need ability to name this list (INSERT into reading list table)
    //need ability to retrieve whichever list they select
    //need a (PUT) to update the list_id a book


//    @Override
//    public void deleteBook(int bookToDeleteId, Principal principal) throws BookNotFoundException{  //website.com/mybooks/123
//        //retrieve where the Book ID in the database matches the ones we're trying to delete
//        String bookIdSQL = "SELECT book_id FROM inventory WHERE book_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(bookIdSQL, bookToDeleteId);
//
//        //check if the book at the ID we're trying to delete actually exists in the database
//
//        if(results.next()){
//            //if it exists we have the bookId to delete now, send another SQL query
//            String sql = "DELETE FROM inventory WHERE book_id = ?";
//            jdbcTemplate.update(sql, bookToDeleteId);
//        }
//        else{
//            throw new BookNotFoundException();
//        }
//
//    }


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
        book.setReadingListId(results.getInt("list_id"));
        //book.setUserId(results.getInt("user_id"));

        return book;
    }

    public void deleteBook(Book book, int userId) throws BookNotFoundException {

        int bookId = book.getBookId();
        int listId = book.getReadingListId();

        String sql = "SELECT * " +
                "FROM master_table " +
                "WHERE list_id = ? AND book_id = ? AND user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, listId, bookId, userId);

        if(results.next()){
            //if it exists we have the bookId to delete now, send another SQL query
            String deleteSql = "DELETE FROM master_table WHERE list_id = ? AND book_id = ? AND user_id = ?;";
            jdbcTemplate.update(deleteSql, listId, bookId, userId);
        }
        else{
            throw new BookNotFoundException();
        }

    }
}

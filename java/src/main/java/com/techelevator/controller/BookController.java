package com.techelevator.controller;

//import com.techelevator.model.HomeNotFoundException;
//import com.techelevator.model.Home;
import com.techelevator.dao.BookDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import com.techelevator.model.BookNotFoundException;
import com.techelevator.model.ReadingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class BookController {

    @Autowired
    private BookDAO dao;
    @Autowired
    private UserDao userDao;


    @RequestMapping(path="/hello", method= RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }


    /**
     * Return all books
     *
     * @return List<Book>  -  a list of all books in the user's reading list
     */

    @RequestMapping(path = "/mybooks", method = RequestMethod.GET)
    public List<Book> retrieveAllBooks(Principal principal) {
        return dao.retrieveAllBooks(userDao.findIdByUsername(principal.getName()));
    }

    /**
     *
     * @param principal
     * @return List<Book> - retrieve one of the user's custom reading lists
     */
//    @RequestMapping(path = "/mybooks", method = RequestMethod.GET)
//    public List<Book> retrieveCustomList(Principal principal, int listId) {
//        return dao.retrieveCustomList(userDao.findIdByUsername(principal.getName()), listId);
//    }


    /**
     * Add a new book to reading list, same page @/mybooks
     *
     * @return 201 Created if successful
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/mybooks", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book, Principal principal) {
        dao.addBook(book, userDao.findIdByUsername(principal.getName()));
    }



    /**
     * Add a new book to reading list, same page @/mybooks
     *
     * @return 201 Created if successful
     */
//    @RequestMapping(path = "/readinglists", method = RequestMethod.GET)
//    public ReadingList retrieveList(@RequestBody ReadingList listName) {
//        dao.createList(listName);
//    }

//    @RequestMapping(path = "/mybooks/{bookId}", method = RequestMethod.GET)
//    public Book retrieveBookByID(@PathVariable String bookId) throws BookNotFoundException {
//        return null;
//        //return dao.retrieveHomeByMLSId(mlsId);
//    }

    /** Retrieve a specific reading list
     *
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/readinglists", method = RequestMethod.POST)
    public void createList(@RequestBody ReadingList listName) {
        dao.createList(listName);
    }


    /**
     * Deletes a book from the reading list, same page @/mybooks / ID
     *
     * @return 204 Created if successful
     */

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/mybooks/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable int bookId, Principal principal) throws BookNotFoundException {
        dao.deleteBook(bookId, principal);
    }



}

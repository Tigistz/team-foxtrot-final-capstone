package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookAlreadyExistsException;
import com.techelevator.model.BookNotFoundException;
import com.techelevator.model.ReadingList;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

public interface BookDAO {

    void addBook(Book newBook, int userId) throws BookAlreadyExistsException;
    //void deleteBook(Book book, int userId) throws BookNotFoundException;
    void deleteBook(int listId, int bookId, int userId) throws BookNotFoundException;
    List<Book> retrieveAllBooks(int userId); //TODO include the principal user
    int createList(Principal principal,ReadingList listName);
    List<ReadingList> retrieveReadingLists(Principal principal);
    void updateBookList(Book bookToUpdate, int userId);
    //Maybe we retrieve by ID but never specified by our product owner

}

package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookAlreadyExistsException;
import com.techelevator.model.BookNotFoundException;

import java.security.Principal;
import java.util.List;

public interface BookDAO {

    void addBook(Book newBook, int userId) throws BookAlreadyExistsException;
    void deleteBook(int bookId, Principal principal) throws BookNotFoundException;
    List<Book> retrieveAllBooks(int userId); //TODO include the principal user
    int createList(String listName);
    //Maybe we retrieve by ID but never specified by our product owner

}

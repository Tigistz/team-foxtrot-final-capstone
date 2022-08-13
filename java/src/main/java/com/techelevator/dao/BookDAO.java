package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookNotFoundException;

import java.security.Principal;
import java.util.List;

public interface BookDAO {

    Book addBook(Book newBook, Principal principal);
    void deleteBook(int bookId, Principal principal) throws BookNotFoundException;
    List<Book> retrieveAllBooks(Principal principal); //TODO include the principal user
    //Maybe we retrieve by ID but never specified by our product owner

}

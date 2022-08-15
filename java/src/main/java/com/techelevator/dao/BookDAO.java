package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookNotFoundException;

import java.security.Principal;
import java.util.List;

public interface BookDAO {

    Book addBook(Book newBook, int userId);
    void deleteBook(int bookId, Principal principal) throws BookNotFoundException;
    List<Book> retrieveAllBooks(int userId); //TODO include the principal user
//    List<Book> retrieveCustomList(int userId, int listId);
    //Maybe we retrieve by ID but never specified by our product owner

}

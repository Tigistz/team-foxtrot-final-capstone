package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookNotFoundException;

import java.util.List;

public interface BookDAO {

    Book addBook(Book newBook);
    void deleteBook(int bookId) throws BookNotFoundException;
    List<Book> retrieveAllBooks(); //TODO include the principal user
    //Maybe we retrieve by ID but never specified by our product owner

}

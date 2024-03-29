package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book not found.")
public class BookNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public BookNotFoundException(){
        super("Book Not Found");
    }

}

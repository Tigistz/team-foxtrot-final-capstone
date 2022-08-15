package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.I_AM_A_TEAPOT, reason = "Book Already Exists.")  //different status code
public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException (){super("Book Already Exists");}
}

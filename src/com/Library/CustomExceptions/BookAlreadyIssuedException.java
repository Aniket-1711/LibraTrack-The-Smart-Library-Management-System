package com.Library.CustomExceptions;

public class BookAlreadyIssuedException extends Exception{
    public BookAlreadyIssuedException(String message){
        super(message);
    }
}

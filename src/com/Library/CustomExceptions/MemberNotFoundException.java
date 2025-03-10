package com.Library.CustomExceptions;

public class MemberNotFoundException extends Exception {
    public MemberNotFoundException(String message){
        super(message);
    }
}

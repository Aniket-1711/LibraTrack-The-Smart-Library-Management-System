package com.Library.Interfaces;

import com.Library.Classes.Book;
import com.Library.CustomExceptions.*;
public interface UserActions {
    public void viewAllBooks();
    public void borrowBook(Book book) throws BookNotFoundException;
    public void returnBook(Book book) throws BookNotFoundException,MemberNotFoundException;
}

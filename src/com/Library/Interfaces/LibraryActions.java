package com.Library.Interfaces;

import com.Library.Classes.Book;
import com.Library.CustomExceptions.BookNotFoundException;

public interface LibraryActions {
    public void viewAllBooks();
    public void addBook(Book book);
    public void removeBook(Book book) throws BookNotFoundException;
    public void viewBorrowedBooks();
    Book findBookById(String id) throws BookNotFoundException;
}

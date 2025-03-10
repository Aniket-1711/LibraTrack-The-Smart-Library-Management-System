package com.Library.Classes;

import com.Library.CustomExceptions.BookNotFoundException;
import com.Library.Interfaces.LibraryActions;

import java.util.ArrayList;
import java.util.List;

public class Librarian implements LibraryActions {
    private String librarainId,name;
    private List<Book> managedBooks;
    public Librarian(String librarainId,String name){
        this.librarainId=librarainId;
        this.name=name;
        this.managedBooks=new ArrayList<>();
    }

    //getters
    public String getLibrarainId(){
        return librarainId;
    }

    public String getName(){
        return name;
    }

    @Override
    public void viewAllBooks() {
        System.out.println("Books available in the library are: ");
        if(managedBooks.isEmpty()){
            System.out.println("No books currently available in the library");
            return;
        }
        for(Book book: managedBooks){
            book.display();
        }
    }

    @Override
    public void addBook(Book book) {
        managedBooks.add(book);
        System.out.println(book.getTitle() + " has been added to the library.");
    }

    @Override
    public void removeBook(Book book) throws BookNotFoundException {
        if(managedBooks.contains(book)){
            managedBooks.remove(book);
            System.out.println(book.getTitle()+" has been removed from the library");
        }
        else{
            throw new BookNotFoundException("Book not found in the library to remove");
        }
    }

    @Override
    public Book findBookById(String id) throws BookNotFoundException {
        for(Book book:managedBooks){
            if(book.getId().equals(id)){
                return book;
            }
        }
        throw new BookNotFoundException("Cannot find the specified book with ID: "+id);
    }

    @Override
    public void viewBorrowedBooks() {
        System.out.println("Books borrowed are: ");
        boolean hasBorrowedBooks=false;
        for(Book book:managedBooks){
            int totalCopies=book.getTotalCopies();
            int availableCopies=book.getAvailableCopies();
            if(availableCopies<totalCopies){
                System.out.println(book.getTitle() + " (Borrowed copies: " + (totalCopies - availableCopies) + ")");
                System.out.println("Borrowed by:");
                for(Member member: book.getBorrowedBy()){
                    System.out.println("- " + member.getName());
                }
                hasBorrowedBooks=true;
            }
        }
        if(!hasBorrowedBooks){
            System.out.println("No books are borrowed yet");
        }
    }

    public void displayLibrarianInfo(){
        System.out.println("ID: "+librarainId+"\nName: "+name);
    }
}

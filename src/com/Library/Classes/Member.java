package com.Library.Classes;

import java.util.*;

import com.Library.CustomExceptions.BookNotFoundException;
import com.Library.CustomExceptions.MemberNotFoundException;
import com.Library.Interfaces.UserActions;

public class Member implements UserActions {
    private String memberId,name;
    private List<Book> borrowedBooks=null;
    public Member(String memberId,String name){
        this.memberId=memberId;
        this.name=name;
        this.borrowedBooks=new ArrayList<>();
    }

    public String getMemberId(){
        return memberId;
    }
    public String getName(){
        return name;
    }

    @Override
    public void viewAllBooks() {
        System.out.println(name+" 's borrowed books: ");
        if(borrowedBooks.isEmpty()){
            System.out.println("No books borrowed");
        }
        else{
            for(Book book: borrowedBooks){
                book.display();
            }
        }
    }

    @Override
    public void borrowBook(Book book) throws BookNotFoundException {
        if(borrowedBooks.size()>=5){
            System.out.println("You have already borrowed the maximum no of books.Can't borrow more than 5");
            return ;
        }
        if(book.getAvailableCopies()>0){
            if(borrowedBooks.contains(book)){
                System.out.println("You have already borrowed this book.");
                return;
            }
            borrowedBooks.add(book);
            book.borrowCopy(this);
            System.out.println(name + " has borrowed: " + book.getTitle());
        }
        else{
            throw new BookNotFoundException("Book currently not available for borrowing.");
        }
    }

    @Override
    public void returnBook(Book book) throws BookNotFoundException, MemberNotFoundException {
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.returnCopy(this);
            System.out.println(name + " has returned: " + book.getTitle());
        }
        else{
            throw new BookNotFoundException("This book wasn't borrowed by the member.");
        }
    }
    public void displayMemberInfo(){
        System.out.println("ID: "+memberId+"\nName: "+name);
    }


}

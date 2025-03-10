package com.Library.Classes;

import java.util.ArrayList;
import java.util.List;

public class Book {
   private String id,title,author;
   private boolean isAvailable;
   private int totalCopies,availableCopies;
   private List<Member> borrowedBy;
   public Book(String id,String title,String author,int totalCopies){
       this.id=id;
       this.title=title;
       this.author=author;
       this.totalCopies=totalCopies;
       this.isAvailable=true;
       this.availableCopies=totalCopies;
       this.borrowedBy=new ArrayList<>();
   }
   public String getId(){
       return id;
   }
   public String getTitle(){
       return title;
   }
   public String getAuthor(){
       return author;
   }

   public int getTotalCopies()
   {
       return totalCopies;
   }

   public int getAvailableCopies(){
       return availableCopies;
   }

    public List<Member> getBorrowedBy(){
        return borrowedBy;
    }

   public void borrowCopy(Member member){
       if(availableCopies>0){
           availableCopies--;
           borrowedBy.add(member);
       }
       else{
           System.out.println("No copies available for borrowing");
       }
   }

   public void returnCopy(Member member) {
       if (borrowedBy.contains(member)) {
           availableCopies++;
           borrowedBy.remove(member);
       }
   }

   public void display(){
       System.out.println("Book ID: "+id);
       System.out.println("Book Title: "+title);
       System.out.println("Book Author: "+author);
       System.out.println("Available: "+(isAvailable ? "Yes" : "No"));
   }
}

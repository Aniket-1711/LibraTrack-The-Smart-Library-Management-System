package com.Library.Classes;

import com.Library.CustomExceptions.BookNotFoundException;
import com.Library.CustomExceptions.MemberNotFoundException;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String args[]) {
        List<Member> members = new ArrayList<>();
        List<Librarian> librarians = new ArrayList<>();
        List<Book> books = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        boolean running = true;
        int ch;

        System.out.println("Welcome to Library Management System: ");
        System.out.println("Here's your menu: ");
        System.out.println("1. Add Librarian");
        System.out.println("2. Add Member");
        System.out.println("3. Add Book (Librarian Only)");
        System.out.println("4. Remove Book (Librarian Only)");
        System.out.println("5. Borrow Book (Member Only)");
        System.out.println("6. Return Book (Member Only)");
        System.out.println("7. View All Books");
        System.out.println("8. View Borrowed Books(Librarian only)");
        System.out.println("9. Exit");
        while (running) {
            System.out.println("Enter your choice: ");
            ch = s.nextInt();
            s.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("Enter librarian ID: ");
                    String librarianId = s.nextLine();
                    System.out.println("Enter librarian name: ");
                    String librarianName = s.nextLine();
                    Librarian lib = new Librarian(librarianId, librarianName);
                    System.out.println("Librarian added successfully");
                    lib.displayLibrarianInfo();
                    librarians.add(lib);
                    break;

                case 2:
                    System.out.println("Enter Member ID: ");
                    String memberId = s.nextLine();
                    System.out.println("Enter member name: ");
                    String memberName = s.nextLine();
                    Member mem = new Member(memberId, memberName);
                    System.out.println("Member added successfully");
                    mem.displayMemberInfo();
                    members.add(mem);
                    break;

                case 3:
                    System.out.println("Enter librarian id: ");
                    String lbid = s.nextLine();
                    boolean isLibrarianFound = false;
                    boolean isBookAdded = false;
                    for (Librarian librarian : librarians) {
                        if (librarian.getLibrarainId().equals(lbid)) {
                            isLibrarianFound = true;
                            System.out.println("Enter book details to add: (id,title,author,total copies)");
                            String bId = s.nextLine();
                            String bTitle = s.nextLine();
                            String bAuthor = s.nextLine();
                            int bTotalcopies = s.nextInt();
                            s.nextLine();
                            Book book = new Book(bId, bTitle, bAuthor, bTotalcopies);
                            librarian.addBook(book);
                            books.add(book);
                            isBookAdded = true;
                            break;
                        }
                    }
                    if (!isLibrarianFound) {
                        System.out.println("Cannot add book.Access only to librarians.");
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Enter librarian id: ");
                    String lid = s.nextLine();
                    boolean isBookRemoved = false;
                    boolean isLibrarianFound1 = false;
                    for (Librarian librarian : librarians) {
                        if (librarian.getLibrarainId().equals(lid)) {
                            isLibrarianFound1 = true;
                            System.out.println("Enter book details id to remove: ");
                            String bId = s.nextLine();
                            try {
                                Book book = librarian.findBookById(bId);
                                books.remove(book);
                                librarian.removeBook(book);
                                isBookRemoved=true;
                            }
                            catch (BookNotFoundException be){
                                System.out.println(be.getMessage());
                            }
                            if (!isBookRemoved) {
                                System.out.println("Book not found.Cannot remove book");
                            }
                        }
                    }
                    if (!isLibrarianFound1) {
                        System.out.println("No access to remove book.Access to librarians only.");
                    }
                    break;
                case 5:
                    System.out.println("Enter the member id: ");
                    String memberIdBorrow = s.nextLine();
                    boolean isMemberFound = false;
                    for (Member member : members) {
                        if (member.getMemberId().equals(memberIdBorrow)) {
                            isMemberFound = true;
                            System.out.println("Enter the book ID to borrow: ");
                            String bookIdBorrow = s.nextLine();
                            boolean isBookFound = false;
                            for (Book book : books) {
                                if (book.getId().equals(bookIdBorrow)) {
                                    isBookFound = true;
                                    try {
                                        member.borrowBook(book);
                                        break;
                                    } catch (BookNotFoundException be) {
                                        System.out.println(be.getMessage());

                                    }
                                }
                            }
                            if (!isBookFound) {
                                System.out.println("Book Id not found.Cannot borrow book with id: " + bookIdBorrow);
                            }
                        }
                    }
                    if (!isMemberFound) {
                        System.out.println("Member not found.Cannot borrow book.");
                    }
                    break;
                case 6:
                    System.out.println("Enter the member id: ");
                    String memberIdReturn = s.nextLine();
                    boolean isMemberFoundReturn = false;
                    for (Member member : members) {
                        if (member.getMemberId().equals(memberIdReturn)) {
                            isMemberFoundReturn = true;
                            System.out.println("Enter the book ID to return: ");
                            String bookIdReturn = s.nextLine();
                            boolean isBookFound = false;
                            for (Book book : books) {
                                if (book.getId().equals(bookIdReturn)) {
                                    isBookFound = true;
                                    try {
                                        member.returnBook(book);

                                        break;
                                    } catch (BookNotFoundException be) {
                                        System.out.println(be.getMessage());
                                    } catch (MemberNotFoundException me) {
                                        System.out.println(me.getMessage());
                                    }
                                }
                            }
                            if (!isBookFound) {
                                System.out.println("Book Id not found.Cannot return book with id: " + bookIdReturn);
                            }
                        }
                    }
                    if (!isMemberFoundReturn) {
                        System.out.println("Member not found.Cannot borrow book.");
                    }
                    break;
                case 7:
                    System.out.println("Viewing all the available books: ");
                    System.out.println("Enter member id: ");
                    String memberIdView = s.nextLine();
                    boolean isMemberFoundView = false;
                    for (Member member : members) {
                        if (member.getMemberId().equals(memberIdView)) {
                            isMemberFoundView = true;
                            System.out.println("Enter librarian reference id: ");
                            String librarianRefernceId = s.nextLine();
                            boolean isLibrarianId = false;
                            for (Librarian librarian : librarians) {
                                if (librarian.getLibrarainId().equals(librarianRefernceId)) {
                                    isLibrarianId = true;
                                    librarian.viewAllBooks();
                                    break;
                                }
                            }
                            if (!isLibrarianId) {
                                System.out.println("Invalid reference id.Cannot display available books in the library");
                            }
                        }
                    }
                    if (!isMemberFoundView) {
                        System.out.println("Member not found.Cannot display available books.");
                    }
                    break;
                case 8:
                    System.out.println("Enter librarian id: ");
                    String librarianIdBorrowList = s.nextLine();
                    boolean isValidLibrarianId = false;
                    for (Librarian librarian : librarians) {
                        if (librarian.getLibrarainId().equals(librarianIdBorrowList)) {
                            isValidLibrarianId = true;
                            librarian.viewBorrowedBooks();
                            break;
                        }
                    }
                    if (!isValidLibrarianId) {
                        System.out.println("Invalid librarian id.Cannot view borrowed books list.");
                    }
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    running=false;
                    return;
                default:
                    System.out.println("Invalid choice.Choose options from menu.");
            }
        }
    }
}

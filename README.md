# 📚 Library Management System

Welcome to the **Library Management System**! This Java-based project efficiently manages books, librarians, and members while ensuring a structured and well-organized codebase. 🏛️💻

## 🚀 Features

- 📖 **Book Management**: Add, remove, and search for books.
- 👥 **User Management**: Handles librarians and members dynamically.
- 🔍 **Borrow & Return**: Tracks book issuance and returns.
- ⚠️ **Custom Exceptions**: Ensures robust error handling.
- 🏗️ **Scalable Design**: Built with flexibility for future enhancements.

## 🏗️ Project Structure

The project follows a **well-structured package design**, ensuring maintainability and modularity.

```
com.Library
│── Classes         # Core entities (Book, Member, Librarian)
│── Interfaces      # Defines behaviors (LibraryActions, UserActions)
│── CustomExceptions # Handles errors (BookNotFoundException, etc.)
│── Main            # Runs the application
```

### 📦 **Packages & Naming Conventions**

✅ **CamelCase Naming:** Used for class names (e.g., `BookAlreadyIssuedException`).\
✅ **Meaningful Identifiers:** Variables and methods have self-explanatory names.\
✅ **Consistent Structure:** Packages separate concerns (e.g., `Interfaces` define behaviors, `CustomExceptions` handle errors).

## 📝 Interfaces & Custom Exceptions

### 🛠️ **Interfaces**

1. **LibrarianActions** 📚

   - `viewAllBooks()`: Displays available books.
   - `addBook(Book book)`: Adds a new book.
   - `removeBook(Book book)`: Removes a book (throws `BookNotFoundException`).
   - `viewBorrowedBooks()`: Lists all borrowed books.
   - `findBookById(String id)`: Searches for a book (throws `BookNotFoundException`).

2. **UserActions** 👤

   - `viewAllBooks()`: Displays books to users.
   - `borrowBook(Book book)`: Issues a book (throws `BookNotFoundException`).
   - `returnBook(Book book)`: Returns a book (throws `BookNotFoundException`, `MemberNotFoundException`).

### ⚠️ **Custom Exceptions**

- `BookAlreadyIssuedException` 📕: Triggered when a book is already issued.
- `BookNotFoundException` 🔎: Thrown when a book is not found.
- `MemberNotFoundException` 🙍‍♂️: Raised when a member is missing.

## 🔮 Future Enhancements

✨ **GUI Support**: Implement a Swing/JavaFX interface.\
✨ **Database Integration**: Store books and members persistently.\
✨ **Admin Controls**: Advanced features for librarians.

## 🎯 Conclusion

This **Library Management System** is designed using **OOP principles** and **clean code practices**, making it easy to scale and maintain. Feel free to contribute or customize it as per your needs! 🏆📖🚀


# Library Management System

## Overview

The Library Management System is a simple Java application designed to manage books and library members. It includes functionality for borrowing and returning books, and it demonstrates basic Object-Oriented Programming (OOP) concepts such as inheritance, polymorphism, encapsulation, and abstraction.

### Features

- **Book Management**: Manage book details and availability.
- **Library Members**: Handle different types of members (Students and Faculty) with specific borrowing limits.
- **Borrowing and Returning Books**: Allow members to borrow and return books.
- **Flexible Configuration**: Easy to extend and customize the system.

## Classes

- **Book**: Represents a book with attributes like title, author, ISBN, and available copies. Includes methods for updating book details and managing availability.
  
- **LibraryMember (Abstract Class)**: Defines common properties and methods for library members. It includes abstract methods for borrowing and returning books.
  
- **Student**: A subclass of `LibraryMember` that represents a student member. Has a limit on the number of books they can borrow.
  
- **Faculty**: A subclass of `LibraryMember` that represents a faculty member. Has a higher limit on the number of books they can borrow.
  
- **Library**: Manages the collection of books. Includes methods to add, remove, and find books.

- **Main**: The entry point of the application that demonstrates the functionality of the library system.


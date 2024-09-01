// Features:
//1.  Book Management:
// Add, remove, and update book details.
// Track available copies.

// 2. User Management:
//Register new users (students, faculty).
// User roles with different permissions (e.g., faculty can borrow more books than students).

//3. Borrowing and Returning:
// Borrow books (with conditions on how many and for how long).
// Return books and calculate fines for late returns.

//4. Search Functionality:
// Search for books by title, author, or ISBN.

//5.Report Generation:
// Generate reports on borrowed books, users with overdue books, etc.


// Classes:

// Library (manages overall operations)
// Book (represents a book in the library)
// User (base class for Student and Faculty)
// Student (inherits from User)
// Faculty (inherits from User)
// BorrowTransaction (tracks borrowing details)
// ReturnTransaction (tracks return details)

// Book.java
import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private int availableCopies;
    
    // create a constructor for book class

    public Book(String title, String author, String isbn, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }

    // getter and setter since getauthor is PRIVATE..
    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
    // getter and setter since getAvailableCopies is PRIVATE..
    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    // overloading polymorphism

    public void updateDetails(String title) {
        this.title = title;
    }

    public void updateDetails(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

// LibraryMember abstract class
abstract class LibraryMember {

    // protected  ...accessible to this package and subclass of another package
    protected String name;
    protected int memberId;
    
    // constructor...

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // abstract methods defining this class can do several methods......

    public abstract void borrowBook(Book book);
    public abstract void returnBook(Book book);
}

// Student class----inheritence..........
class Student extends LibraryMember {
    private int maxBooksAllowed = 3;

    private List<Book> borrowedBooks = new ArrayList<>();
    
    // constructor........

    public Student(String name, int memberId) {
        super(name, memberId);
    }

    //  method overriding polymorphism
    
    @Override
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < maxBooksAllowed) {
            borrowedBooks.add(book);
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println(name + " cannot borrow more than " + maxBooksAllowed + " books.");
        }
    }
    
    //  method overriding polymorphism

    @Override
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(name + " returned: " + book.getTitle());
    }
}

// Faculty class--inheritance
class Faculty extends LibraryMember {
    private int maxBooksAllowed = 5;
    private List<Book> borrowedBooks = new ArrayList<>();
    // constructor---parametrised----
    public Faculty(String name, int memberId) {
        super(name, memberId);
    }

    // method overriding polymorphism
    
    @Override
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < maxBooksAllowed) {
            borrowedBooks.add(book);
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println(name + " cannot borrow more than " + maxBooksAllowed + " books.");
        }
    }
    
    // method overriding polymorphism

    @Override
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(name + " returned: " + book.getTitle());
    }
}

// Library class
class Library {
    //  books list globally assigned  and can be accessed in any below class
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Book removed: " + book.getTitle());
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Additional methods if needed
}

// Main class to run the application
public class Main {
    public static void main(String[] args) {
        // creating objects of Library class......
        Library library = new Library();
        
        // creating objects of  Book  class......
        // Create some books
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991", 5);
        Book book2 = new Book("Clean Code", "Robert C. Martin", "978-0132350884", 3);
        
        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        
        // Create some users
        LibraryMember student = new Student("John Doe", 101);
        LibraryMember faculty = new Faculty("Dr. Smith", 201);
        
        // Borrow books
        student.borrowBook(book1);
        faculty.borrowBook(book2);
        
        // Return books
        student.returnBook(book1);
        faculty.returnBook(book2);
    }
}







// Uploading to GitHub:
// Create a Repository: Create a new repository on GitHub and give it a name like "Library-Management-System".
// Organize Code: Structure your project with directories like src for source code, test for unit tests, and docs for documentation.
// Write README.md: Include a README.md file explaining the project, its structure, how to run it, and which OOP concepts are covered.
// Version Control: Commit your code and push it to the GitHub repository.
// Extensions (Optional):
// GUI: Add a graphical user interface using JavaFX or Swing.
// Web Application: Convert the project into a web application using frameworks like Spring Boot.
// Database Integration: Use MySQL or SQLite to persist data about books, users, and transactions.
// This project will help you understand and demonstrate the full range of OOP concepts in a practical, real-world application
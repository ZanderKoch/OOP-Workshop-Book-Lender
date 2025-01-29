package se.lexicon.model;


/**
 * This class represents a Book model with properties and methods
 * to manage book-related information and operations.
 */
public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public Book(String title, String author, Person borrower) {
        this.title = title;
        this.author = author;
        this.available = false;
        this.borrower = borrower;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
    }
    public String getBookInformation(){
    return "Book{title='" + title + '\'' + ", author='" + author + '\'' + ", available=" + available + ", borrower="
            + (borrower != null ? borrower.getFirstName() + " " + borrower.getLastName() : "None") + '}';
    }
}

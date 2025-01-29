package se.lexicon.model;

import java.util.List;

/**
 * This class represents a Person model with properties and methods
 * to manage personal details and interactions with the library system.
 */
public class Person {
    private static int sequencer = 0;
    private int id;
    private String firstName;
    private String lastName;
    private Book[] borrowing;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = getNextId();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private static int getNextId(){
        return ++sequencer;
    }

    public void loanBook(Book book) {
        if (book == null || !book.isAvailable()) {
            throw new IllegalArgumentException("Book is not available for borrowing.");
        }

        // Handle possible null `borrowing` array
        if (borrowing == null) {
            borrowing = new Book[1];  // Initialize with space for one book
        } else {
            borrowing = resizeArray(borrowing, borrowing.length + 1);
        }

        borrowing[borrowing.length - 1] = book;
        book.setBorrower(this);
        book.setAvailable(false);
        System.out.println("Book borrowed: " + book.getTitle());
    }

    public void returnBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        int bookIndex = findBookIndex(book);
        if (bookIndex == -1) {
            throw new IllegalStateException("This person did not borrow this book.");
        }

        borrowing[bookIndex] = null;
        book.setBorrower(null);
        book.setAvailable(true);
        borrowing = compactArray(borrowing);
        System.out.println("Book returned: " + book.getTitle());
    }

    private int findBookIndex(Book book) {
        for (int i = 0; i < borrowing.length; i++) {
            if (borrowing[i] != null && borrowing[i].equals(book)) {
                return i;
            }
        }
        return -1;
    }

    private Book[] resizeArray(Book[] original, int newSize) {
        Book[] newArray = new Book[newSize];
        for (int i = 0; i < Math.min(original.length, newSize); i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

    private Book[] compactArray(Book[] original) {
        int count = 0;
        for (Book book : original) {
            if (book != null) count++;
        }
        Book[] compacted = new Book[count];
        int index = 0;
        for (Book book : original) {
            if (book != null) {
                compacted[index++] = book;
            }
        }
        return compacted;
    }

    public String getPersonInformation() {
        StringBuilder sb = new StringBuilder("Person{id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", borrowedBooks=[");

        if (borrowing != null) {
            boolean hasBooks = false;
            for (Book book : borrowing) {
                if (book != null) {
                    if (hasBooks) sb.append(", ");
                    sb.append(book.getTitle());
                    hasBooks = true;
                }
            }
        }

        sb.append("]}");
        return sb.toString();
    }


}
package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // Initialize and display Book & Person instances
        Book disc = new Book("The Colour of Magic", "Terry Pratchett");
        Book killers = new Book("The Killers", "Ernest Hemingway");
        Book crime = new Book("Crime and Punishment", "Fyodor Dostoevsky");
        Person person1 = new Person("Zander", "Koch");

        System.out.println(disc.getBookInformation());
        System.out.println(killers.getBookInformation());
        System.out.println(crime.getBookInformation());
        System.out.println(person1.getPersonInformation());
        System.out.println();

        // Simulate borrowing a book
        person1.loanBook(killers);
        person1.loanBook(disc);

        System.out.println(disc.getBookInformation());
        System.out.println(killers.getBookInformation());
        System.out.println(crime.getBookInformation());
        System.out.println(person1.getPersonInformation());
        System.out.println();

        // Simulate returning a book
        person1.returnBook(killers);

        System.out.println(disc.getBookInformation());
        System.out.println(killers.getBookInformation());
        System.out.println(crime.getBookInformation());
        System.out.println(person1.getPersonInformation());
        System.out.println();
    }

}

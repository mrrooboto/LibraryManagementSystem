package LibraryManagementSystem.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LibrarySystem {
    Scanner sc = new Scanner(System.in);
    Book book = new Book();
    protected List<Book> availableBooks = new ArrayList<>();
    protected List<Book> unavailableBooks = new ArrayList<>();

    public LibrarySystem() { //Basic constructor for instantiation
    }

    //TODO  Write a function to add a new book FINISHED
    public void addBook() {

        System.out.println("Enter the title of the book: ");
        do {
            book.setTitle(sc.nextLine());
            if (book.getTitle().isEmpty()) {
                System.out.println("Cannot be blank!");
                System.out.println("Enter the title of the book: ");
            }
        } while (book.getTitle().isEmpty());

        System.out.println("Enter the author of the book: ");
        do {
            book.setAuthor(sc.nextLine());
            if (book.getAuthor().isEmpty()) {
                System.out.println("Cannot be blank!");
                System.out.println("Enter the author of the book: ");
            }
        } while (book.getAuthor().isEmpty());

        System.out.println("Enter the ISBN: ");

        do {
            book.setISBN(sc.nextLine());
            if (book.getISBN().isEmpty() || book.getISBN().matches("[A-Za-z]+")) {
                System.out.println("Cannot be blank or contain characters! \nEnter the ISBN:");
            }
        } while (book.getISBN().isEmpty() || book.getISBN().matches("[A-Za-z]+"));

        System.out.println("Book added successfully! \n");
        Book newBook = new Book(book.getTitle(), book.getAuthor(), book.getISBN(), true);
        availableBooks.add(newBook);
        System.out.println();

        //function to add a book to arraylist and set availability to "true"
        //adding a book will require to enter a title, author and ISBN
    }

    //TODO  Function to remove a book FINISHED
    public void removeBook() {
        System.out.println("Enter the title of the book: ");
        do {
            book.setTitle(sc.nextLine());
            if (book.getTitle().isEmpty()) {
                System.out.println("Cannot be blank!");
                System.out.println("Enter the title of the book: ");
            }
        } while (book.getTitle().isEmpty());

        System.out.println("Enter the author of the book: ");
        do {
            book.setAuthor(sc.nextLine());
            if (book.getAuthor().isEmpty()) {
                System.out.println("Cannot be blank!");
                System.out.println("Enter the author of the book: ");
            }
        } while (book.getAuthor().isEmpty());

        System.out.println("Enter the ISBN: ");
        do {
            book.setISBN(sc.nextLine());
            if (book.getISBN().isEmpty() || book.getISBN().matches("[A-Za-z]")) {
                System.out.println("Cannot be blank or contain characters! \nEnter the ISBN: ");
            }
        } while (book.getISBN().isEmpty() || book.getISBN().matches("[A-Za-z]"));

        for (Book availableBook : availableBooks) {
            if (    availableBook.getTitle().equals(book.getTitle()) &&
                    availableBook.getAuthor().equals(book.getAuthor()) &&
                    availableBook.getISBN().equals(book.getISBN())) {
                availableBooks.remove(availableBook); // Remove the matching book from arrayList
                System.out.println("Book removed successfully! \n");
                break; //Exit loop once match is found
            } else {
                System.out.println("Wrong data entered!");
            }
        }

        //function to remove title, author and ISBN from lists also set availability to false
    }

    //TODO  Function to Display available books (All the books) FINISHED
    public void showAvailableBooks() {
        System.out.println("Available books: ");
        System.out.println();
        for (Book availableBook : availableBooks) {
            System.out.println("Title: " + availableBook.getTitle());
            System.out.println("Author: " + availableBook.getAuthor());
            System.out.println("ISBN: " + availableBook.getISBN());
            System.out.println();
        }

        if (availableBooks.isEmpty()) {
            System.out.println("No books available.");
        }
        System.out.println();
        //function to see all the available books and print them out the same way
        //as when they are entered
    }

    //TODO  Function to check out a book FINISHED
    public void checkOutBook() {
        System.out.println("Enter the title or ISBN of the book you want to check out: ");
        String titleOrIBSN = sc.nextLine();
        boolean bookFound = false;

        for (Book availableBook : availableBooks) {
            if (availableBook.getTitle().equals(titleOrIBSN) || availableBook.getISBN().equals(titleOrIBSN)) {
                availableBook.setAvailable(false);
                unavailableBooks.add(availableBook);
                availableBooks.remove(availableBook);
                System.out.println("Book checked out successfully!");
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book not found or already checked out.");
        }

    }

    //TODO  Return a book FINISHED

    public void returnBook() {
        System.out.println("Enter the title or ISBN of the book you want to return: ");
        String titleOrISBN = sc.nextLine();
        boolean bookFound = false;

        for (Book unavailableBook : unavailableBooks) {
            if (unavailableBook.getTitle().equals(titleOrISBN) || unavailableBook.getISBN().equals(titleOrISBN)) {
                unavailableBook.setAvailable(true);
                availableBooks.add(unavailableBook);
                unavailableBooks.remove(unavailableBook);
                System.out.println("Book returned successfully!");
                bookFound = true;
                break;                      //NOT TESTED BUT WILL PROBABLY HAVE THE SAME ISSUE
            }
        }
        if (!bookFound) {
            System.out.println("We are not waiting such book to be returned.");
        }
    }

    //TODO  Finally to Exit the program
    public void exitSystem() {
        System.out.println("Quitting app.");
    }
}

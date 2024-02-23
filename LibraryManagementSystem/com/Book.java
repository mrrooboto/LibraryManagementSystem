package LibraryManagementSystem.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Book {
    Scanner sc = new Scanner(System.in);
    private String title;       // Book name
    private String author;      // Who wrote the book
    private String ISBN = "";   // ISBN stands for product identifier

    protected List<String> titles = new ArrayList<>();              //
    protected List<String> authors = new ArrayList<>();             //  Lists for the data
    protected List<String> ISBNs = new ArrayList<>();               //
    protected List<String> checkedOutTitles = new ArrayList<>();    //
    protected List<String> checkedOutAuthors = new ArrayList<>();   //
    protected List<String> checkedOutISBNs = new ArrayList<>();     //
    public Book() { //Basic constructor for instantiation

    }

    //TODO  Write a function to add a new book
    public void addBook() {

        System.out.println("Enter the title of the book: ");
        do {
            title = sc.nextLine();
            if (title.isEmpty()) {
                System.out.println("Cannot be blank!");
                System.out.println("Enter the title of the book: ");
            }
        } while (title.isEmpty());
        titles.add(title);

        System.out.println("Enter the author of the book: ");
        do {
            author = sc.nextLine();
            if (author.isEmpty()) {
                System.out.println("Cannot be blank!");
                System.out.println("Enter the author of the book: ");
            }
        } while (author.isEmpty());
        authors.add(author);

        System.out.println("Enter the ISBN: ");

        do {
            ISBN = sc.nextLine();
            if (ISBN.isEmpty() || ISBN.matches("[A-Za-z]+")) {
                System.out.println("Cannot be blank or contain characters! \nEnter the ISBN:");
            }
        } while (ISBN.isEmpty() || ISBN.matches("[A-Za-z]+"));

            System.out.println("Book added successfully! \n");
            ISBNs.add(ISBN);

            //function to add a book to arraylist and set availability to "true"
            //adding a book will require to enter a title, author and ISBN
        }

    //TODO  Function to remove a book FINISHED
    public void removeBook() {
        System.out.println("Enter the title of the book: ");
        do {
            title = sc.nextLine();
            if (title.isEmpty()) {
                System.out.println("Cannot be blank!");
                System.out.println("Enter the title of the book: ");
            }
        } while (title.isEmpty());
        titles.remove(title);

        System.out.println("Enter the author of the book: ");
        do {
            author = sc.nextLine();
            if (author.isEmpty()) {
                System.out.println("Cannot be blank!");
                System.out.println("Enter the author of the book: ");
            }
        } while (author.isEmpty());
        authors.remove(author);

        System.out.println("Enter the ISBN: ");
        do {
            ISBN = sc.nextLine();
            if (ISBN.isEmpty() || ISBN.matches("[A-Za-z]")) {
                System.out.println("Cannot be blank or contain characters! \nEnter the ISBN: ");
            }
        } while (ISBN.isEmpty() || ISBN.matches("[A-Za-z]"));

        System.out.println("Book removed successfully! \n");
        ISBNs.remove(ISBN);

        //function to remove title, author and ISBN from lists also set availability to false
    }

    //TODO  Function to Display available books (All the books) FINISHED
    public void showAvailableBooks() {
        System.out.println("Available books: ");
        System.out.println();
        for (int i = 0; i < titles.size(); i++) {
            System.out.println("Title: " + titles.get(i));
            System.out.println("Author: " + authors.get(i));
            System.out.println("ISBN: " + ISBNs.get(i));
            System.out.println();
        }

        if (titles.isEmpty() && authors.isEmpty() && ISBNs.isEmpty()) {
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
        int index = titles.indexOf(titleOrIBSN);
        if (index != -1) {
            checkedOutTitles.add(titles.get(index));
            checkedOutAuthors.add(authors.get(index));
            checkedOutISBNs.add(ISBNs.get(index));
            titles.remove(index);
            authors.remove(index);
            ISBNs.remove(index);
            System.out.println("Book checked out successfully!");
        } else
            System.out.println("There is no such book!");
    }

    //TODO  Return a book FINISHED

    public void returnBook() {
        System.out.println("Enter the title or ISBN of the book you want to return: ");
        String titleOrISBN = sc.nextLine();
        int index = checkedOutTitles.indexOf(titleOrISBN);
        if (index != -1) {
            titles.add(checkedOutTitles.get(index));
            authors.add(checkedOutAuthors.get(index));
            ISBNs.add(checkedOutISBNs.get(index));

            checkedOutTitles.remove(index);
            checkedOutAuthors.remove(index);
            checkedOutISBNs.remove(index);

            System.out.println("Book has been returned!");
        } else {
            System.out.println("There is no such book to be returned.");
        }
    }

    //TODO  Finally to Exit the program
    public void exitSystem() {

    }
}

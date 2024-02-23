package LibraryManagementSystem.com;

import java.util.Scanner;
import static LibraryManagementSystem.com.TextGUI.*;

public class LibraryApp {
    public static void main(String[] args) {
        Book book = new Book();
        Scanner sc = new Scanner(System.in);
        printWelcomeText();
        printOptions();
        String choice;

        do {
            System.out.println("Enter your choice: ");
            choice = sc.nextLine().trim();
            System.out.println();
            switch(choice) {
                case "1" -> book.addBook();
                case "2" -> book.removeBook();
                case "3" -> book.showAvailableBooks();
                case "4" -> book.checkOutBook();
                case "5" -> book.returnBook();
                case "6" -> book.exitSystem();
            }
            if (!choice.matches("\\d") || !choice.matches("[^7890]")) {
                System.out.println("Choice is not correct!\nTry again.");
            }
        } while (!choice.equals("6"));
    }
}

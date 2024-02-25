package LibraryManagementSystem.com;

import java.util.Scanner;
import static LibraryManagementSystem.com.TextGUI.*;

public class LibraryApp {
    public static void main(String[] args) {
        LibrarySystem Library = new LibrarySystem();
        Scanner sc = new Scanner(System.in);
        printWelcomeText();
        printOptions();
        String choice;

        do {
            System.out.println("Enter your choice: ");
            choice = sc.nextLine().trim();
            System.out.println();
            switch(choice) {
                case "1" -> Library.addBook();
                case "2" -> Library.removeBook();
                case "3" -> Library.showAvailableBooks();
                case "4" -> Library.checkOutBook();
                case "5" -> Library.returnBook();
                case "6" -> Library.exitSystem();
            }
            if (!choice.matches("\\d") || !choice.matches("[^7890]")) {
                System.out.println("Choice is not correct!\nTry again.");
            }
        } while (!choice.equals("6"));
    }
}

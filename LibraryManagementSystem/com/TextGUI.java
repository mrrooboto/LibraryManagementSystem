package LibraryManagementSystem.com;

public class TextGUI {

    static public void printWelcomeText() {
        System.out.println("""
                -----------------------------------------
                Welcome to the Library Management System!
                -----------------------------------------""");
        System.out.println();
    }
    static public void printOptions() {
        System.out.println("""
                ----------------------------
                |1. Add a new book         |
                |2. Remove a book          |
                |3. Display available books|
                |4. Check out a book       |  
                |5. Return a book          |
                |6. Exit                   |
                ----------------------------""");
        System.out.println();
    }
}

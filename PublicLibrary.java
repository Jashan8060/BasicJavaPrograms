import java.util.Scanner;

class Library {
    String[] availableBooks = new String[6];
    String[] issuedBooks = new String[6];
    Scanner sc = new Scanner(System.in);

    void addBook() {
        System.out.println("Enter the name of the book:");
        String book = sc.nextLine();
        for (int i = 0; i < availableBooks.length; i++) {
            if (availableBooks[i] == null) {
                availableBooks[i] = book;
                System.out.println("The book has been added.");
                return;
            }
        }
        System.out.println("Library is full, cannot add more books.");
    }

    void issueBook() {
        System.out.println("Enter the name of the book you want to issue:");
        String iBook = sc.nextLine();
        for (int i = 0; i < availableBooks.length; i++) {
            if (iBook.equals(availableBooks[i])) {
                for (int j = 0; j < issuedBooks.length; j++) {
                    if (issuedBooks[j] == null) {
                        issuedBooks[j] = iBook;
                        availableBooks[i] = null;
                        System.out.println("Thank you for issuing the book: " + iBook);
                        return;
                    }
                }
                System.out.println("No slot available for issued books.");
                return;
            }
        }
        System.out.println("The book is not available.");
    }

    void returnBook() {
        System.out.println("Enter the name of the book you want to return:");
        String rBook = sc.nextLine();
        for (int i = 0; i < issuedBooks.length; i++) {
            if (rBook.equals(issuedBooks[i])) {
                for (int j = 0; j < availableBooks.length; j++) {
                    if (availableBooks[j] == null) {
                        availableBooks[j] = rBook;
                        issuedBooks[i] = null;
                        System.out.println("Thank you for returning the book.");
                        return;
                    }
                }
                System.out.println("No slot available for returning books.");
                return;
            }
        }
        System.out.println("This book does not belong to this library.");
    }

    void showAvailableBooks() {
        System.out.println("Available Books:");
        boolean empty = true;
        for (String book : availableBooks) {
            if (book != null) {
                System.out.print(book + "\t");
                empty = false;
            }
        }
        if (empty) {
            System.out.println("No books available.");
        } else {
            System.out.println();
        }
    }
}

public class PublicLibrary {
    public static void main(String[] args) {
        Library obj = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to Public Library");
            System.out.println("1. Add a book");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Show available books");
            System.out.println("5. Exit");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    obj.addBook();
                    break;
                case 2:
                    obj.issueBook();
                    break;
                case 3:
                    obj.returnBook();
                    break;
                case 4:
                    obj.showAvailableBooks();
                    break;
                case 5:
                    System.out.println("Exiting the library.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        sc.close(); // Close the scanner at the end of the program
    }
}

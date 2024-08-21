import java.util.Objects;
import java.util.Scanner;


class Library{
    String[] availableBooks = new String[6];
    String[] issuedBooks = new String[6];
    Scanner sc = new Scanner(System.in);
    String book;
    String iBook;
    String rBook;
    void addBook(){
        System.out.println("Enter the name of the book");
        book = sc.nextLine();
        for (int i =0; i<availableBooks.length;i++){
            if (availableBooks[i]==null){
                availableBooks[i] = book;
                System.out.println("The book has been added");
                break;
            }

        }
    }
    void issueBook(){
        System.out.println("Enter the Name of the book you want to issue");
        iBook = sc.nextLine();
        for (int i =0; i<availableBooks.length;i++){
            if (Objects.equals(availableBooks[i], iBook)){
                for (int j =0; j<issuedBooks.length;j++){
                    if (issuedBooks[i]==null){
                        issuedBooks[i] = iBook;
                        availableBooks[i]= null;
                        System.out.println("Thank you for issuing the book " + iBook);
                        break;
                    }
                }break;
            }
            else {
                System.out.println("The book is not available");
                break;
            }
        }
    }
    void returnBook(){
        System.out.println("Enter the Name of the book you want to return");
        rBook = sc.nextLine(); int c=0;
        for (int i =0; i<issuedBooks.length;i++){
            if (Objects.equals(issuedBooks[i], rBook)){
                for (int j =0; j<availableBooks.length;j++){
                    if (availableBooks[i]==null){
                        availableBooks[i] = rBook;
                        issuedBooks[i] = null;
                        System.out.println("Thank you for returning the book");

                    }
                }break;
            }
            else {
                System.out.println("This book does not belong to this library");
                break;
            }
        }
    }
    void showAvailableBooks(){
        System.out.println("Available Books");
        for (String availableBook : availableBooks) {
            if (availableBook != null)
                System.out.printf(availableBook + "\t");
            else
                System.out.println("Slot Empty");
        }
    }
}

public class PublicLibrary {
    public static void main(String[] args) {
        int choice=0;
        Scanner sc= new Scanner(System.in);
        Library obj = new Library();
        while(choice!=5){
            System.out.println("Welcome to Public Library");
            System.out.println("Choose 1 to add a book, 2 for issuing a book, 3 for returning a book , 4 for showing " +
                    "available books and 5 for exiting the library");
            choice = sc.nextInt();
            sc.close();
            if (choice == 1) {
                obj.addBook();
            }
            else if (choice == 2) {
                obj.issueBook();
            }
            else if (choice == 3) {
                obj.returnBook();
            }
            else if (choice == 4) {
                obj.showAvailableBooks();
            }
            else if (choice == 5) {
                break;
            }
        }


    }
}

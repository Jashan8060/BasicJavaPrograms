import java.util.Scanner;

class InvalidInputException extends Exception{
    @Override
    public String toString() {
        return "Enter a valid input";
    }
}
class DivideByZero extends Exception{
    @Override
    public String toString() {
        return "You cannot divide by zero";
    }
}
class MaxInput extends Exception{
    @Override
    public String toString() {
        return "Enter a number smaller than 100000 ";
    }
}
class MaxMultiplier extends Exception{
    @Override
    public String toString() {
        return "Input cannot be greater than 7000";
    }
}
public class Calculator {
    static Scanner sc = new Scanner(System.in);
    static void addition() throws MaxInput {
        System.out.println("Enter the First Number");
        double a = sc.nextDouble();
        System.out.println("Enter the Second Number");
        double b = sc.nextDouble();
        if (a > 100000 || b > 100000) {
            throw new MaxInput();
        } else {
            double c = a + b;
            System.out.println("The sum is " + c);
        }
    }
    static void subtraction() throws MaxInput{
        System.out.println("Enter the First Number");
        double a = sc.nextInt();
        System.out.println("Enter the Second Number");
        double b = sc.nextInt();
        if(a>100000 || b>100000){
            throw new MaxInput();
        }
        else {
            double c = a-b;
            System.out.println("The Result is " + c);
        }
    }
    static void multiplication() throws MaxMultiplier{
        System.out.println("Enter the First Number");
        double a = sc.nextInt();
        System.out.println("Enter the Second Number");
        double b = sc.nextInt();
        if(a>7000 || b>7000){
            throw new MaxMultiplier();
        }
        else {
            double c = a*b;
            System.out.println("The Result is " + c);
        }
    }
    static void division() throws DivideByZero, MaxInput{
        System.out.println("Enter the First Number");
        double a = sc.nextInt();
        System.out.println("Enter the Second Number");
        double b = sc.nextInt();
        if(a>100000 || b>100000){
            throw new MaxInput();
        }
        else if(b==0){
            throw new DivideByZero();
        }
        else {
            double c = a/b;
            System.out.println("The Result is " + c);

        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator");
        System.out.println("""
                Choose 1 for Addition\s
                Choose 2 for Subtraction\s
                Choose 3 for Multiplication\s
                Choose 4 for Division\s
                Choose 5 for exiting""");
        int i = sc.nextInt();
//        while (i!=5){1
        if(i ==1){
            try { addition();}
            catch (Exception e){ System.out.println(e); }
        }
        else if(i ==2){
            try { subtraction(); }
            catch (Exception e){ System.out.println(e); }
        }
        else if(i ==3){
            try { multiplication(); }
            catch (Exception e){ System.out.println(e);}
        }
        else if(i ==4){
            try { division();}
            catch (Exception e){ System.out.println(e);}
        }
        else { System.out.println("Choose a valid input"); }
    }
}
//}

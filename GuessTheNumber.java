import java.util.Random;
import java.util.Scanner;

class Game {
    int computer;
    int user;
    int noOfGuesses = 0;
    boolean isCorrectNumber = false;

    public void incrementNoOfGuesses() {
        noOfGuesses += 1;
    }

    public void displayNoOfGuesses() {
        System.out.println("The number of Guesses is " + noOfGuesses);
    }

    Game() {
        Random number = new Random();
        computer = number.nextInt(5); // Generates a random number between 0 and 4
    }

    public void takeUserInput() {
        Scanner sc = new Scanner(System.in);
        user = sc.nextInt();
    }

    public void checkIfCorrectNumber() {
        if (computer == user) {
            System.out.println("Congratulations! You won.");
            isCorrectNumber = true;
        } else {
            System.out.println("Try again.");
            isCorrectNumber = false;
        }
    }
}

public class GuessTheNumber {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Choose a number between 0 and 4:");
        
        // Continue prompting until the user guesses the correct number
        do {
            game.takeUserInput();
            game.checkIfCorrectNumber();
            game.incrementNoOfGuesses();
        } while (!game.isCorrectNumber);

        game.displayNoOfGuesses();
    }
}

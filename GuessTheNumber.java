import java.util.Random;
import java.util.Scanner;

class Game{
    int computer;
    int user;
    int noOfGuesses=0;
    boolean isCorrectNumber = false;
    public void setNoOfGuesses(){
        noOfGuesses+=1;
    }
    public void getNoOfGuesses(){
        System.out.println("The number of Guesses is " + noOfGuesses);
    }
    Game() {
        Random number = new Random();
        computer = number.nextInt(0,5);
    }
    public void takeUserInput(){
        Scanner sc = new Scanner(System.in);
        user = sc.nextInt();
        
    }
    public void isCorrectNumber(){
        if(computer == user){
            System.out.println("Congratulations You won");
            isCorrectNumber = true;

        }
        else {
            isCorrectNumber = false;
        }
    }
}
public class GuessTheNumber {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Choose a number");
        game.takeUserInput();
        while (!game.isCorrectNumber){
            game.isCorrectNumber();
            game.setNoOfGuesses();
            if(!game.isCorrectNumber)
                break;
            System.out.println("Try again");
            game.takeUserInput();
        }
        game.getNoOfGuesses();
    }
}

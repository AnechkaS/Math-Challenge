/* The given code is a Java program that implements a simple math game. 
The program prompts the user to select an operation to perform (addition, subtraction, multiplication, or division), 
as well as the number of questions to answer. It then generates random math problems based on the selected operation 
and prompts the user to answer them. The program checks the user s answers and provides feedback on whether they are 
correct or incorrect. At the end of the game, the program displays the user's score (number of correct answers out of 
the total questions answered). The user is then given the option to play the game again or exit the program.

The program uses basic Java constructs like loops, conditional statements, and switches. It also uses Java's 
built-in Random and Scanner classes to generate random numbers and read input from the user, respectively. 
The program is designed to provide a simple way for users to practice their math skills while also having fun playing a game.
*/



import java.util.*;

public class MathPracticeMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the Math Game!");

            // Ask user what operation they want to do
            String operation;
            do {
                System.out.print("Enter the operation you want to do (A for addition, S for subtraction, M for multiplication, or D for division): ");
                operation = input.nextLine().toUpperCase();
            } while (!operation.equals("A") && !operation.equals("S") && !operation.equals("M") && !operation.equals("D"));

            // Convert operation input to actual operation
            String operationStr;
            switch (operation) {
                case "A":
                    operationStr = "+";
                    break;
                case "S":
                    operationStr = "-";
                    break;
                case "M":
                    operationStr = "*";
                    break;
                default: // division
                    operationStr = "/";
                    break;
            }

            // Ask user how many questions they want to do
            int numQuestions;
            do {
                System.out.print("How many questions do you want to do? ");
                try {
                    numQuestions = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    numQuestions = -1; // set to -1 to repeat loop
                }
            } while (numQuestions < 1);

            // Initialize variables for tracking correct/incorrect answers
            int numCorrect = 0;
            int numIncorrect = 0;

            // Loop through the number of questions requested by user
            for (int i = 1; i <= numQuestions; i++) {
                int x = random.nextInt(10) + 1; // generate random numbers between 1 and 10
                int y = random.nextInt(10) + 1;

                // Calculate the answer depending on the operation chosen
                int answer;
                switch (operation) {
                    case "A":
                        answer = x + y;
                        break;
                    case "S":
                        answer = x - y;
                        break;
                    case "M":
                        answer = x * y;
                        break;
                    default: // division
                        answer = x / y;
                        break;
                }

                // Ask user for answer
                int userAnswer;
                boolean validInput;
                do {
                    System.out.print("(" + i + ") What is " + x + " " + operationStr + " " + y + "? ");
                    try {
                        userAnswer = Integer.parseInt(input.nextLine());
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        validInput = false;
                        userAnswer = -1; // set to -1 to repeat loop
                    }
                } while (!validInput);

                // Check if answer is correct and provide feedback
                if (userAnswer == answer) {
                    System.out.println("Correct!");
                    numCorrect++;
                } else {
                    System.out.println("Incorrect! The correct answer is " + answer + ".");
                    numIncorrect++;
                }
            }
            
            // Print final results
            System.out.println("You answered " + numCorrect + " out of " + numQuestions + " questions correctly!");

            // Ask user if they want to play again
            String playAgainInput;
            do {
                System.out.print("Do you want to play again? (y/n) ");
                playAgainInput = input.nextLine().toLowerCase();
            } while (!playAgainInput.equals("y") && !playAgainInput.equals("n"));

            playAgain = playAgainInput.equals("y");
        }

        System.out.println("Thanks for playing the Math Game!");
    }
}
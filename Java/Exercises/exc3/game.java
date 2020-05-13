import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class game {
    public static void main(String[] args) throws IOException {
    try {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        int rand = generator.nextInt(100) + 1;
        boolean playing = true;

        while (playing) {
            System.out.print("Guess a number between 0-100: ");
            int guess = input.nextInt();
            int attempts = 1;
            while (guess != rand) {
                if (guess > rand) {
                    System.out.println("Too High!");
                    attempts += 1;
                } else {
                    System.out.println("Too Low");
                    attempts += 1;
                }
                System.out.print("Try again: ");
                guess = input.nextInt();
            }
            System.out.println("You got it! " + rand + " is the correct answer. Number of attempts: " + attempts);

            System.out.println("Do you wish to play again? (Y/N): ");
            String answer = input.next();
            playing = answer.equalsIgnoreCase("y");

            attempts = 1;
            guess = 0;
            rand = generator.nextInt(100) + 1;
        }

        } catch(InputMismatchException e) {
            System.out.println("ERROR -> Incorrect Input");
            }

        }
    }


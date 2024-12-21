package AnagramGame;

import java.util.Scanner;

public class Game {
    public Game() {
    }

    public static void intro() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play?");
        System.out.println("Press Y to play");
        System.out.println("Press Q to quit");
        String select = input.nextLine();
        if (!select.equals("Y") && !select.equals("y")) {
            if (select.equals("Q") || select.equals("q")) {
                return;
            }

            System.out.println("Invalid choice, Try Again\n\n");
            intro();
        } else {
            System.out.println();
            System.out.println();
        }

    }

    public static void game() {
        Scanner scnr = new Scanner(System.in);
        WordFinder finder = new WordFinder();
        String[] names = finder.finder();
        String scrambledName = names[0];
        String answer = names[1];
        int correctAnswer = 0;
        int strikes = 0;
        System.out.println("Score: " + correctAnswer);
        System.out.println("Strikes: " + strikes);
        boolean guessBool = false;

        String guess;
        while(strikes < 3) {
            System.out.println("Scrambled Word: " + scrambledName);
            System.out.println("Answer: ");
            guess = scnr.nextLine().toLowerCase();
            if (guess.equals(answer)) {
                System.out.println("Correct! The answer was: " + answer);
                ++correctAnswer;
                System.out.println("Score: " + correctAnswer);
                names = finder.finder();
                scrambledName = names[0];
                answer = names[1];
            } else if (!guess.equals(answer)) {
                System.out.println("Incorrect! Try Again");
                ++strikes;
            }
        }

        System.out.println("GAME OVER!");
        System.out.println("Score: " + correctAnswer);
        System.out.println("Would you like to play again?");
        System.out.println("Press Y for Yes");
        System.out.println("Press any other key for No");
        guess = scnr.nextLine();
        if (!guess.equals("Y") && !guess.equals("y")) {
            System.exit(0);
        } else {
            game();
        }

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Arshavigram!");
        System.out.println("Created by Layth Hatif");
        System.out.println("Unscramble the last name of the Soccer player and gain points!");
        intro();
        game();
    }
}

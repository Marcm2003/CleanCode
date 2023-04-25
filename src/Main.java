import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;


public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(in);

        var hiddenArray = new String[]{"umbrella", "chronometer", "helicopter", "television", "wardrobe", "butterfly", "holidays", "wednesday", "happiness", "discipline"};

        var tokens = 3;

        for (String instructions : Arrays.asList("You have to guess the hidden word.", "You will be asked for a letter at each turn.", "If the hidden word contains the letter it will be shown.", "If the hidden word does not contain the letter you will lose a token.", "You start the game with 3 tokens.", "If you guess all letters of the hidden word you win.", "If you lose all tokens you lose.", "Good luck! The game is starting..."))
            out.println(instructions);
        out.println();


        int random = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);

        char[] hidden = hiddenArray[random - 1].toCharArray();

        char[] displayed = new char[hidden.length];
        Arrays.fill(displayed, '_');


        for (char hiddenLetter : displayed) out.printf(hiddenLetter + " ");
        out.println();

        boolean gameOver = false;
        boolean youWin = false;

        while (!gameOver && !youWin) {

            out.println("Write a letter: ");
            String line = scanner.next();

            char letter = line.charAt(0);
            boolean letterFound = false;
            for (int i = 0; i < hidden.length; i++)
                if (hidden[i] == letter) {
                    displayed[i] = letter;
                    letterFound = true;
                }
            if (!letterFound) {
                tokens = tokens - 1;
                out.println("You failed :/ You have " + tokens + " tokens left.");
            }

            for (char hiddenLetter : displayed) {
                out.printf(hiddenLetter + " ");
            }
            out.println();

            youWin = true;
            for (char hiddenLetter : displayed) {
                if (hiddenLetter == '_') {
                    youWin = false;
                    break;
                }
            }
            if (tokens == 0) {
                gameOver = true;
            }
        }

        if (youWin) out.println("Congratulations!! You won!!! :)");
        else out.println("You lost :( Play and try again!");
    }

}
import java.util.*;
public class Main {
    public static void main (String[] args) {
        String[] hangmen = {" _______\n|       |\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|_____________", " _______\n|       |\n|     __|__\n|   /       \\\n|  |         |\n|  |         |\n|   \\ _____ /\n|\n|\n|\n|\n|\n|\n|\n|\n|_____________", " _______\n|       |\n|     __|__\n|   /       \\\n|  |         |\n|  |         |\n|   \\ _____ /\n|       |\n|       |\n|       |\n|       |\n|\n|\n|\n|\n|_____________", " _______\n|       |\n|     __|__\n|   /       \\\n|  |         |\n|  |         |\n|   \\ _____ /\n|       |\n|     __|\n|       |\n|       |\n|\n|\n|\n|\n|_____________", " _______\n|       |\n|     __|__\n|   /       \\\n|  |         |\n|  |         |\n|   \\ _____ /\n|       |\n|     __|__\n|       |\n|       |\n|\n|\n|\n|\n|_____________", " _______\n|       |\n|     __|__\n|   /       \\\n|  |         |\n|  |         |\n|   \\ _____ /\n|       |\n|     __|__\n|       |\n|       |\n|      /\n|     /\n|    /\n|\n|_____________", " _______\n|       |\n|     __|__\n|   /       \\\n|  |  x   x  |\n|  |    -    |\n|   \\ _____ /\n|       |\n|     __|__\n|       |\n|       |\n|      / \\\n|     /   \\\n|    /     \\\n|\n|_____________"};
        String[] msg = {"", "it's okay, you still have a bunch of tries left!", "hm.. it seems like this word was a little too difficult for you.", "hey.. be a little more careful..", "yikes. please have some consideration for that poor soul on the hanging post.", "PLEASE clutch up. you have one more chance to save him.", "oh my gosh. look what you've done to him."};
        System.out.print("welcome! set word/phrase for player 2 (only letters and spaces allowed): ");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        System.out.println("fire! word set.");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(hangmen[6] + "\n");
        System.out.println("welcome to hangman! try not to have your victim end up like that...");

        int i = 0;
        String currentGuess = "";
        String guessedLetters = "";
        String currentWord = "";
        boolean guess = true;
        for (int j = 0; j < word.length(); j++) {
            if (word.charAt(j) == ' ') currentWord += " ";
            else currentWord += "_"; 
        }
        while (i < hangmen.length) {
            if (!guess) System.out.println(msg[i]);
            System.out.println(hangmen[i]);
            if (i == hangmen.length-1) break;
            System.out.println("the current state of your hanging post!");
            System.out.println("guessed letters: " + guessedLetters.toUpperCase());
            System.out.println("progress: " + currentWord);
            System.out.print("guess a letter: ");
            currentGuess = scan.next();
            guessedLetters += currentGuess;
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            if (word.indexOf(currentGuess) == -1) {
                i++;
                guess = false;
            }
            else {
                currentWord = addLetters(currentGuess, word, currentWord);
                guess = true;
            }
            if (currentWord.equals(word)) break;
        }
        if (currentWord.equals(word)) System.out.println("player 2 wins!");
        else System.out.println("player 1 wins!");
    }

    static String addLetters(String letter, String word, String progress) {
        String out = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i+1).equals(letter)) out += letter;
            else out += progress.charAt(i);
        }
        return out;
    }
}
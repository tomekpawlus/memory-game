import java.util.Scanner;


public class Console {
    public static void main(String[] args) {

        GameImpl game = new GameImpl();
        Scanner keyboard = new Scanner(System.in);
        String guess;

        game.setEmptyBoard();

        while (true) {
            System.out.println();
            game.getBoardState();


            while (true) {
                System.out.println("Please, enter 'A' row guess");
                guess = keyboard.nextLine();
                int element = Character.getNumericValue(guess.charAt(1));
                if (guess.charAt(0) == 'A'&& element <8) {
                    game.setRow(guess);
                    break;
                } else {
                    System.out.println("You enter wrong coordination's. Please, try again");
                }
            }


            while (true) {
                System.out.println("Please, enter 'B' row guess");
                guess = keyboard.nextLine();
                int element = Character.getNumericValue(guess.charAt(1));
                if (guess.charAt(0) == 'B' && element <8) {
                    game.setRow(guess);
                    break;
                } else {
                    System.out.println("You enter wrong coordination's. Please, try again");
                }
            }

            String firstGuess = game.getFirstGuessedWord();
            String secondGuess = game.getSecondGuessedWord();

            if (game.checkIfWordsEqual(firstGuess, secondGuess)) {
                System.out.println("Please, try again.");
                System.out.println();
            } else {
                System.out.println("Great.");
                System.out.println();
            }
        }

    }

}

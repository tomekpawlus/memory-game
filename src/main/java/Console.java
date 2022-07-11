import java.util.Scanner;


public class Console {
    public static void main(String[] args) {

        Board board = new Board();
        GameImpl game = new GameImpl();
        Scanner keyboard = new Scanner(System.in);

        while (true){
            System.out.println("");
            System.out.println("Please guess");
            String guess = keyboard.nextLine();

            System.out.println();
            char row = guess.charAt(0);
            int element =Character.getNumericValue(guess.charAt(1));

            game.playGame(row, element);
        }
    }


}

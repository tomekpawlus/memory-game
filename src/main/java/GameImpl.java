import java.util.ArrayList;

public class GameImpl {

    private String firstGuessedWord;
    private int firstGuessIndex;
    private String secondGuessedWord;
    private int secondGuessIndex;


    private final Board board = new Board();


    ArrayList<String> firstRow = board.getFirstRow(9);
    ArrayList<String> secondRow = board.getSecondRow(firstRow);

    ArrayList<String> emptyFirstRow = new ArrayList<>();
    ArrayList<String> emptySecondRow = new ArrayList<>();


    public void setEmptyBoard() {
        for (int i = 0; i < 8; i++) {
            emptyFirstRow.add("X");
            emptySecondRow.add("X");
        }
    }

    public void getBoardState() {
        System.out.println(emptyFirstRow);
        System.out.println(emptySecondRow);
    }

    public void setRow(String guess) {
        char row = guess.charAt(0);
        int element = Character.getNumericValue(guess.charAt(1));
        if (row == 'A') {
            String guessedWord = firstRow.get(element);
            emptyFirstRow.set(element, guessedWord);
            this.firstGuessedWord = guessedWord;
            this.firstGuessIndex = element;
            getBoardState();
        } else if (row == 'B') {
            String guessedWord = secondRow.get(element);
            emptySecondRow.set(element, guessedWord);
            getBoardState();
            this.secondGuessedWord = guessedWord;
            this.secondGuessIndex = element;
        }

    }





    public String getFirstGuessedWord() {
        return firstGuessedWord;
    }

    public String getSecondGuessedWord() {
        return secondGuessedWord;
    }

    public boolean checkIfWordsEqual(String firstWord, String secondWord) {
        System.out.println();
        if (!firstGuessedWord.equals(secondGuessedWord)) {
            emptyFirstRow.set(firstGuessIndex, "X");
            emptySecondRow.set(secondGuessIndex, "X");
            return true;
        }
        return false;
    }
}
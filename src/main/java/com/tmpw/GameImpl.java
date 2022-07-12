package com.tmpw;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameImpl implements Game {

    // ========fields========

    private String firstGuessedWord;
    private int firstGuessIndex;
    private String secondGuessedWord;
    private int secondGuessIndex;
    private int numberOfWordsInRow;
    private int remainingGuesses;
    private int numberOfGuesses = 0;

    private final Board board;

    private List<String> firstRow;
    private List<String> secondRow;

    private List<String> emptyFirstRow;
    private List<String> emptySecondRow;

    // ========constructors========

    public GameImpl(Board board) {

        this.board = board;}


    // ========public methods========

    @Override
    public int getNumberOfWordsInRow() {
        return numberOfWordsInRow;
    }

    @Override
    public void reset() {
        setFirstRow(numberOfWordsInRow);
        setSecondRow(firstRow);
        setEmptyBoard();
    }

    @Override
    public void setFirstRow(int numberOfWordsInRow) {
        this.firstRow = new ArrayList<>();
        List<String> firstRow = board.generateFirstRow(numberOfWordsInRow);
        for (int i = 0; i < numberOfWordsInRow; i++) {
            this.firstRow.add(firstRow.get(i));
        }
    }

    @Override
    public void setSecondRow(List<String> firstRow) {
        this.secondRow = new ArrayList<>();
        List<String> secondRow = board.generateSecondRow(firstRow);
        for (int i = 0; i < numberOfWordsInRow; i++) {
            this.secondRow.add(secondRow.get(i));
        }
        }

    @Override
    public List<String> getEmptyFirstRow() {

        return emptyFirstRow;
    }

    @Override
    public List<String> getEmptySecondRow() {
        return emptySecondRow;
    }

    @Override
    public String getFirstGuessedWord() {
        return firstGuessedWord;
    }

    @Override
    public String getSecondGuessedWord() {
        return secondGuessedWord;
    }

    @Override
    public void setEmptyBoard() {
        this.emptyFirstRow = new ArrayList<>();
        this.emptySecondRow = new ArrayList<>();
        for (int i = 0; i < numberOfWordsInRow; i++) {
            emptyFirstRow.add("X");
            emptySecondRow.add("X");
        }
    }

    @Override
    public void getBoardState() {
        System.out.println(firstRow);
        System.out.println(secondRow);

        System.out.println("----------------------------------");
        System.out.println("Guess chances: " + remainingGuesses);

        if(numberOfWordsInRow == 4){
            System.out.println("  | 1 | 2 | 3 | 4 |");}
        else{System.out.println("  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |"); }

        System.out.print("A | ");
        for (String element : emptyFirstRow) {
            System.out.print(element + " | ");
        }
        System.out.println();
        System.out.print("B | ");
        for (String element : emptySecondRow) {
            System.out.print(element + " | ");
        }
        System.out.println();
    }

    @Override
    public void setGuess(String guess) {
        char row = guess.charAt(0);
        int element = Character.getNumericValue(guess.charAt(1)-1);

        if (row == 'A') {
            String guessedWord = firstRow.get(element);
            emptyFirstRow.set(element, guessedWord);
            this.firstGuessedWord = guessedWord;
            this.firstGuessIndex = element;
            getBoardState();
        } else if (row == 'B') {
            String guessedWord = secondRow.get(element);
            emptySecondRow.set(element, guessedWord);
            this.secondGuessedWord = guessedWord;
            this.secondGuessIndex = element;
            this.remainingGuesses--;
            this.numberOfGuesses ++;
            getBoardState();
        }
    }

    @Override
    public boolean checkIfWordsEqual(String firstWord, String secondWord) {
        System.out.println();
        if (!firstGuessedWord.equals(secondGuessedWord)) {
            emptyFirstRow.set(firstGuessIndex, "X");
            emptySecondRow.set(secondGuessIndex, "X");
            return true;
        }else if (firstGuessedWord.equals(secondGuessedWord)) {
            emptyFirstRow.set(firstGuessIndex, "O");
            emptySecondRow.set(secondGuessIndex, "O");
            return false;
        }
        return false;
    }

    @Override
    public void setLevel(Level level) {
        switch (level) {
            case HARD:
                this.numberOfWordsInRow = 8;
                this.remainingGuesses = 15;
                break;
            case EASY:
                this.numberOfWordsInRow = 4;
                this.remainingGuesses = 10;
                break;
        }

    }

    @Override
    public boolean isGameWon() {
        if (emptyFirstRow.contains("X")) {
            return false;
        }
        return true;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }
}
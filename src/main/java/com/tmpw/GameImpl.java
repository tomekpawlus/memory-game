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
    private int numberOfGuesses;
    private int remainingGuesses;

    private final Board board;

    private List<String> firstRow = new ArrayList<>();
    private List<String> secondRow = new ArrayList<>();

    private List<String> emptyFirstRow = new ArrayList<>();
    private List<String> emptySecondRow = new ArrayList<>();
    // ========constructors========

    public GameImpl(Board board) {
        this.board = board;
    }


    // ========public methods========

    @PostConstruct
    public void reset() {
        setFirstRow(numberOfWordsInRow);
        setSecondRow(firstRow);
    }

    @Override
    public void setFirstRow(int numberOfWordsInRow) {
        List<String> firstRow = board.generateFirstRow(numberOfWordsInRow);
        this.firstRow.addAll(firstRow);
    }

    @Override
    public void setSecondRow(List<String> firstRow) {
        List<String> secondRow = board.generateSecondRow(firstRow);
        this.secondRow.addAll(secondRow);
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
        for (int i = 0; i < numberOfWordsInRow; i++) {
            emptyFirstRow.add("X");
            emptySecondRow.add("X");
        }
    }

    @Override
    public void getBoardState() {
        System.out.println(emptyFirstRow);
        System.out.println(emptySecondRow);
    }

    @Override
    public void setGuess(String guess) {
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
            this.secondGuessedWord = guessedWord;
            this.secondGuessIndex = element;
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
        }
        return false;
    }

    @Override
    public void setLevel(Level level) {
        switch (level) {
            case HARD:
                this.numberOfWordsInRow = 8;
                this.numberOfGuesses = 15;
                break;
            case EASY:
                this.numberOfWordsInRow = 4;
                this.numberOfGuesses = 10;
                break;
        }
    }
}
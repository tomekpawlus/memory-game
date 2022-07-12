package com.tmpw;

import java.util.ArrayList;
import java.util.List;

public interface Game {

    int getNumberOfGuesses();

    int getNumberOfWordsInRow();

    void setFirstRow(int numberOfWordsInRow);

    void setSecondRow(List<String> firstRow);

    List<String> getEmptyFirstRow();

    List<String> getEmptySecondRow();

    String getFirstGuessedWord();

    String getSecondGuessedWord();

    void setEmptyBoard();

    void getBoardState();

    void setGuess(String guess);

    boolean checkIfWordsEqual(String firstWord, String secondWord);

    void setLevel(Level level);

    void reset();

    boolean isGameWon();

    boolean isGameLost();


}


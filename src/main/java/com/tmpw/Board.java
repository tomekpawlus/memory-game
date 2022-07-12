package com.tmpw;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Board {

    // ========fields========
    private List<String> firstRow = new ArrayList<>();
    private WordGenerator wordGenerator;

    // ========constructor========
    public Board(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
    }

    // ========public methods========
    public List<String> generateFirstRow(int numberOfWordsInRow) {
        for (int i = 0; i < numberOfWordsInRow; i++) {
            String word = wordGenerator.generateWord();
            firstRow.add(word);
        }
        return firstRow;
    }

    public List<String> generateSecondRow(List<String> firstRow) {
        ArrayList<String> secondRow = new ArrayList<>();
        secondRow.addAll(firstRow);
        Collections.shuffle(secondRow);
        return secondRow;
    }
}
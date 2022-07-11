import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    ArrayList<String> firstRow = new ArrayList<>();
    ArrayList<String> secondRow = new ArrayList<>();

    public ArrayList<ArrayList<String>> createBoard(int numberOfWords) {

        firstRow = getFirstRow(numberOfWords);
        secondRow = getSecondRow(firstRow);

        System.out.println(firstRow);
        System.out.println(secondRow);

        ArrayList<ArrayList<String>> board = new ArrayList<>();
        board.add(firstRow);
        board.add(secondRow);
        return board;
    }

    public ArrayList<String> getFirstRow (int numberOfWords){
        WordGenerator wordGenerator = new WordFromFile();

        for (int i = 0; i < numberOfWords; i++) {
            String word = wordGenerator.generateWord();
            firstRow.add(word);
        }
        return firstRow;
    }

    public ArrayList<String> getSecondRow (ArrayList<String> firstRow){
        ArrayList<String> secondRow = new ArrayList<>();
        secondRow.addAll(firstRow);
        Collections.shuffle(secondRow);
        return secondRow;
    }
}

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    ArrayList<String> firstRow = new ArrayList<>();

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

import java.util.ArrayList;
import java.util.Collections;

public class BoardLvlHard extends Board{

    ArrayList<String> firstRow = new ArrayList<>();
    ArrayList<String> secondRow = new ArrayList<>();


    @Override
    public ArrayList<ArrayList<String>> createBoard() {

        firstRow = getFirstRow();
        secondRow = getSecondRow(firstRow);

        ArrayList<ArrayList<String>> board = new ArrayList<>();

        board.add(firstRow);
        board.add(secondRow);

        System.out.println(firstRow);
        System.out.println(secondRow);

        return board;
    }

    public ArrayList<String> getFirstRow (){
        WordGenerator wordGenerator = new WordFromFile();

        for (int i = 0; i < 8; i++) {
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

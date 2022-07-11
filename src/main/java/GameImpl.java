import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

public class GameImpl {

    private final Board board = new Board();



    ArrayList<ArrayList<String>> boardLvlHard = board.createBoard(8);

    public void playGame (char row, int element){

        if(row == 'A' && element<8){
         String word = boardLvlHard.get(0).get(element);
         System.out.println(word);

        }else if(row == 'B'&& element<8){
            String word =  boardLvlHard.get(1).get(element);
            System.out.println(word);
        } else {
            System.out.println("Wrong input");
        }
    }
}

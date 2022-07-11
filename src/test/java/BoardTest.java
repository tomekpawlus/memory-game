import org.junit.jupiter.api.Test;

class BoardTest {


    Board board = new Board();

    @Test
    void createBoard() {
        board.createBoard(5);
    }

}
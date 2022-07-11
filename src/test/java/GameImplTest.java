import org.junit.jupiter.api.Test;

class GameImplTest {

    Board board = new Board();
    GameImpl game = new GameImpl();

    @Test
    public void playGame(){
        game.playGame('A',5);
    }

}
package com.tmpw;

import org.springframework.stereotype.Component;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }


    @Override
    public String getMessageResult() {
        if (game.isGameWon()) {
            return "\n ---------------------------------------- \n You won the Memory Game! \n --------------------------------------- "
                    +"\n You solved the memory game after " + game.getNumberOfGuesses();
        } else if (game.isGameLost()) {
            return "\n ---------------------------------------- \n Sorry, you use all the chances \n ---------------------------------------";
        }
        return null;
    }

}

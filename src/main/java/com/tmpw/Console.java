package com.tmpw;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Console {


    private Game game;
    private MessageGenerator messageGenerator;

    public Console(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start () {

        Scanner keyboard = new Scanner(System.in);
        Scanner number = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("Welcome in Memory Game");
        System.out.println("---------------------------");
        System.out.println("Please choose level.");
        System.out.println("Type 1 for HARD or 2 for EASY");
        int level = number.nextInt();
        if(level == 1){
            game.setLevel(Level.HARD);
            game.reset();
        }else if(level == 2 ){
            game.setLevel(Level.EASY);
            game.reset();
        }else {
            System.out.println("You didn't choose level. Default level is EASY");
            game.setLevel(Level.EASY);
            game.reset();
        }


        while (true) {
            game.getBoardState();

            while (true) {
                System.out.println("---------------------------");
                System.out.println("Please, enter 'A' row guess");
                String guess = keyboard.nextLine().toUpperCase();
                int element = getElement(guess);
                if (game.getEmptyFirstRow().get(element) != "X") {
                    System.out.println("You already guessed this word. Please, give another one.");
                } else if (guess.charAt(0) == 'A' && element < game.getNumberOfWordsInRow()) {
                    game.setGuess(guess);
                    break;
                } else {
                    System.out.println("You enter wrong coordination's. Please, try again");
                }
            }

            while (true) {
                System.out.println("---------------------------");
                System.out.println("Please, enter 'B' row guess");
                String guess = keyboard.nextLine().toUpperCase();
                int element = getElement(guess);
                if (game.getEmptySecondRow().get(element) != "X") {
                    System.out.println("You already guessed this word. Please, give another one.");
                } else if (guess.charAt(0) == 'B' && element < game.getNumberOfWordsInRow()) {
                    game.setGuess(guess);
                    break;
                } else {
                    System.out.println("You enter wrong coordination's. Please, try again");
                }
            }

            String firstGuess = game.getFirstGuessedWord();
            String secondGuess = game.getSecondGuessedWord();

            if (game.checkIfWordsEqual(firstGuess, secondGuess)) {
                System.out.println("Please, try again.");
            } else {
                System.out.println("Great. You remembered!");
            }
            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getMessageResult());
                break;
            }
        }

    }

    private static int getElement(String guess) {
        int element = Character.getNumericValue(guess.charAt(1))-1;
        return element;
    }
}

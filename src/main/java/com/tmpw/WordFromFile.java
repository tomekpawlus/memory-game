package com.tmpw;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class WordFromFile implements WordGenerator {


    @Override
    public String generateWord() {
        try {
            //Read file
            Scanner scanner = new Scanner(new File("/Users/tomekpawlus/Downloads/memory-game/core/src/main/resources/Words.txt"));
            //Add words to ArrayList
            List<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            //Get random word from a List
            Random rand = new Random();
            String word = words.get(rand.nextInt(words.size()));

            return word;
        } catch (FileNotFoundException e) {
            return "File was not found";
        }


    }
}

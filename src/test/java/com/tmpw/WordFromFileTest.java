package com.tmpw;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class WordFromFileTest {

    @Test
    void generateWordWhenFileFound() throws FileNotFoundException {

        //given
        WordGenerator wordGenerator = new WordFromFile();
        //when
        String word = wordGenerator.generateWord();
        //then
        assertNotNull(word, "Word should not be null");

    }

}
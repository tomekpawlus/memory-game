package com.tmpw;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.util.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoardTest {

    @Mock
    WordGenerator wordGenerator;

    @InjectMocks
    Board board;


    @Test
    void generateFirstRowShouldHaveEightWords() {
        //given
        given(wordGenerator.generateWord()).willReturn("word");
        //when
        List<String> firstRow = board.generateFirstRow(8);
        //then
        assertThat(firstRow, Matchers.hasSize(8));
    }

    @Test
    void generateSecondRowShouldHaveFourWords() {
        //given
        List<String> firstRow = Arrays.asList("word1", "word2", "word3", "word4");
        //when
        List<String> secondRow = board.generateSecondRow(firstRow);
        //then
        assertThat(secondRow, Matchers.hasSize(4));
    }

    @Test
    void FirstRowShouldHaveDifferentOrderThantSecond() {
        //given
        List<String> firstRow = Arrays.asList("word1", "word2", "word3", "word4");
        //when
        List<String> secondRow = board.generateSecondRow(firstRow);
        //then
        assertNotEquals(secondRow, firstRow);
    }

}
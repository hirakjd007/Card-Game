package test;

import main.CardGameEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CardGameEngineTest {
    private final int[] SCORES= {0,2,0,0,1};

    @Test
    void mostWinsTest(){
        Assertions.assertEquals(1,CardGameEngine.mostWins(SCORES));
    }
    @Test
    void deriveValueTest(){
        Assertions.assertEquals(1, CardGameEngine.deriveValue("Ace"));
        assertEquals(11,CardGameEngine.deriveValue("Jack"));
        assertEquals(12,CardGameEngine.deriveValue("Queen"));
        assertEquals(13,CardGameEngine.deriveValue("King"));
        assertEquals(9,CardGameEngine.deriveValue("9"));

    }

    @Test
    void compileWinnerTest(){
        //test case 1
        String[] cardsInput = {"C King","D 8","C Ace","S 8"};
        String[] expected= {"D 8","C King","C Ace","S 8"};
        CardGameEngine.compileWinner(cardsInput);
        Assertions.assertEquals(Arrays.toString(expected),Arrays.toString(cardsInput));

        // test case 2
        String[] cardsInput1 = {"H 7","D 9","S 4","C 8"};
        String[] expected1= {"D 9","H 7","C 8","S 4"};
        CardGameEngine.compileWinner(cardsInput1);
        Assertions.assertEquals(Arrays.toString(expected1),Arrays.toString(cardsInput1));
    }
}
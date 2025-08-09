package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    int countKittens;
    int expectedCountKittens;

    Feline feline = Mockito.mock(Feline.class);

    public FelineParameterizedTest(int countKittens, int expectedCountKittens){
        this.countKittens = countKittens;
        this.expectedCountKittens = expectedCountKittens;
    }


    @Parameterized.Parameters
    public static Object[][] getCountKittens() {
        return new Object[][]{
                {-2, -2},
                {2, 2},
                {0, 0},
        };
    }

    @Test
    public void returnCountKittens() {
        feline = new Feline();
        int actual = feline.getKittens(countKittens);
        assertEquals("Должно вернуться кол-во котят", expectedCountKittens, actual);
    }
}
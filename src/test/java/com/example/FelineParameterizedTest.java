package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    int countKittens;
    int expectedCountKittens;

    public FelineParameterizedTest(int countKittens, int expectedCountKittens){
        this.countKittens = countKittens;
        this.expectedCountKittens = expectedCountKittens;
    }


    @Parameterized.Parameters(name = "Тестовые данные: {0} = {1}")
    public static Object[][] getCountKittens() {
        return new Object[][]{
                {-2, -2},
                {2, 2},
                {0, 0},
        };
    }

    @Test
    public void testReturnCountKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens(countKittens);
        assertEquals("Должно вернуться кол-во котят", expectedCountKittens, actual);
    }
}
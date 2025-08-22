package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline;

    @Before
    public void startUp() {
        feline = new Feline();
    }

    @Test
    public void testReturnFamilyFeline() {
        String actual = feline.getFamily();
        assertEquals("Должно вернуться семейство кошачьих", "Кошачьи", actual);
    }

    @Test
    public void testReturnCountKittensNoParam() {
        int actual = feline.getKittens();
        assertEquals("Должно вернуться кол-во котят по умолчанию (1)", 1, actual);
    }
    /*
    @Test
    public void testReturnCountKittensWithParam() {
        int actual = felineSpy.getKittens(3);
        assertEquals("Должно вернуться кол-во котят", 3, actual);
    }
    */

    @Test
    public void testReturnListEats() throws Exception {

        List<String> actual = feline.eatMeat();

        assertEquals("Должен вывестись список еды для хищников", List.of("Животные", "Птицы", "Рыба"), actual);
    }
}
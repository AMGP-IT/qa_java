package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    @Mock
    Lion lion;

    @Test
    public void shouldReturnOneWhenGetKittensIsEmpty() throws Exception {
        lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();

        assertEquals("Котят должно быть равно 1", 1, actual);
    }

    @Test
    public void shouldReturnTrueWhenLionIsMale() throws Exception {
        lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();

        assertTrue("Объект Lion должен быть самцом", actual);
    }

    @Test
    public void shouldReturnFalseWhenLionIsFemale() throws Exception {
        lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();

        assertFalse("Объект Lion должен быть самкой", actual);
    }

    @Test
    public void testConstructorWithInvalidSexAndMessage() {
        try {
            new Lion("оно", feline);
            fail("Ожидалось исключение");
        } catch (Exception e) {
            String expectedMessage = "Используйте допустимые значения пола животного - Самец или Самка";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void getFood() throws Exception {
        lion = new Lion("Самка", feline);
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();

        assertEquals("Должен вывестись список еды для хищников", List.of("Животные", "Птицы", "Рыба"), actual);
    }
}
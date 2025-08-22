package com.example;

import org.junit.Before;
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
    Feline felineMock;

    Lion lion;
    @Before
    public void startUp() throws Exception {
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testReturnOneWhenGetKittensIsEmpty()  {
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int actual = lion.getKittens();

        assertEquals("Котят должно быть равно 1", 1, actual);
    }

    @Test
    public void testReturnTrueWhenLionIsMale()  {

        boolean actual = lion.doesHaveMane();

        assertTrue("Объект Lion должен быть самцом", actual);
    }

    @Test
    public void testReturnFalseWhenLionIsFemale() throws Exception {
        lion = new Lion("Самка", felineMock);
        boolean actual = lion.doesHaveMane();

        assertFalse("Объект Lion должен быть самкой", actual);
    }

    @Test(expected = Exception.class)
    public void testConstructorWithInvalidSexAndMessage() throws Exception {
        new Lion("Некорректное значение", felineMock);
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();

        assertEquals("Должен вывестись список еды для хищников", List.of("Животные", "Птицы", "Рыба"), actual);
    }
}
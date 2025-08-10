package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline felineMock = new Feline();

    @Test
    public void returnNyaWhenTriggerMethod() {
        Cat cat = new Cat(felineMock);
        String actual = cat.getSound();
        assertEquals("Кошки должны мяукать", "Мяу", actual);
    }


    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();

        assertEquals("Должен вернуться список еды для хищников", List.of("Животные", "Птицы", "Рыба"), actual);

    }
}
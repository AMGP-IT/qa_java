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
public class CatTest {

    @Mock
    Feline felineMock = new Feline();
    Cat cat;

    @Before
    public void startUp(){
        cat = new Cat(felineMock);
    }

    @Test
    public void testReturnNyaWhenTriggerMethod() {

        String actual = cat.getSound();
        assertEquals("Кошки должны мяукать", "Мяу", actual);
    }


    @Test
    public void testGetFood() throws Exception {

        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();

        assertEquals("Должен вернуться список еды для хищников", List.of("Животные", "Птицы", "Рыба"), actual);

    }
}
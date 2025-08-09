package com.example;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class CatTest {

    @Mock
    Feline feline;

    Cat cat;

    @Test
    public void returnNyaWhenTriggerMethod() {
        cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Кошки должны мяукать", "Мяу", actual);
    }


    //я ОЧЕНЬ долго пытался, но у меня не получилось сделать тест рабочим и я не понимаю как
    @Test
    public void getFood() throws Exception {
        cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();

        assertEquals("Должен вывестись список еды для хищников", List.of("Животные", "Птицы", "Рыба"), actual);

    }
}
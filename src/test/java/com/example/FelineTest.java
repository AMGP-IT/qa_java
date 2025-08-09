package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void returnFamilyFeline() {
        String actual = feline.getFamily();
        assertEquals("Должно вернуться семейство кошачьих", "Кошачьи", actual);
    }

    @Test
    public void returnCountKittensNoParamInvokeWith1() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void returnListEats() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = feline.eatMeat();

        assertEquals("Должен вывестись список еды для хищников", List.of("Животные", "Птицы", "Рыба"), actual);
    }
}
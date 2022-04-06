package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;

public class LionTest {
    private Lion lion;
    public String sex = "Самка";



    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, feline);
    }


    @Mock
    Feline feline;


    @Test
    public void checkLionException() {
        Exception exception = null;
        String otherSex = "Что-то другое";
        String expectedExMessage = "Используйте допустимые значения пола животного - самец или самка";

        try {
            lion = new Lion(otherSex, feline);
        } catch (Exception ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(expectedExMessage, exception.getMessage());

    }

    @Test
    public void getKittensReturnsOne() {


        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;

        int actual = lion.getKittens();

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodReturnsCorrectValues() throws Exception {

        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
    }

    @Test
    public void felineMockVerifyArgumentString() throws Exception {
        String predator="Хищник";
        feline.getFood(predator);
        feline.getFood(predator);
        feline.getFood(predator);
        feline.getFood(predator);
        Mockito.verify(feline, Mockito.times(4)).getFood(Mockito.anyString());
    }


}

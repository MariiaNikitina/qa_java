package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline;
    @Before
    public void init()  {
        MockitoAnnotations.initMocks(this);
        feline=new Feline();
    }

    @Test
    public void getFamilyReturnsFeline(){
        String expected = "Кошачьи";

        String actual = feline.getFamily();

        assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithoutArgument(){
        int expected = 1;

        int actual = feline.getKittens();

        assertEquals(expected,actual);
    }



    @Test
    public  void eatMeatReturnsCorrectValue() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual= feline.eatMeat();

        assertEquals(expected,actual);
    }


}

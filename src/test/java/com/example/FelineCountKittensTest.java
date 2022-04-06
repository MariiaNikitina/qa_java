package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineCountKittensTest {
    Feline feline;

    @Before
    public void init()  {
        MockitoAnnotations.initMocks(this);
        feline=new Feline();
    }
    private final int expectedKittensCount;

    public FelineCountKittensTest(int expectedKittensCount) {
        this.expectedKittensCount = expectedKittensCount;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getKittensCount() {
        return new Object[][]{
                {9},
                {0},
                {-6},
        };
    }
    @Test
    public void getKittensWithArgument(){

        int actual = feline.getKittens(expectedKittensCount);

        assertEquals(expectedKittensCount,actual);
    }
}

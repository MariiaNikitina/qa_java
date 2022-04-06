package com.example;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class CatTest {
    Cat cat;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        cat=new Cat(feline);
    }

    @Mock
    Feline feline;
    @Test
    public void getSoundReturnsCorrectString(){
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected,actual);
    }

    @Test
    public void getFoodReturnsPredatorMenu() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> actual = cat.getFood();

        assertEquals(expected,actual);
    }
}

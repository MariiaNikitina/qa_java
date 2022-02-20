package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnimalTest {
    Animal animal;
    @Before
    public void init()  {
        MockitoAnnotations.initMocks(this);
        animal=new Animal();
    }
    @Test
    public void getFamilyReturnsCorrectValue(){
        String expected="Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actual=animal.getFamily();

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodReturnsException(){
        Exception exception = null;
        String unknownKindOfAnimal="Какой-то неизвестный вид животного";
        String expectedExMessage="Неизвестный вид животного, используйте значение Травоядное или Хищник";

        try{
            animal.getFood(unknownKindOfAnimal);
        } catch (Exception e) {
            exception=e;
        }
        assertNotNull(exception);
        assertEquals(expectedExMessage, exception.getMessage());
    }
}

package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalGetFoodTest {
    Animal animal;
    @Before
    public void init()  {
        MockitoAnnotations.initMocks(this);
        animal=new Animal();
    }

    private final String animalKind;
    private final List<String> listOfFood;
    public AnimalGetFoodTest(String animalKind, List<String> listOfFood){
        this.animalKind = animalKind;
        this.listOfFood = listOfFood;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getAnimalFood() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},

        };
    }

    @Test
    public void getFoodReturnsCorrectValues() throws Exception {

       List<String> actual=animal.getFood(animalKind);

       assertEquals(listOfFood,actual);

    }

}

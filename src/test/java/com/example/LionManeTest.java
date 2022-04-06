package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionManeTest {
    Lion lion;
    private final String sexVariable;
    private final boolean expectedMane;

    public LionManeTest(String sexVariable, boolean expectedMane) {
        this.sexVariable = sexVariable;
        this.expectedMane = expectedMane;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getLionSex() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},

        };
    }
    @Before
    public void init()  {
        MockitoAnnotations.initMocks(this);

    }


    @Mock
    Feline feline;
    @Test
    public void doesHaveManeReturnsCorrectValues() throws Exception {

        lion = new Lion(sexVariable, feline);
        boolean actual = lion.doesHaveMane();

        assertEquals(expectedMane, actual);
    }

}

package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlexTest {

    private Alex alex;
    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        alex = new Alex(feline);
    }

    @Mock
    Feline feline;

    @Test
    public void getPlaceOfLivingReturnsCorrectValue() {
        String expected = "New York Central Park Zoo";

        String actual = alex.getPlaceOfLiving();

        assertEquals(expected, actual);
   }

   @Test
   public void doesHaveManeReturnsTrue(){
        boolean expected =true;
        boolean actual = alex.doesHaveMane();
        assertEquals(expected,actual);
   }

   @Test
   public void getKittensReturnsZero(){
        int expected=0;
        int actual=alex.getKittens();
       assertEquals(expected,actual);

   }
   @Test
   public void getFoodReturnsCorrectValue() throws Exception {
       List<String> expected = List.of("Животные", "Птицы", "Рыба");

       Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

       List<String> actual = alex.getFood();

       assertEquals(expected, actual);
   }

   @Test
    public void getFriendsReturnsCorrectValue(){
       List<String> expected =List.of("Марти", "Глория", "Мелман");

       List<String> actual = alex.getFriends();

       assertEquals(expected, actual);
   }}

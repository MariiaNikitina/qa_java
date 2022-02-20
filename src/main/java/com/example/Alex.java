package com.example;

import java.util.List;

public class Alex extends Lion {



    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
    }
@Override
    public int getKittens(){
        return 0;
}
@Override
    public boolean doesHaveMane()
{
    return true;
}



    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }
    public String getPlaceOfLiving(){
        return "New York Central Park Zoo";
    }


}

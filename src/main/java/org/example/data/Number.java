package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class Number {

    public static List<Integer> getNumbers(int n){
        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }

        return numbers;
    }

}

package org.example.ch2;

import java.util.List;

public class C1StreamSumExample {

    public static void main(String[] args) {
        sumWithIntegerReducerSum();
        sumWithCustomReduce();
        sumUsingSumFunction();
        sumUsingMapToIntFunction();
    }

    public static void sumWithIntegerReducerSum() {
        List<String> numbs = List.of("one", "two", "three", "four", "five");
        long total = numbs.stream()
                .map(numb -> numb.length())
                .reduce(0, Integer::sum);
        System.out.println("countExample total = " + total);
    }

    public static void sumWithCustomReduce() {
        List<String> numbs = List.of("one", "two", "three", "four", "five");
        long total = numbs.stream()
                .map(numb -> numb.length())
                .reduce(0, (x, y) -> x + y);
        System.out.println("countExample total = " + total);
    }

    public static void sumUsingSumFunction() {
        List<String> numbs = List.of("one", "two", "three", "four", "five");
        int total = numbs.stream()
                .map(numb -> numb.length())
                .mapToInt(x -> x.intValue())
                .sum();
        System.out.println("sumExample total = " + total);
    }

    public static void sumUsingMapToIntFunction() {
        List<Integer> numbs = List.of(1, 2, 3, 4, 5);
        int total = numbs.stream()
                .mapToInt( x -> x)
                .sum();
        System.out.println("sumExample total = " + total);
    }

}

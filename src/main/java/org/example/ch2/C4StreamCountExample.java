package org.example.ch2;

import java.util.List;

public class C4StreamCountExample {

    public static void main(String[] args) {
        countingExample();
    }

    public static void countingExample() {
        List<String> numbs = List.of("one", "two", "three", "four", "five");
        long total = numbs.stream()
                .filter(numb -> numb.length() > 3)
                .count();

        System.out.println("countingExample total = " + total);
    }
}

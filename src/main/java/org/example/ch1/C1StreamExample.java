package org.example.ch1;

import org.example.data.Number;

import java.util.List;

public class C1StreamExample {

    // Stream is interface
    // Stream came in java8
    // Collection Framework -> is about storing  and organising your data in memory.
    // Example: List, Set, Map
    // Stream -> helps to process the data in an efficient way.

    public static void main(String[] args) {

        List<Integer> numbers = Number.getNumbers(10);

        simpleForLoopExample(numbers);
        simpleStreamExample(numbers);
    }

    public static void simpleForLoopExample(List<Integer> numbers) {
        System.out.println("--- simpleForLoopExample Start ---");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("value = " + numbers.get(i));
        }

        System.out.println("--- simpleForLoopExample End ---");
    }

    public static void simpleStreamExample(List<Integer> numbers) {
        System.out.println("--- simpleStreamExample Start ---");

        numbers.stream()
                .forEach(numb -> System.out.println("value = " + numb));

        System.out.println("--- simpleStreamExample Start ---");
    }

}

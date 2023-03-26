package org.example.ch1;

import org.example.data.Number;

import java.util.List;

public class C2StreamFilterExample {

    public static void main(String[] args) {
        List<Integer> numbers = Number.getNumbers(10);
        simpleForLoopConditionExample(numbers);
        simpleStreamConditionExample(numbers);
    }

    public static void simpleForLoopConditionExample(List<Integer> numbers) {
        System.out.println("--- simpleForLoopExample Start ---");
        for (int i = 0; i < numbers.size(); i++) {
            int numb = numbers.get(i);
            if (numb % 2 == 0) {
                System.out.println("value = " + numb);
            }
        }

        System.out.println("--- simpleForLoopExample End ---");
    }

    public static void simpleStreamConditionExample(List<Integer> numbers) {
        System.out.println("--- simpleStreamExample Start ---");

        numbers.stream()
                .filter(i -> i % 2 == 0)
                .forEach(numb -> System.out.println("value = " + numb));

        System.out.println("--- simpleStreamExample Start ---");
    }

}

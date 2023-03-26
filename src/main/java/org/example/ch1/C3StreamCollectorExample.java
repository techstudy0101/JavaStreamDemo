package org.example.ch1;

import org.example.data.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class C3StreamCollectorExample {

    public static void main(String[] args) {
        List<Integer> numbers = Number.getNumbers(10);
        simpleForLoopCollectionExample(numbers);
        simpleStreamCollectionExample(numbers);
        unmodifiableStreamCollectionExample(numbers);
    }

    public static void simpleForLoopCollectionExample(List<Integer> numbers) {
        System.out.println("--- simpleForLoopExample Start ---");
        List<Integer> evenNumbs = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int numb = numbers.get(i);
            if(numb % 2 == 0) {
                evenNumbs.add(numb);
            }
        }

        printNumber.accept(evenNumbs);

        System.out.println("--- simpleForLoopExample End ---");
    }

   public static Consumer<List<Integer>> printNumber = (numbs) -> {
        numbs.forEach(numb -> System.out.println(numb));
    };

    public static void simpleStreamCollectionExample(List<Integer> numbers) {
        System.out.println("--- simpleStreamExample Start ---");

        List<Integer> evenNumbs = numbers.stream()
                .filter( i -> i % 2 == 0)
                .collect(Collectors.toList());

        printNumber.accept(evenNumbs);

        System.out.println("--- simpleStreamExample Start ---");
    }


    public static void unmodifiableStreamCollectionExample(List<Integer> numbers) {
        System.out.println("--- simpleStreamExample Start ---");

        List<Integer> evenNumbs = numbers.stream()
                .filter( i -> i % 2 == 0)
                .collect(Collectors.toUnmodifiableList());

        printNumber.accept(evenNumbs);

        evenNumbs.add(22);

        System.out.println("--- simpleStreamExample Start ---");
    }

}

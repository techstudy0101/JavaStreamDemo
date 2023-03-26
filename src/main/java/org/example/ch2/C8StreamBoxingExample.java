package org.example.ch2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C8StreamBoxingExample {

    public static void main(String[] args) {
        boxingExample();
        collectingList();
    }

    public static void boxingExample() {
        IntStream.range(1, 10)
                .filter(i -> i % 2 == 0)
                .boxed()
                .forEach(integerObj -> System.out.println("integerObj = " + integerObj));
    }

    public static void collectingList() {
        List<Integer> numbs = IntStream.range(1, 10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("numb = " + numbs);
    }

}

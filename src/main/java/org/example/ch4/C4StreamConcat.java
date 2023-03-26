package org.example.ch4;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class C4StreamConcat {

    public static void main(String[] args) {
        concatUsingListExample();
        concatUsingStreamExample();
    }

    public static void concatUsingListExample() {
        System.out.println("--- concatUsingListExample start ---");

        List<Integer> list0 = List.of(1, 2, 3);
        List<Integer> list1 = List.of(4, 5, 6);
        List<Integer> list2 = List.of(7, 8, 9);

        Stream.of(list0, list1, list2)
                .flatMap(x -> x.stream())
                .forEach(System.out::println);

        System.out.println("--- concatUsingListExample end ---");
    }

    public static void concatUsingStreamExample() {
        System.out.println("--- concatUsingStreamExample start ---");

        List<Integer> list0 = List.of(1, 2, 3);
        List<Integer> list1 = List.of(4, 5, 6);
        List<Integer> list2 = List.of(7, 8, 9);

        Stream.of(list0.stream(), list1.stream(), list2.stream())
                .flatMap(Function.identity())
                .forEach(System.out::println);

        System.out.println("--- concatUsingStreamExample end ---");
    }


}

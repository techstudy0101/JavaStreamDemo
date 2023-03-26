package org.example.ch6;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class C1CustomReducerExample {

    public static void main(String[] args) {
//        reduceExample();
        reduceParallelStreamExample();
    }

    public static void reduceExample() {
        Stream<String> strings = Stream.of("one", "two", "three", "four");

        BiFunction<Integer, String, Integer> accumulator =
                (partialReduction, element) -> {
                    System.out.println(
                            "accumulator partialReduction = " + partialReduction
                                    + ", element = " + element
                    );
                    return partialReduction + element.length();
                };


        BinaryOperator<Integer> combiner = (len1, len2) ->  len1 + len2;

        int result = strings
                .reduce(0, accumulator, combiner);

        System.out.println("result = " + result);
    }


    public static void reduceParallelStreamExample() {
        Stream<String> strings = Stream.of("one", "two", "three", "four");

        BiFunction<Integer, String, Integer> accumulator =
                (partialReduction, element) -> {
                    System.out.println(
                            "accumulator ThreadId = " + Thread.currentThread().threadId()
                                    + ", partialReduction = " + partialReduction
                                    + ", element = " + element
                    );
                    return partialReduction + element.length();
                };

        BinaryOperator<Integer> combiner = (len1, len2) -> {
            System.out.println(
                    "combiner ThreadId = " + Thread.currentThread().threadId()
                            + ", len1 = " + len1
                            + ", len2 = " + len2
            );
            return len1 + len2;
        };

        int result = strings
                .parallel()
                .reduce(0, accumulator, combiner);

        System.out.println("result = " + result);
    }

}

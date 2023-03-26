package org.example.ch2;

import java.util.List;
import java.util.stream.Stream;

public class C7StreamExceptionHandling {

    public static void main(String[] args) {
        flatMapExampleWithTryCatch();
        multiMapExample();
    }

    public static void flatMapExampleWithTryCatch() {
        List<String> numbs = List.of("1", "2", "3", "tech", "4", "5");

        numbs.stream()
                .flatMap(numb -> handleWithTryCatchV2(numb))
                .forEach(x -> System.out.println(x));

    }

    public static Stream<Integer> handleWithTryCatchV2(String str) {
        try {
            return Stream.of(Integer.parseInt(str));
        } catch (Exception ex) {
            return Stream.empty();
        }
    }


    public static void multiMapExample() {
        List<String> numbs = List.of("1", "2", "3", "tech", "4", "5");

        // available from java16

        numbs.stream()
                .mapMulti((str, consumer) -> {
                    try {
                        consumer.accept(Integer.parseInt(str));
                    } catch (Exception ex) {
                        System.out.println("Exception for " + str);
                    }
                })
                .forEach(x -> System.out.println(x));

    }


}

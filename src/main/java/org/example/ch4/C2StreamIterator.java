package org.example.ch4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C2StreamIterator {

    public static void main(String[] args) {
        streamIteratorExample();
        streamIteratorPredicateExample();
    }

    public static void streamIteratorExample() {
        System.out.println("--- streamIteratorExample start ---");
        List<Integer> num = Stream.iterate(1, x -> x + 1)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("num = " + num);
        System.out.println("--- streamIteratorExample end ---");
    }

    public static void streamIteratorPredicateExample() {
        System.out.println("--- streamIteratorPredicateExample start ---");
        List<Integer> num = Stream.iterate(1, x -> x <= 10, x -> x + 1)
                .collect(Collectors.toList());
        System.out.println("num = " + num);
        System.out.println("--- streamIteratorPredicateExample end ---");
    }

}

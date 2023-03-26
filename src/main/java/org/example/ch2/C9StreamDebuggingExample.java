package org.example.ch2;

import java.util.List;


public class C9StreamDebuggingExample {

    public static void main(String[] args) {
        debuggingStream();
    }

    public static void debuggingStream() {
        System.out.println("--- debuggingStream start ---");
        List<Integer> numbs = List.of(1, 2, 3, 4, 5, 6, 7);
        numbs.stream()
                .peek(x -> System.out.println("1stStep stream x = " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("2ndStep filter x = " + x))
                .forEach(System.out::println);
        System.out.println("--- debuggingStream end ---");
    }

}

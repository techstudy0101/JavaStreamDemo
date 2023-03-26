package org.example.ch2;

import java.util.List;

public class C6StreamLimitSkipExample {

    public static void main(String[] args) {
        skipExample();
        limitExample();
        skipLimitExample();
        dropWhileExample();
        takeWhileExample();
        takeWhileWithSkipLimitExample();
    }


    public static void skipExample() {
        System.out.println("--- skipExample start ---");
        List<Integer> numbs = List.of(1, 2, 3, -1, 4, 6, 7, 4, 5, 6, 7);

        //Discarding first n elements
        numbs.stream()
                .skip(7)
                .forEach(System.out::println);
        System.out.println("--- skipExample end ---");
    }

    public static void limitExample() {
        System.out.println("--- limitExample start ---");
        List<Integer> numbs = List.of(1, 2, 3, -1, 4, 6, 7, 4, 5, 6, 7);

        //Take first n elements
        numbs.stream()
                .limit(3)
                .forEach(System.out::println);
        System.out.println("--- limitExample end ---");
    }

    public static void skipLimitExample() {
        System.out.println("--- skipLimitExample start ---");
        List<Integer> numbs = List.of(1, 2, 3, 4, 5, 6, 7);

        numbs.stream()
                .skip(3)
                .limit(5)
                .forEach(System.out::println);
        System.out.println("--- skipLimitExample end ---");
    }

    public static void dropWhileExample() {
        System.out.println("--- dropWhileExample start ---");
        List<String> items = List.of("1", "2", "4", "3", " ", "5");


        items.stream()
                .dropWhile(item -> !item.isBlank())
                .forEach(System.out::println);
        System.out.println("--- dropWhileExample end ---");
    }

    public static void takeWhileExample() {
        System.out.println("--- takeWhileExample start ---");
        List<String> items = List.of("1", "2", "4", "3", " ", "5");


        items.stream()
                .takeWhile(item -> !item.isBlank())
                .forEach(System.out::println);
        System.out.println("--- takeWhileExample end ---");
    }


    public static void takeWhileWithSkipLimitExample() {
        System.out.println("--- takeWhileExample start ---");
        List<String> items = List.of("1", "2", "4", "3", " ", "5", "8", "9");


        items.stream()
                .skip(5)
                .takeWhile(item -> !item.isBlank())
                .limit(1)
                .forEach(System.out::println);
        System.out.println("--- takeWhileExample end ---");
    }

}

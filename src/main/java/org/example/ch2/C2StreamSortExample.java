package org.example.ch2;

import org.example.data.Bag;

import java.util.List;

public class C2StreamSortExample {

    public static void main(String[] args) {
        sortExample();
        sortBagExample();
        sortComparatorBagExample();
    }

    public static void sortExample() {
        System.out.println("--- sortExample start ---");
        List<Integer> numbs = List.of(1, 2, 3, -1, 4, 6, 7, 4, 5, 6, 7);

        numbs.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("--- sortExample end ---");
    }

    public static void sortBagExample() {
        System.out.println("--- sortBagExample start ---");
        List<Bag> bags = List.of(
                new Bag(1, 4),
                new Bag(1, 5)
        );

        bags.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("--- sortBagExample end ---");
    }

    public static void sortComparatorBagExample() {
        System.out.println("--- sortBagExample start ---");
        List<Bag> bags = List.of(
                new Bag(1, 4),
                new Bag(1, 5)
        );

        bags.stream()
                .sorted((left, right) -> Integer.compare(right.getNumberOfItems(), left.getNumberOfItems()))
                .forEach(System.out::println);

        System.out.println("--- sortBagExample end ---");
    }
}

package org.example.ch2;

import org.example.data.Bag;

import java.util.List;

public class C3StreamDistinctExample {

    public static void main(String[] args) {
        duplicateExample();
        duplicateBagExample();
    }

    public static void duplicateExample() {
        System.out.println("--- duplicateExample start ---");
        List<String> numbs = List.of("1", "2", "1", "3", "4", "5", "3");

        numbs.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("--- duplicateExample end ---");
    }

    public static void duplicateBagExample() {
        System.out.println("--- duplicateBagExample start ---");
        List<Bag> bags = List.of(
                new Bag(1, 4),
                new Bag(1, 4)
        );

        bags.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("--- duplicateBagExample end ---");
    }

}

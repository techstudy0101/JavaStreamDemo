package org.example.ch1;

import org.example.data.Bag;
import org.example.util.Utils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class C5MapFilterReduceExample {

    // Input -> List of data
    // Map -> converting data to another form
    // filter -> filtering using condition
    // reduce(Output) -> reduction of elements, example -> sum, average, min

    public static void main(String[] args) {

        List<Bag> bags = Bag.getNumbsWithStream(11);
        Utils.printList(bags);
//        forLoopMapFilterReduceExample(bags);
//        streamMapFilterReduceExample(bags);
        streamLazyExample(bags);

    }

    public static void forLoopMapFilterReduceExample(List<Bag> bags) {
        int total = 0;
        for (int i = 0; i < bags.size(); i++) {
            Bag bag = bags.get(i);
            if (bag.getNumberOfItems() % 2 == 0) {  // filter
                int numberOfItems = bag.getNumberOfItems();  // map
                total = total + numberOfItems;  // reduce
            }
        }
        System.out.println("forLoopMapFilterReduceExample total = " + total);
    }

    public static void streamMapFilterReduceExample(List<Bag> bags) {

        Predicate<Bag> evenPredicate = (bag) -> bag.getNumberOfItems() % 2 == 0;

        int total = bags.stream()
                .filter(evenPredicate)
                .map(bag -> bag.getNumberOfItems())
                .reduce(0, Integer::sum);

        System.out.println("streamMapFilterReduceExample total = " + total);
    }


    public static void streamLazyExample(List<Bag> bags) {

        Predicate<Bag> evenPredicate = (bag) -> bag.getNumberOfItems() % 2 == 0;

        Integer total = bags.stream()
                .filter(bag -> {
                    System.out.println("filter bag = " + bag);
                    return evenPredicate.test(bag);
                })
                .map(bag -> {
                    System.out.println("map bag = " + bag);
                    return bag.getNumberOfItems();
                }).reduce(0, Integer::sum);

        System.out.println("streamLazyExample total = " + total);
    }

}

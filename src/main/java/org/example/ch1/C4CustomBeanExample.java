package org.example.ch1;

import org.example.data.Bag;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class C4CustomBeanExample {

    public static void main(String[] args) {

        List<Bag> bags = Bag.getNumbsWithStream(11);
        loopCollection(bags);
        streamCollection(bags);

    }

    public static void loopCollection(List<Bag> bags) {
        System.out.println("--- loopCollection start ---");
        List<Bag> evenItemBags = new ArrayList<>();

        for (int i = 0; i < bags.size(); i++) {
            Bag bag = bags.get(i);
            if (evenPredicate.test(bag)) {
                evenItemBags.add(bag);
            }
        }

        evenItemBags.forEach(printingBag);
        System.out.println("--- loopCollection end ---");
    }

    public static Consumer<Bag> printingBag =
            (bag) -> System.out.println("Bag id = " + bag.getId() + " , numberOfItems = " + bag.getNumberOfItems());

    public static Predicate<Bag> evenPredicate =
            (bag) -> bag.getNumberOfItems() % 2 == 0;

    public static void streamCollection(List<Bag> bags){
        System.out.println("--- streamCollection start ---");
        List<Bag> evenItemBags = bags.stream()
                .filter(evenPredicate)
                .collect(Collectors.toList());

        evenItemBags.forEach(printingBag);
        System.out.println("--- streamCollection end ---");
    }
}

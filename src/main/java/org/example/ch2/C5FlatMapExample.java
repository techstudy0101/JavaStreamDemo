package org.example.ch2;

import org.example.data.Basket;

import java.util.List;

public class C5FlatMapExample {

    public static void main(String[] args) {
        flatMapExample();
    }

    public static void flatMapExample() {
        List<Basket> basketList = Basket.getItemsBasketsWithStream(5);

        basketList.forEach(System.out::println);

        System.out.println("--- After Flat Map ---");

        basketList.stream()
                .flatMap(basket -> basket.items.stream())
                .forEach(basketItem -> System.out.println(basketItem));
    }
}

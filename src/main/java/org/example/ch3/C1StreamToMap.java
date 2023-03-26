package org.example.ch3;

import org.example.data.Basket;
import org.example.util.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C1StreamToMap {

    public static void main(String[] args) {
        streamToMapExample();

        streamToMapValueExample();
    }

    public static void streamToMapExample() {
        List<Basket> basketList = Basket.getItemsBasketsWithStream(10);
        Utils.printList(basketList);
        Map<Integer, Basket> map = basketList.stream()
                .collect(Collectors.toMap(
                        basket -> basket.id,
                        basket -> basket
                ));

        Utils.printMap(map);
    }

    public static void streamToMapValueExample() {
        System.out.println("--- streamToMapValueExample START ---");
        List<Basket> basketList = Basket.getItemsBasketsWithStream(10);
        Utils.printList(basketList);
        Map<Integer, String> map = basketList.stream()
                .collect(Collectors.toMap(
                        basket -> basket.items.size(),
                        basket -> String.valueOf(basket.id),
                        (first, second) -> first + ", " + second
                ));

        Utils.printMap(map);

        System.out.println("--- streamToMapValueExample END ---");
    }

}

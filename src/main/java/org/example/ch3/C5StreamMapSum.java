package org.example.ch3;

import org.example.data.Basket;
import org.example.util.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C5StreamMapSum {

    public static void main(String[] args) {
        streamMapSumExample();
    }

    // BasketId -> CountOfItems
    public static void streamMapSumExample() {
        List<Basket> basketList = Basket.getItemsBasketsWithStream(10);
        Utils.printList(basketList);
        Map<Integer, Integer> map = basketList.stream()
                .collect(Collectors.groupingBy(
                        basket -> basket.id,
                        Collectors.summingInt(x -> x.items.size())
                ));

        Utils.printMap(map);
    }

}

package org.example.ch3;

import org.example.data.Basket;
import org.example.util.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C6StreamMapSumLong {

    public static void main(String[] args) {
        streamMapSumLongExample();
    }

    // BasketItemsSize -> WeightOfItems
    public static void streamMapSumLongExample() {
        List<Basket> basketList = Basket.getItemsBasketsWithStream(10);
        Utils.printList(basketList);
        Map<Integer, Long> map = basketList.stream()
                .collect(Collectors.groupingBy(
                        basket -> basket.items.size(),
                        Collectors.summingLong(x -> x.items.stream().mapToLong(item -> item.weight).sum())
                ));

        Utils.printMap(map);
    }

}

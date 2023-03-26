package org.example.ch3;

import org.example.data.Basket;
import org.example.util.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C4StreamMapGroupByNumberOfItems {

    public static void main(String[] args) {
        streamMapGroupByNumberOfItemsExample();
    }

    // NumberOfItems -> BasketId
    public static void streamMapGroupByNumberOfItemsExample() {
        List<Basket> basketList = Basket.getItemsBasketsWithStream(10);
        Utils.printList(basketList);
        Map<Integer, List<Integer>> map = basketList.stream()
                .collect(Collectors.groupingBy(
                        basket -> basket.items.size(),
                        Collectors.mapping(
                                basket -> basket.id,
                                Collectors.toList()
                        )
                ));

        Utils.printMapListValue(map);
    }

}

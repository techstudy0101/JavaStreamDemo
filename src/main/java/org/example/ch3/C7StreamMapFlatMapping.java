package org.example.ch3;

import org.example.data.Basket;
import org.example.util.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C7StreamMapFlatMapping {

    public static void main(String[] args) {
        streamMapFlatMappingExample();
    }

    // Group By Basket item size -> Flat map of list of items
    public static void streamMapFlatMappingExample() {
        List<Basket> basketList = Basket.getItemsBasketsWithStream(10);
        Utils.printList(basketList);
        Map<Integer, List<Basket.Item>> map = basketList.stream()
                .collect(Collectors.groupingBy(
                        basket -> basket.items.size(),
                        Collectors.flatMapping(basket -> basket.items.stream(), Collectors.toList())
                ));

        Utils.printMapListValue(map);
    }

}

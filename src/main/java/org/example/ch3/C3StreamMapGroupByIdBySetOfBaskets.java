package org.example.ch3;

import org.example.data.Basket;
import org.example.util.Utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class C3StreamMapGroupByIdBySetOfBaskets {

    public static void main(String[] args) {
        streamMapGroupByIdBySetOfBasketsExample();
    }


    // Group by items size -> Set Of baskets
    public static void streamMapGroupByIdBySetOfBasketsExample() {
        List<Basket> basketList = Basket.getItemsBasketsWithStream(10);
        Utils.printList(basketList);
        Map<String, Set<Basket>> map = basketList.stream()
                .collect(Collectors.groupingBy(
                        basket -> "itemsCount=" + basket.items.size(),
                        Collectors.toSet()
                ));

        Utils.printMap(map);
    }


}

package org.example.ch3;

import org.example.data.Basket;
import org.example.util.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C2StreamMapGroupByBasketItemsSize {

    public static void main(String[] args) {
        streamMapGroupByBasketItemsSizeExample();
    }


    // Group by BasketItem size -> List of Basket
    public static void streamMapGroupByBasketItemsSizeExample() {
        List<Basket> basketList = Basket.getItemsBasketsWithStream(10);
        Utils.printList(basketList);
        Map<Integer, List<Basket>> map = basketList.stream()
                .collect(Collectors.groupingBy(
                        basket -> basket.items.size()
                ));

        Utils.printMapListValue(map);
    }
}

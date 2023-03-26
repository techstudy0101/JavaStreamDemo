package org.example.ch3;

import org.example.data.Basket;
import org.example.util.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C8Partitioning {

    public static void main(String[] args) {
        partitioningExample();
    }

    // Partitioning using predicate
    public static void partitioningExample() {
        Map<Boolean, Map<Integer, List<Basket>>> map = Basket.getItemsBasketsWithStream(10)
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                x -> x.items.size() > 1,
                                Collectors.groupingBy(x -> x.id)
                        )
                );

        Utils.printMapMapValue(map);
    }

}

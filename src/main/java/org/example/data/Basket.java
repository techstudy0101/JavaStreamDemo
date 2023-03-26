package org.example.data;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basket {
    public int id;
//    public int numberOfItems;

    public List<Basket.Item> items;

    private static Random weightGenerator = new Random();

    public Basket(int id, int numberOfItems) {
        this.id = id;
//        this.numberOfItems = numberOfItems;
    }

    public Basket(int id, int numberOfItems, List<Basket.Item> items) {
        this.id = id;
//        this.numberOfItems = numberOfItems;
        this.items = items;
    }


    public static List<Basket> getItemsBasketsWithStream(int end) {

        return IntStream.range(1, end)
                .mapToObj(numb -> new Basket(numb, numb, getItems(getItemCount(numb))))
                .collect(Collectors.toList());
    }

    public static int getItemCount(int itemId) {
        return itemId % 2 == 0 ? 2 : 3;
    }

    public static List<Item> getItems(int end) {
        weightGenerator.nextDouble(1, 10);
        return IntStream.range(1, end)
                .mapToObj(numb -> new Item(
                        numb,
                        "F" + numb,
                        weightGenerator.nextLong(1, 10)
                ))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
//                ", numberOfItems=" + numberOfItems +
                ", items=" + items +
                '}';
    }

    public static class Item {
        public int id;

        public String name;

        public long weight;

        public Item(int id, String name, long weight) {
            this.id = id;
            this.name = name;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}

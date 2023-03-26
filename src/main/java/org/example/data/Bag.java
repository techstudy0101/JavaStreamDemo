package org.example.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bag implements Comparable<Bag>{
    int id;
    int numberOfItems;

    private static Random random = new Random();

    public Bag(int id, int numberOfItems) {
        this.id = id;
        this.numberOfItems = numberOfItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public static List<Bag> getNumbsWithLoops() {

        List<Bag> bags = new ArrayList<>();

        for (int i = 1; i < 101; i++) {
            bags.add(new Bag(i, i));
        }

        return bags;
    }

    @Override
    public int hashCode() {
        return (this.id + "," + this.numberOfItems).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(!(obj instanceof Bag))
        {
            return false;
        }

        Bag that = (Bag)obj;

        return this.id == that.id
                && this.numberOfItems == that.numberOfItems;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "id=" + id +
                ", numberOfItems=" + numberOfItems +
                '}';
    }

    public static List<Bag> getNumbsWithStream() {
        return IntStream.range(1, 101)
                .mapToObj(numb -> new Bag(numb, numb))
                .collect(Collectors.toList());
    }

    public static List<Bag> getNumbsWithStream(int end) {
        return IntStream.range(1, end)
                .mapToObj(numb -> new Bag(numb, numb))
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Bag o) {
        return Integer.compare(this.numberOfItems, o.numberOfItems);
    }
}

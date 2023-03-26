package org.example.ch6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C2CustomCollectorExample {

    public static void main(String[] args) {
//        collectExample();
        for(int i = 0; i < 1; i++) {
            collectExampleWithFinisher();
        }
    }

    public static void collectExample() {

        System.out.println("--- collectExampleV2 start ---");

        //Stream<T>
        Stream<String> strings = Stream.iterate(0, x -> x < 10, x -> x + 1)
                .map(i -> String.valueOf(i));

        // Supplier<R>
        Supplier<List<String>> initial = () -> {
            System.out.println("supplier ");
            return new ArrayList<>();
        };

        // Accumulator<R, T>
        BiConsumer<List<String>, String> accumulator = (sb, s) -> {
            System.out.println("accumulator  " + sb + ",   " + s);
            sb.add(s);
        };

        // Combiner<R, R>
        BiConsumer<List<String>, List<String>> combiner = (sb1, sb2) -> {
            System.out.println("combiner  " + sb1 + ",   " + sb2);
            sb1.addAll(sb2);
        };

        List<String> result = strings
                .map(x -> String.valueOf(x))
                .collect(initial, accumulator, combiner);

        result.add("end");

        System.out.println("collectExampleV2 end = " + result.toString());
    }

    public static void collectExampleWithFinisher() {
        System.out.println("--- collectExampleV3 start ---");

        Set<String> strings = Stream.iterate(0, x -> x < 10, x -> x + 1)
                .map(i -> String.valueOf(i))
                .collect(Collectors.toSet());

        System.out.println("set value = " + strings);

        // Supplier<A>
        Supplier<List<String>> initial = () -> {
            System.out.println("supplier " + ", Th = " + Thread.currentThread().threadId());
            return new ArrayList<>();
        };

        // Accumulator<A, T>
        BiConsumer<List<String>, String> accumulator = (sb, s) -> {
            System.out.println("accumulator  " + sb + ",   " + s + ", Th = " + Thread.currentThread().threadId());
            sb.add(s);
        };

        // Combiner<A>
        BinaryOperator<List<String>> combiner = (sb1, sb2) -> {
            System.out.println("combiner --- sb1 = " + sb1 + " , sb2 = " + sb2  + ", Th = " + Thread.currentThread().threadId());
            sb1.addAll(sb2);
            return sb1;
        };

        // Finisher<A, R>
        Function<List<String>, String> finisher = (List<String> sb) -> {
            System.out.println("--- finisher --- sb = " + sb.toString());
            sb.add("end");
            return sb.stream().collect(Collectors.joining());
        };

        Collector<String, List<String>, String> collector = Collector.of(
                initial,
                accumulator,
                combiner,
                finisher,
                Collector.Characteristics.UNORDERED
        );
        String result = strings
                .stream()
                .parallel()
                .map(x -> String.valueOf(x))
                .parallel()
                .collect(
                        collector
                );
        System.out.println("collectExampleV3 end = " + result);
    }
}

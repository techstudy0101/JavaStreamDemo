package org.example.ch6;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class C2CustomCollectorExample {

    public static void main(String[] args) {
//        collectExample();
        collectExampleWithFinisher();
    }

    public static void collectExample() {

        System.out.println("--- collectExampleV2 start ---");

        //Stream<T>
        Stream<String> strings = Stream.iterate(0, x -> x < 10, x -> x + 1)
                .map(i -> String.valueOf(i));

        // Supplier<R>
        Supplier<StringBuffer> initial = () -> {
            System.out.println("supplier ");
            return new StringBuffer("{");
        };

        // Accumulator<R, T>
        BiConsumer<StringBuffer, String> accumulator = (sb, s) -> {
            System.out.println("accumulator  " + sb + ",   " + s);
            sb.append(s);
        };

        // Combiner<R, R>
        BiConsumer<StringBuffer, StringBuffer> combiner = (sb1, sb2) -> {
            System.out.println("combiner  " + sb1 + ",   " + sb2);
            sb1.append(sb2);
        };

        StringBuffer result = strings
                .map(x -> String.valueOf(x))
                .collect(initial, accumulator, combiner);

        result.append("}");

        System.out.println("collectExampleV2 end = " + result.toString());
    }

    public static void collectExampleWithFinisher() {
        System.out.println("--- collectExampleV3 start ---");

        Stream<String> strings = Stream.iterate(0, x -> x < 10, x -> x + 1)
                .map(i -> String.valueOf(i));


        // Supplier<A>
        Supplier<StringBuffer> initial = () -> {
            System.out.println("supplier ");
            return new StringBuffer("{");
        };

        // Accumulator<A, T>
        BiConsumer<StringBuffer, String> accumulator = (sb, s) -> {
            System.out.println("accumulator  " + sb + ",   " + s);
            sb.append(s);
        };

        // Combiner<A>
        BinaryOperator<StringBuffer> combiner = (sb1, sb2) -> {
            System.out.println("combiner ---" + ", Th = " + Thread.currentThread().threadId());
            return sb1.append(sb2);
        };

        // Finisher<A, R>
        Function<StringBuffer, String> finisher = (StringBuffer sb) -> {
            System.out.println("--- finisher --- sb = " + sb.toString());
            return sb.append("}").toString();
        };

        Collector<String, StringBuffer, String> collector = Collector.of(
                initial,
                accumulator,
                combiner,
                finisher,
                Collector.Characteristics.UNORDERED
        );
        String result = strings
                .parallel()
                .map(x -> String.valueOf(x))
                .collect(
                        collector
                );
        System.out.println("collectExampleV3 end = " + result);
    }
}

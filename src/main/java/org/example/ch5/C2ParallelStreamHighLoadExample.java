package org.example.ch5;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C2ParallelStreamHighLoadExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        hitApiSimple();
        hitApiUsingParallelStream();
    }


    public static void hitApiSimple() {
        long start = System.currentTimeMillis();
        Stream<Integer> numbs = Stream.iterate(0, i -> i <= 10, i -> i + 1);

        List<String> responses = numbs
                .map(x -> {
                    String request = "request" + x;
                    return hitApi(request);
                })
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("hitApiSimple Execution Time in ms = " + (end - start));
    }

    public static void hitApiUsingParallelStream() {
        long start = System.currentTimeMillis();
        Stream<Integer> numbs = Stream.iterate(0, i -> i <= 10, i -> i + 1);

        List<String> responses = numbs
                .parallel()
                .map(x -> {
                    String request = "request" + x;
                    return hitApi(request);
                })
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("hitApiUsingParallelStream Execution Time in ms = " + (end - start));
    }

    private static String hitApi(String request) {
        try {
            Thread.sleep(50);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "response of " + request;
    }

}

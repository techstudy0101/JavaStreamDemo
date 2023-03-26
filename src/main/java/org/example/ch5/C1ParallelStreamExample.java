package org.example.ch5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class C1ParallelStreamExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        printNumbersParallelly();
        printNumbersParallellyUsingCustomFork();
    }


    public static void printNumbersParallelly() {

        Stream<Integer> numbs = Stream.iterate(0, i -> i <= 10, i -> i + 1);

        numbs
                .parallel()
                .filter(x -> {
                    System.out.println("Filter Thread " + Thread.currentThread().threadId() + " , x = " + x);
                    return true;
                })
                .forEach(x -> {
                    System.out.println("Thread " + Thread.currentThread().threadId() + " , x = " + x);
                });
    }


    public static void printNumbersParallellyUsingCustomFork() throws ExecutionException, InterruptedException {

        System.out.println("--- printNumbersParallellyUsingCustomFork START ---");
        Stream<Integer> numbs = Stream.iterate(0, i -> i <= 10, i -> i + 1);

        ForkJoinPool customThreadPool = new ForkJoinPool(2);

        customThreadPool.submit(() ->
                numbs
                        .parallel()
                        .forEach(x -> {
                            System.out.println("Thread " + Thread.currentThread().threadId() + " , x = " + x);
                        })
        ).get();

        System.out.println("--- printNumbersParallellyUsingCustomFork END ---");
    }

}

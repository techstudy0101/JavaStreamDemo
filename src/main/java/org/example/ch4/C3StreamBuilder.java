package org.example.ch4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C3StreamBuilder {

    public static void main(String[] args) {
        streamBuilderUsingAddExample();
        streamBuilderUsingAcceptExample();
    }

    public static void streamBuilderUsingAddExample() {
        System.out.println("--- streamBuilderUsingAddExample start ---");
        Stream.Builder<Integer> numbBuilder = Stream.builder();
        numbBuilder = numbBuilder.add(1); // return stream builder
        numbBuilder.add(2);
        Stream<Integer> numbs = numbBuilder.build();
        System.out.println("numb = " + numbs.collect(Collectors.toList()));
        System.out.println("--- streamBuilderUsingAddExample end ---");
    }

    public static void streamBuilderUsingAcceptExample() {
        System.out.println("--- streamBuilderUsingAcceptExample start ---");
        Stream.Builder<Integer> numbBuilder = Stream.builder();
        numbBuilder.accept(1); //return void
        numbBuilder.accept(2);
        Stream<Integer> numbs = numbBuilder.build();
        System.out.println("numb = " + numbs.collect(Collectors.toList()));
        System.out.println("--- streamBuilderUsingAcceptExample end ---");
    }
}

package org.example.ch4;

import java.util.stream.Stream;

public class C1StreamGeneratorUsingSupplier {

    public static void main(String[] args) {
        streamGeneratorUsingSupplierExample();
    }

    public static void streamGeneratorUsingSupplierExample() {
        System.out.println("--- streamGeneratorUsingSupplierExample start ---");
        // without limit, this stream is infinite
        Stream.generate(() -> 5)
                .limit(10)
                .forEach(numb -> System.out.println("numb = " + numb));
        System.out.println("--- streamGeneratorUsingSupplierExample end ---");
    }
}

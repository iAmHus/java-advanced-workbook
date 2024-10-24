package com.practice.java8.streams.main;

import java.util.stream.IntStream;

public class StreamsMain {

    public static void main(String[] args) {

        tryIntStreamOps();

    }

    private static void tryIntStreamOps() {
        IntStream.range(0,5)
               .peek(System.out::println)
               .average()
               .ifPresent(System.out::println);
    }
}

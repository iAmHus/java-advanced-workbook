package com.practice.java8.streams.main;

import com.practice.java8.streams.dao.Item;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsMain {

    public static void main(String[] args) {

        tryIntStreamOps();

        tryStreamOfCustomObjOps();

        tryFlatMap();

    }

    private static void tryFlatMap() {

                Stream.of(
                        Arrays.asList("a", "b"),
                        Arrays.asList("a", "c"))
                        .filter(l -> l.contains("c"))
                        .flatMap(List::stream)
                        .forEach(System.out::println);

    }

    private static void tryStreamOfCustomObjOps() {
        List<Item> itemsList = Arrays.asList(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt"));

        itemsList.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void tryIntStreamOps() {
        IntStream.range(0, 5)
                .average()
                .ifPresent(System.out::println);
    }
}

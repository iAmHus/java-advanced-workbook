package com.practice.java8.streams.main;

import com.practice.java8.streams.dao.Item;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsMain {

    public static void main(String[] args) {

        tryIntStreamOps();

        tryStreamOfCustomObjOps();

    }

    private static void tryStreamOfCustomObjOps() {
        List<Item> itemsList = Arrays.asList(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt"));

        itemsList.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
    }

    private static void tryIntStreamOps() {
        IntStream.range(0,5)
               .peek(System.out::println)
               .average()
               .ifPresent(System.out::println);
    }
}

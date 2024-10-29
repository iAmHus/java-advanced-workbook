package com.practice.java8.streams.main;

import com.practice.java8.lambdas.dao.Person;
import com.practice.java8.streams.dao.Item;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsMain {

    public static void main(String[] args) {

        tryIntStreamOps();

        tryStreamOfCustomObjOps();

        tryFlatMap();

    }


    private static void tryFlatMap() {

        System.out.println("==== Flat Map =====");
        Stream.of(
                        Arrays.asList("a", "b"),
                        Arrays.asList("a", "c"))
                .filter(l -> l.contains("c"))
                .flatMap(List::stream)
                .forEach(System.out::println);

    }

    private static void tryStreamOfCustomObjOps() {

        System.out.println("==== Stream of Custom objs =====");

        List<Item> itemsList = Arrays.asList(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt"));

        itemsList.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
        System.out.println();

        List<Person> personList = List.of(
                new Person("Alan", 22, 5.4),
                new Person("Zoe", 20, 5.3),
                new Person("Peter", 29, 5.6)
        );

        personList.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    }

    private static void tryIntStreamOps() {
        System.out.println("==== Int stream ops =====");

        System.out.println("---- IntStream Range, avg  -----");

        IntStream.range(0, 5)
                .average()
                .ifPresent(System.out::println);


        System.out.println("---- mapToInt  -----");

        var intList = List.of(1, 2, 3);

        System.out.println(intList.stream()
                .mapToInt(Integer::intValue)
                .sum());

        System.out.println("---- reduce ops Optional<T> reduce(BinaryOperator<T> accumulator) -----");
        List.of(10, 47, 33, 23)
                .stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparing(n -> n)))
                .ifPresent(System.out::println);


    }

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");
        }
        return grade;
    }
}
package com.practice.java8.streams.main;

import com.practice.java8.lambdas.dao.Person;
import com.practice.java8.streams.dao.Item;
import com.practice.java8.streams.dao.Book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsMain {

    public static void main(String[] args) {

        tryIntStreamOps();

        tryStreamOfCustomObjOps();

        tryFlatMap();

        System.out.println("=== Trying out Optional ===");
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(45);

        System.out.println(grade1.orElse("UNKNOWN"));

        grade2.ifPresent(System.out::println);
        System.out.println(grade2.orElse("Empty"));


        tryDoubleStreamOps();

        lazyEval();
    }

    private static void lazyEval() {

        System.out.println("=== LAZY EVAL ===");
        List<Integer> ls =
                Arrays.asList(11, 11, 22, 33, 33, 55, 66)
                        ;

        System.out.println(ls.stream()
                .anyMatch(n -> n == 11));


        System.out.println(ls.stream().noneMatch(n -> n % 11 == 0));

    }

    private static void tryDoubleStreamOps() {

        System.out.println("=== Double stream ops ===");
        System.out.println(DoubleStream.of(0, 2, 4)
                .filter(n -> n % 2 != 0)
                .sum());
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

        System.out.println("=== Filter with custom objects ===");

        List.of(new Book("Thinking in Java", 30.0),
                        new Book("Java in 24 hrs", 20.0),
                        new Book("Java Recipes", 10.0))
                .stream()
                .filter(b -> b.getPrice() > 10)
                .mapToDouble(Book::getPrice)
                .average()
                .ifPresent(System.out::println);

        List.of(new Book("Thinking in Java", 30.0),
                        new Book("Java in 24 hrs", 20.0),
                        new Book("Java Recipes", 10.0))
                .stream()
                .filter(b -> b.getPrice() > 90)
                .mapToDouble(Book::getPrice)
                .average()
                .ifPresentOrElse(System.out::println, () -> System.out.println("NO VALUES FOUND"));

        System.out.println("=== Using Collectors.toMap and filtering ====");

        List.of(new Book("Atlas Shrugged", 10.0),
                        new Book("Freedom at midnight", 5.0),
                        new Book("Gone with the wind", 5.0))
                .stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice))
                .entrySet()
                .stream().filter(e -> e.getKey().startsWith("A"))
                .forEach(System.out::println);


        System.out.println("=== IntStream from Custom objs ====");
        System.out.println(List.of(
                        new Person("Bob", 31, 5.4),
                        new Person("Paul", 32, 5.3),
                        new Person("John", 33, 5.6)
                ).stream()
                .filter(p -> p.getAge() < 30)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0));


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
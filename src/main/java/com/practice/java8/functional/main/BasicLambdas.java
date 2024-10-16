package com.practice.java8.functional.main;

import com.practice.java8.functional.interfaces.Printable;
import com.practice.java8.functional.interfaces.Retrievable;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BasicLambdas {

    public static void main(String[] args) {

        consumer();

        supplier();

    }

    private static void consumer() {
        // Invoking Custom consumer and Java util consumer
        Printable<String> printable = (str) -> System.out.println(str);
        printable.print("Printable Lambda");

        Consumer<String> consumer = System.out::println;
        consumer.accept("Printable consumer");

    }

    private static void supplier() {

        Retrievable<Integer> retrievable = () -> {return 77;};
        System.out.println(retrievable.retrieve());

        Supplier<Integer> supplier = () -> {return 77;};
        System.out.println(supplier.get());
    }
}

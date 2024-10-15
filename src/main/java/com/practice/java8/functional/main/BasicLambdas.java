package com.practice.java8.functional.main;

import com.practice.java8.functional.interfaces.Printable;

import java.util.function.Consumer;

public class BasicLambdas {

    public static void main(String[] args) {

        // Invoking Custom consumer and Java util consumer
        Printable<String> printable = (str) -> System.out.println(str);
        printable.print("Printable Lambda");

        Consumer<String> consumer = System.out::println;
        consumer.accept("Printable consumer");

    }
}

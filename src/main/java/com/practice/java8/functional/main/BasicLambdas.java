package com.practice.java8.functional.main;

import com.practice.java8.functional.interfaces.Evaluate;
import com.practice.java8.functional.interfaces.Functionable;
import com.practice.java8.functional.interfaces.Printable;
import com.practice.java8.functional.interfaces.Retrievable;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdas {

    public static void main(String[] args) {

        consumer();

        supplier();

        predicate();

        function();

    }

    private static void consumer() {
        // Invoking Custom consumer and Java util consumer
        Printable<String> printable = (str) -> System.out.println(str);
        printable.print("Printable Lambda");

        Consumer<String> consumer = System.out::println;
        consumer.accept("Printable consumer");

    }

    private static void supplier() {

        Retrievable<Integer> retrievable = () ->  77;
        System.out.println(retrievable.retrieve());

//        return 77 is implicit -> you can do just .... 77;
//        like in the line below

//      Supplier<Integer> supplier = () -> {return 77;};
        Supplier<Integer> supplier = () -> 77;
        System.out.println(supplier.get());
    }

    private static void predicate() {
        Evaluate<Integer> eval = i -> i < 0;

        System.out.println(eval.isNegative(-1));
        System.out.println(eval.isNegative(1));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));

//        we want to know if a number is even (true) – invoke check() with 4 and 7 (true and false)
        check(4, i -> i % 2 == 0);
        check(7, i -> i % 2 == 0);

//        we want to know if a String begins with “Mr.” – invoke check() with “Mr. Joe Bloggs” and “Ms. Ann Bloggs”
        check("Mr. Joe Bloggs", s -> s.startsWith("Mr."));
        check("Ms. Joe Bloggs", s -> s.startsWith("Mr."));

    }

    private static void function() {
        Functionable<Integer, String> functionable = i -> "Number is : " + i;
        System.out.println(functionable.applyThis(25));

        Function<Integer, String> function = i -> "Number is : " + i;
        System.out.println(function.apply(25));
    }

    private static<T> void check (T t, Predicate<T> predicate ) {
        System.out.println(predicate.test(t));
    }
}

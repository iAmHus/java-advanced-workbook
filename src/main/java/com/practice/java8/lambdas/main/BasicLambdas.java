package com.practice.java8.lambdas.main;

import com.practice.java8.lambdas.dao.Person;
import com.practice.java8.lambdas.interfaces.Evaluate;
import com.practice.java8.lambdas.interfaces.Functionable;
import com.practice.java8.lambdas.interfaces.Printable;
import com.practice.java8.lambdas.interfaces.Retrievable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

        sortAge(getPeople());
        System.out.println("*******");
        sortName(getPeople());
        System.out.println("*******");
        sortHeight(getPeople());
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

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));

        return result;
    }

    private static void sortAge(List<Person> people) {
        Function<Person, Integer>  ageExtractorFun = (Person p) -> p.getAge();
        Comparator<Person> comparatorRef = Comparator.comparing(ageExtractorFun);

        people.sort(comparatorRef);

        people.forEach(p -> System.out.println(p.getName() + "-" + p.getAge() + "-" + p.getHeight()));
    }

    private static void sortName(List<Person> people) {
        Comparator<Person> nameComparator = Comparator.comparing(p -> p.getName());

        people.sort(nameComparator);

        people.forEach(p -> System.out.println(p.getName() + "-" + p.getAge() + "-" + p.getHeight()));

    }

    private static void sortHeight(List<Person> people) {
        Comparator<Person> heightComparator = Comparator.comparing(Person::getHeight);
        people.sort(heightComparator);

        people.forEach(p -> System.out.println(p.getName() + "-" + p.getAge() + "-" + p.getHeight()));

    }
}

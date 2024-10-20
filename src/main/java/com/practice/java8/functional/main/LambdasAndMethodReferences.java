package com.practice.java8.functional.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdasAndMethodReferences {

    public static void main(String[] args) {
        staticMR();

        boundMR();
    }

    public static void staticMR() {

        List<Integer> intList = Arrays.asList(1, 2, 7, 4, 5);

        Consumer<List<Integer>> consumer = list -> Collections.sort(list);
        consumer.accept(intList);

        System.out.println(intList);

        List<Integer> intList2 = Arrays.asList(1, 2, 7, 4, 5);
        Consumer<List<Integer>> consumerMR = Collections::sort;
        consumerMR.accept(intList2);

        System.out.println(intList2);
    }

    public static void boundMR() {
        String input = "Mr. Joe Bloggs";

        Predicate<String> predicate = predicateCheck -> input.startsWith(predicateCheck);
        System.out.println(predicate.test("Mr."));
        System.out.println(predicate.test("Mrs."));

        Predicate<String> predicateMR = input::startsWith;
        System.out.println(predicateMR.test("Mr."));
        System.out.println(predicateMR.test("Mrs."));
     }

    public static void unboundMR() {

    }

    public static void constructorMR() {

    }

}



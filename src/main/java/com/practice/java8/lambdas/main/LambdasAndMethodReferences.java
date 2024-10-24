package com.practice.java8.lambdas.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LambdasAndMethodReferences {

    public static void main(String[] args) {
        staticMR();

        boundMR();

        unboundMR();

        constructorMR();
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

//        input.startsWith in the lambda becomes input::startsWith
        Predicate<String> predicateMR = input::startsWith;
        System.out.println(predicateMR.test("Mr."));
        System.out.println(predicateMR.test("Mrs."));
     }

    public static void unboundMR() {
        Predicate<String> predicateUnbound = str -> str.isEmpty();
        System.out.println(predicateUnbound.test(""));
        System.out.println(predicateUnbound.test("xyz"));

        Predicate<String> predicateUnboundMR = String::isEmpty;
        System.out.println(predicateUnboundMR.test(""));
        System.out.println(predicateUnboundMR.test("xyz"));


        BiPredicate<String, String> biPredicate = (str1, str2) -> str1.startsWith(str2);
        System.out.println(biPredicate.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(biPredicate.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String, String> biPredicateMR = String::startsWith;
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Ms."));
    }

    public static void constructorMR() {
        Supplier<List<String>> supplier = () -> new ArrayList<>();
        List<String> list = supplier.get();
        list.add("Lambda");
        System.out.println(list);

        Supplier<List<String>> supplierMR = ArrayList::new;
        List<String> listMR = supplier.get();
        listMR.add("Lambda");
        System.out.println(listMR);

        Function<Integer, List<String>> func = in -> new ArrayList<>(in);
        List<String> listFunc = func.apply(10);

        listFunc.add("Lambda");
        System.out.println(listFunc);

//      This is exactly the same as supplierMR
//        1.  the first method reference was for a Supplier and Supplier’s functional method is T get() and thus,
//        Java knew to look for the ArrayList constructor that takes in NO argument
//        2.  Here, the method reference was for a Function and Function’s functional method is R apply(T t) and thus,
//        Java knew to look for the ArrayList constructor that takes in ONE argument

        Function<Integer, List<String>> funcMR = ArrayList::new;
        List<String> listFuncMr = funcMR.apply(10);

        listFuncMr.add("Lambda");
        System.out.println(listFuncMr);

    }

}



package com.practice.java8.functional.interfaces;

@FunctionalInterface
public interface Evaluate<T> {

    public boolean isNegative(T input);
}


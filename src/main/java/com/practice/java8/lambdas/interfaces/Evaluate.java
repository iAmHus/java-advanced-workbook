package com.practice.java8.lambdas.interfaces;

@FunctionalInterface
public interface Evaluate<T> {

    public boolean isNegative(T input);
}


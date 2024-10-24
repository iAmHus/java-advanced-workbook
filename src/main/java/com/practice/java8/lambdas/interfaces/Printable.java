package com.practice.java8.lambdas.interfaces;

@FunctionalInterface
public interface Printable <T> {

    public void print(T t);
}

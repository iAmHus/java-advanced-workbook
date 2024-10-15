package com.practice.java8.functional.interfaces;

@FunctionalInterface
public interface Printable <T> {

    public void print(T t);
}

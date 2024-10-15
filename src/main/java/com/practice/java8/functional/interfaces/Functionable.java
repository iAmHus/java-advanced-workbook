package com.practice.java8.functional.interfaces;

@FunctionalInterface
public interface Functionable <T, R> {

    public R applyThis(T t);
}

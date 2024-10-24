package com.practice.java8.lambdas.interfaces;

@FunctionalInterface
public interface Functionable <T, R> {

    public R applyThis(T t);
}

package com.practice.java8.lambdas.dao;

public class Person {
    private Integer age;
    private String name;
    private Double height;

    public Person(String name, Integer age,  Double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Person:: Name: " + this.getName() +
                " Age: " + this.getAge() +
                " Height: " + this.getHeight();
    }
}

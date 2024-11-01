package com.practice.java8.streams.dao;

public class Book{
    private String title;     
    private double price;     
    public Book(String title, double price){
        this.title = title;         
        this.price = price;     
    }     
    public String getTitle() {   return title;}
    public double getPrice() {   return price;}
    public String toString() { return title+ " " + price;}
}
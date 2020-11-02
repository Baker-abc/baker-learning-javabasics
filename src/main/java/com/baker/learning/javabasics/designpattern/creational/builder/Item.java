package com.baker.learning.javabasics.designpattern.creational.builder;

public interface Item {
    public String name();

    public Packing packing();

    public float price();
}

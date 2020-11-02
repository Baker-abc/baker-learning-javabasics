package com.baker.learning.javabasics.designpattern.creational.builder;

public class PepsiColdDrinkItemImpl extends ColdDrinkItemImpl {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}

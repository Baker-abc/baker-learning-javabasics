package com.baker.learning.javabasics.designpattern.creational.builder;

public class CokeColdDrinkItemImpl extends ColdDrinkItemImpl {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}

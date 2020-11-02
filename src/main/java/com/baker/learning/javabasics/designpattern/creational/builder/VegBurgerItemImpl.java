package com.baker.learning.javabasics.designpattern.creational.builder;

public class VegBurgerItemImpl extends BurgerItemImpl {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}

package com.baker.learning.javabasics.designpattern.creational.builder;

public class ChickenBurgerItemImpl extends BurgerItemImpl {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}

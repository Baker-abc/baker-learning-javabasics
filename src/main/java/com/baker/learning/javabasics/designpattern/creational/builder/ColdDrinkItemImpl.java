package com.baker.learning.javabasics.designpattern.creational.builder;

public abstract class ColdDrinkItemImpl implements Item {

    @Override
    public Packing packing() {
        return new BottlePackingImpl();
    }
}

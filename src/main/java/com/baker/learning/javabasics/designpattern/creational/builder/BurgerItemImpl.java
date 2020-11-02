package com.baker.learning.javabasics.designpattern.creational.builder;

public abstract class BurgerItemImpl implements Item {

    @Override
    public Packing packing() {
        return new WrapperPackingImpl();
    }
}

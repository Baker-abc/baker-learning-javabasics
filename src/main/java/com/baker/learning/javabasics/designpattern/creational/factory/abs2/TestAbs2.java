package com.baker.learning.javabasics.designpattern.creational.factory.abs2;

/**
 * @author ylp
 * @Description
 * @date 2020/7/1 11:35 下午
 * @see
 */
public class TestAbs2 {

    public static void main(String[] args) {
        AbstractFactory factory = new OneFactory();
        Eat eat = factory.doEat();
        Tool tool = factory.getTool();

        eat.doSomething();
        tool.getSomething();
    }
}

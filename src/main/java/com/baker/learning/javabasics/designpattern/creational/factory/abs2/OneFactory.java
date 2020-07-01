package com.baker.learning.javabasics.designpattern.creational.factory.abs2;

/**
 * @author ylp
 * @Description
 * @date 2020/7/1 11:39 下午
 * @see
 */
public class OneFactory extends AbstractFactory {
    @Override
    public Eat doEat() {
        return new EatApple();
    }

    @Override
    public Tool getTool() {
        return new ToolAK47();
    }
}

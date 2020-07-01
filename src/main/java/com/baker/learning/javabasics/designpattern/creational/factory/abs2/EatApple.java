package com.baker.learning.javabasics.designpattern.creational.factory.abs2;

/**
 * @author ylp
 * @Description
 * @date 2020/7/1 11:30 下午
 * @see
 */
public class EatApple implements Eat {
    @Override
    public void doSomething() {
        System.out.println("eat apple");
    }
}

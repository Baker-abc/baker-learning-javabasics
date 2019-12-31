package com.baker.learning.javabasics.java8.defaultmethods;

/**
 * @description
 * @date 2019/12/30 20:03
 */
public class Dog implements Animal, Animal2 {


    public static void main(String[] args) {
        Animal.ha();
        new Dog().say();
        new Dog().say2();
    }


    @Override
    public void say() {
        Animal.super.say();
    }

    public void say2() {
        Animal2.super.say();
    }
}

package com.baker.learning.javabasics.java8.defaultmethods;

/**
 * @description
 * @date 2019/12/30 19:56
 */
public interface Animal2 {

    default void say() {
        System.out.println("Animal2 default method");
    }

    static void ha() {
        System.out.println("Animal2 static method");
    }
}

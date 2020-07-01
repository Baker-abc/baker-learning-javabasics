package com.baker.learning.javabasics.designpattern.creational.singleton.lazy;

/**
 * @author ylp
 * @Description
 * @date 2020/7/2 12:06 上午
 * @see
 */
public class Test {

    public static void main(String[] args) {
        LazySingleton singleton = LazySingleton.getInstance();
        singleton.doSomething();
    }
}

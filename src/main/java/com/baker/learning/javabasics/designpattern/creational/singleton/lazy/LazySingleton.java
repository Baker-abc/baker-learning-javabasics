package com.baker.learning.javabasics.designpattern.creational.singleton.lazy;

/**
 * @author ylp
 * @Description 单例之懒汉模式
 * @date 2020/7/2 12:02 上午
 * @see
 */
public class LazySingleton {

    private static final LazySingleton singleton = new LazySingleton();

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        return singleton;
    }

    public void doSomething(){
        System.out.println("懒汉模式");
    }
}

package com.baker.learning.javabasics.designpattern.creational.factory.simply;

/**
 * @author ylp
 * @Description 简单工厂
 * @date 2020/7/1 10:01 下午
 * @see
 */
public class Test {

    public static void main(String[] args) {
        HumanFactory.builder("male").beat();
        HumanFactory.builder("female").beat();
    }
}

package com.baker.learning.javabasics.designpattern.creational.factory.abs;

/**
 * @author ylp
 * @Description 抽象工厂
 * @date 2020/7/1 10:01 下午
 * @see
 */
public class Test {

    public static void main(String[] args) {
        BeologyFactory factory = new HumanFactory();
        factory.builder("male").beat();
    }
}

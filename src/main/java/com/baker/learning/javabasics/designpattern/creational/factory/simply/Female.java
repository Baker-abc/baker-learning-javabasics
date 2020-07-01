package com.baker.learning.javabasics.designpattern.creational.factory.simply;

/**
 * @author
 * @Description
 * @date 2020/7/1 9:50 下午
 * @see
 */
public class Female implements Human {
    @Override
    public void eat() {
        System.out.println("女性吃饭");
    }

    @Override
    public void slepp() {
        System.out.println("女性睡觉");
    }

    @Override
    public void beat() {
        System.out.println("女性打架");
    }
}

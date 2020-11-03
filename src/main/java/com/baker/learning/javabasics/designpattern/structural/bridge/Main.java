package com.baker.learning.javabasics.designpattern.structural.bridge;

/**
 * 桥接模式：不同需求组装不同复杂对象，统一实现
 */
public class Main {

    public static void main(String[] args) {
        final Circle red = new Circle(1, 2, 3, new RedDrawAPIImpl());
        final Circle green = new Circle(4, 5, 6, new GreenDrawAPIImpl());

        red.run();
        green.run();
    }
}

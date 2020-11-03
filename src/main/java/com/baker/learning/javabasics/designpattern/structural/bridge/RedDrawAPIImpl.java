package com.baker.learning.javabasics.designpattern.structural.bridge;

public class RedDrawAPIImpl implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("red draw：" + radius + " " + x + " " + y);
    }
}

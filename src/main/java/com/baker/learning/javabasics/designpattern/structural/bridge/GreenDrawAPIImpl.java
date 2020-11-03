package com.baker.learning.javabasics.designpattern.structural.bridge;

public class GreenDrawAPIImpl implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("green draw：" + radius + " " + x + " " + y);
    }
}

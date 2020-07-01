package com.baker.learning.javabasics.designpattern.creational.factory.abs;

/**
 * @author ylp
 * @Description
 * @date 2020/7/1 10:21 下午
 * @see
 */
public abstract class BeologyFactory {

    public abstract Human builder(String type);
}

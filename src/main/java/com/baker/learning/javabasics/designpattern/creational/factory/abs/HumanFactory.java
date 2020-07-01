package com.baker.learning.javabasics.designpattern.creational.factory.abs;

/**
 * @author ylp
 * @Description
 * @date 2020/7/1 10:23 下午
 * @see
 */
public class HumanFactory extends BeologyFactory {
    @Override
    public Human builder(String type) {
        if ("male".equals(type)) {
            return new Male();
        }
        if ("female".equals(type)) {
            return new Female();
        }

        return new Male();
    }
}

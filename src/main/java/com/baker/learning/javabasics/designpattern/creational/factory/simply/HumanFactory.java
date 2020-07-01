package com.baker.learning.javabasics.designpattern.creational.factory.simply;

/**
 * @author
 * @Description
 * @date 2020/7/1 9:52 下午
 * @see
 */
public class HumanFactory {

    public static Human builder(String type) {
        if ("male".equals(type)) {
            return new Male();
        }
        if ("female".equals(type)) {
            return new Female();
        }

        return new Male();
    }
}

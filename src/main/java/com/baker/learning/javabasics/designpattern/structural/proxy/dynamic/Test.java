package com.baker.learning.javabasics.designpattern.structural.proxy.dynamic;

/**
 * @Description 动态代理
 * @date 2020/6/30 12:38 下午
 * @see
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("不使用代理调用");
        Person person = new PersonBakerImpl();
        person.doSomething();

        System.out.println("user dynamic proxy invoke");
        Person proxy = (Person)new JDKDynamicProxy(new PersonBakerImpl()).getTarget();
        proxy.doSomething();

    }
}

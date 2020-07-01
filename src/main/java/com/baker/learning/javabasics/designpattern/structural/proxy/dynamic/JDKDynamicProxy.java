package com.baker.learning.javabasics.designpattern.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @date 2020/6/30 12:26 下午
 * @see
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Person person;

    public JDKDynamicProxy(Person person) {
        this.person = person;
    }

    public Object getTarget() {
        Object proxyInstance = Proxy.newProxyInstance(person.getClass().getClassLoader(),
            person.getClass().getInterfaces(),
            this
        );
        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("对代理方法进行前置增强");
        Object invoke = method.invoke(person, args);
        System.out.println("对代理方法进行后置增强");
        return invoke;
    }
}

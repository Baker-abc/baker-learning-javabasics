package com.baker.learning.javabasics.generic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://juejin.im/post/5d5789d26fb9a06ad0056bd9
 *
 * @description
 *
 * ？ 表示不确定的 java 类型
 * T (type) 表示具体的一个java类型
 * K V (key value) 分别代表java键值中的Key Value
 * E (element) 代表Element
 *
 * T 是一个 确定的 类型，通常用于泛型类和泛型方法的定义，？是一个 不确定 的类型，通常用于泛型方法的调用代码和形参，不能用于定义类和泛型方法。
 *区别1：通过 T 来 确保 泛型参数的一致性
 * 区别2：类型参数可以多重限定而通配符不行
 *
 * @date 2019/12/24 16:48
 */
public class GenericChar {

    static void countLegs (List<? extends Animal > animals ) {
        System.out.println(animals);
    }

    static void countLegs1 (List< Animal > animals ) {
        System.out.println(animals);
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        Dog dog = new Dog();
        dog.setSex("a");
        dogs.add(dog);

        //正确
        countLegs(dogs);

        //错误
//        countLegs1(dogs);
    }
}

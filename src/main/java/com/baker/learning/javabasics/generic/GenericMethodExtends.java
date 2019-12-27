package com.baker.learning.javabasics.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 *  <T extends superClass>表示类型的上界，T 只能是 superClass 或其子类，
 *  <K super childClass>表示类型的下界，K 只能是 childClass 或其父类。
 * @date 2019/11/21 20:47
 */
public class GenericMethodExtends {


    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = new Animal();
        Animal animal1 = new GenericMethodExtends().test(animal,dog);
        System.out.println("我是 T 类型，我的类型是" + animal1.getClass().getName());

        List<Animal> s = new ArrayList<Animal>();
        s.add(dog);
        s.add(animal);
        new GenericMethodExtends().test2(s);

    }

    public <T,S extends T> T test(T t,S s){
        System.out.println("我是 T 类型，我的类型是" + t.getClass().getName());
        System.out.println("我是 S 类型，我的类型是" + s.getClass().getName());
        return t;
    }

    public void test2(List<?> list){
        for (Object object : list) {
            System.out.println("我的类型是" + object.getClass().getName());
        }
    }
}

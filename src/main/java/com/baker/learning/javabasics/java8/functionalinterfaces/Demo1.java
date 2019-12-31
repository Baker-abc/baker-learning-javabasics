package com.baker.learning.javabasics.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * @date 2019/12/28 10:11
 */
public class Demo1 {

    @FunctionalInterface
    interface GreetingService {
        void say(String message);
    }

    public static void main(String[] args) {
        GreetingService greetingService = message -> System.out.println(message);
        greetingService.say("aa");


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("输出所有数据:");

        eval(list, n -> true);

        System.out.println("输出所有偶数:");
        eval(list, n -> n % 2 == 0);

        System.out.println("输出大于 3 的所有数字:");
        eval(list, n -> n > 3);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {

            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}


package com.baker.learning.javabasics.java8.lambda;

/**
 * @description lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误
 * <p>
 * lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
 * @date 2019/12/27 20:11
 */
public class Demo2 {

    final static String test = "hehe";

    public static void main(String[] args) {

        Test2 test2 = message -> System.out.println(message);

        test2.say("haha: " + test);

        int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);
//        num = 5;

    }

    interface Test2 {
        void say(String message);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}

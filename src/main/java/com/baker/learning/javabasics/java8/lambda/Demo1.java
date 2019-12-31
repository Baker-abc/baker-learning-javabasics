package com.baker.learning.javabasics.java8.lambda;

/**
 * @description 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 * @date 2019/12/27 19:52
 */
public class Demo1 {

    public static void main(String[] args) {

        Demo1 demo1 = new Demo1();

        System.out.println("======== 类型声明 =========");
        MathOperation mathOperation = (int a, int b) -> a + b;
        System.out.println(demo1.operate(2, 1, mathOperation));

        System.out.println("======== 非类型声明 =========");
        MathOperation mathOperation2 = (a, b) -> a - b;
        System.out.println(demo1.operate(2, 1, mathOperation2));

        System.out.println("======== 带大括号 =========");
        MathOperation mathOperation3 = (a, b) -> {
            return a - b;
        };
        System.out.println(demo1.operate(2, 1, mathOperation3));


        GreetingService greetingService = (message) -> System.out.println(message);
        greetingService.sayMessage("haha");

        GreetingService greetingService2 = message -> System.out.println(message);
        greetingService2.sayMessage("hehe");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}

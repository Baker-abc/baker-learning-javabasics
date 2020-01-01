package com.baker.learning.javabasics.java8.optional;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @description 为避免繁琐的 object != null
 * @date 2020/1/1 14:06
 */
public class Demo1 {

    public static void main(String[] args) {

        /**
         * Optional.of()或者Optional.ofNullable()：
         * 创建Optional对象，差别在于of不允许参数是null，而ofNullable则无限制。
         */
        System.out.println("=======of() ofNullable() =========");
        Optional<Integer> optional = Optional.of(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);
        Optional<Integer> optional3 = Optional.ofNullable(1);

        /**
         * Optional.empty()：所有null包装成的Optional对象：
         */
        System.out.println("=======.empty()=========");
        Optional<Integer> optional4 = Optional.ofNullable(null);
        Optional<Integer> optional5 = Optional.ofNullable(null);
        System.out.println(optional4 == optional5);
        System.out.println(optional4 == Optional.<Integer>empty());

        /**
         * isPresent()：判断值是否存在
         */
        System.out.println("=======isPresent()=========");
        Optional<Integer> optional6 = Optional.ofNullable(null);
        Optional<Integer> optional7 = Optional.ofNullable(1);
        System.out.println(optional6.isPresent());
        System.out.println(optional7.isPresent());

        /**
         * ifPresent(Consumer consumer)：如果option对象保存的值不是null，则调用consumer对象，否则不调用
         */
        System.out.println("==========ifPresent(Consumer consumer)=========");
        Optional<Integer> optional8 = Optional.ofNullable(null);
        Optional<Integer> optional9 = Optional.ofNullable(1);
        optional8.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        optional9.ifPresent(integer -> System.out.println(integer));
        optional9.ifPresent(System.out::println);

        /**
         * orElse(value)：如果optional对象保存的值不是null，则返回原来的值，否则返回value
         */
        System.out.println("=========== orElse(value) ==========");
        Optional<Integer> optional10 = Optional.ofNullable(1);
        Optional<Integer> optional11 = Optional.ofNullable(null);
        System.out.println(optional10.orElse(10));
        System.out.println(optional11.orElse(10));

        /**
         * orElseGet(Supplier supplier)：功能与orElse一样，只不过orElseGet参数是一个对象
         */
        System.out.println("============= orElseGet(Supplier supplier) ==========");
        Optional<Integer> optional12 = Optional.ofNullable(1);
        Optional<Integer> optional13 = Optional.ofNullable(null);
        System.out.println(optional12.orElseGet(() -> {
            return 10;
        }));
        System.out.println(optional13.orElseGet(() -> {
            return 10;
        }));

        /**
         * orElseThrow()：值不存在则抛出异常，存在则什么不做
         */
        System.out.println("======= orElseThrow() ========");
        Optional<Integer> optional14 = Optional.ofNullable(1);
        Optional<Integer> optional15 = Optional.ofNullable(null);
        try {
            optional14.orElseThrow(() -> {
                throw new RuntimeException("optional14为空");
            });
            optional15.orElseThrow(() -> {
                throw new RuntimeException("optional15为空");
            });
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

        /**
         * filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，满足则返回原始值，不满足则返回empty
         */
        System.out.println("======== filter(Predicate) =========");
        Optional<Integer> optional16 = Optional.ofNullable(1);
        Optional<Integer> optional17 = Optional.ofNullable(null);

        Optional<Integer> filter1 = optional16.filter((a) -> a == null);
        Optional<Integer> filter2 = optional16.filter((a) -> a == 1);
        Optional<Integer> filter3 = optional17.filter((a) -> a == null);
        System.out.println(filter1.isPresent());// false
        System.out.println(filter2.isPresent());// true
        System.out.println(filter2.get().intValue() == 1);// true
        System.out.println(filter3.isPresent());// false

        /**
         * map(Function)：如果值不为null， 对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
         */
        System.out.println("============= map(Function) =========");
        Optional<Integer> optional18 = Optional.ofNullable(1);
        Optional<Integer> optional19 = Optional.ofNullable(null);
        System.out.println(optional18.map((value) -> "key:" + value).get());
        System.out.println(optional19.map((value) -> "key:" + value).isPresent());

        /**
         * flatMap()：功能与map()相似，差别请看如下代码。flatMap方法与map方法类似，
         * 区别在于mapping函数的返回值不同。map方法的mapping函数返回值可以是任何类型T，
         * 而flatMap方法的mapping函数必须是Optional。
         */

        Optional<Integer> optional20 = Optional.ofNullable(1);

        Optional<Optional<String>> str1Optional = optional20.map((a) -> {
            return Optional.<String>of("key" + a);
        });

        Optional<String> str2Optional = optional20.flatMap((a) -> {
            return Optional.<String>of("key" + a);
        });

        System.out.println(str1Optional.get().get());// key1
        System.out.println(str2Optional.get());// key1

    }
}

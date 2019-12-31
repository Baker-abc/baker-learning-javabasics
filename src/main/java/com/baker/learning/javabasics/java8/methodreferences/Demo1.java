package com.baker.learning.javabasics.java8.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @date 2019/12/28 9:58
 */
public class Demo1 {

    public static void main(String[] args) {

        Car car = Car.create(Car::new);
        System.out.println(car);
        List<Car> cars = Arrays.asList(car);

        cars.forEach(Car::collide);

        cars.forEach(Car::repair);

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

        List<String> names = new ArrayList<>();
        names.add("Google");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);


    }
}


@FunctionalInterface
interface Supplier<T> {
    T get();
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
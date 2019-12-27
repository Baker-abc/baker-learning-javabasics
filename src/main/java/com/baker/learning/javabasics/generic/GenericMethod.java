package com.baker.learning.javabasics.generic;

/**
 * @description
 * 讨论“<T>"和"<?>"，首先要区分开两种不同的场景：
 * 第一，声明一个泛型类或泛型方法。
 * 第二，使用泛型类或泛型方法。
 *
 * 类型参数“<T>”主要用于第一种，声明泛型类或泛型方法。 无界通配符“<?>”主要用于第二
 * 种，使用泛型类或泛型方法。
 *
 * @date 2019/11/21 20:38
 */
public class GenericMethod {


    public static <E> void printArray(E[] inputArray) {
        for (E e : inputArray) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        Double[] doubles = {1.2, 1.3, 1.4};

        printArray(integers);

        printArray(doubles);

        Data<Integer> data = new Data<>();
        data.setData(11);
        System.out.println(data);

//        data.PrinterInfo("泛型方法");
        data.PrinterInfo(11);
    }

    private static class Data<T>{
        private T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public <E extends Number> void PrinterInfo(E e){
            System.out.println(e);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "data=" + data +
                    '}';
        }
    }

}

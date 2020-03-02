package com.baker.learning.javabasics.basic;

/**
 * @Description equals  vs  ==
 * equals 比较内存里面的具体数据是否相等。
 *
 * ==：比较地址是否相等
 * 1、字符串：考虑常量池
 *
 * 2、基础类型的包装类：考虑缓存，针对常用的值，避免每次创建都new
 *    byte Byte      -128–127
 *    short Short    -128–127
 *    int Integer    -128—127
 *    long Long      -128—127
 *    float Float    不缓存
 *    double Double  不缓存
 *    char Character 0–127
 *
 * 3、引用类型：仅仅比较地址
 *
 * @Author
 * @Date 2020/3/2 15:04
 **/
public class EqualsAndSame {

    public static void main(String[] args) {
        /**
         *  String类是不可变的,对String类的任何改变,都是返回一个新的String类对象。 String 对象是 System.Char 对象的有序集合，
         *  用于表示字符串。String 对象的值是该有序集合的内容，并且该值是不可变的。
         *
         *  这样的话把String类的引用传递给一个方法,该方法对String的任何改变,对原引用指向的对象没有任何影响,这一点和基本数据类型相似.
         *
         *  String是不可改变的，为了提高效率Java引用了字符串池的概念，例如new String("abc");首先会在String池中创建一个对象“abc”
         *  因为有NEW的 存在所以会分配地址空间copyString池的内容。当出现的String对象在String池中不存在时即在String池中创建该对象。
         *
         */
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = "ab";
        // true 他们都指向了同一个缓冲池内的地址
        System.out.println("s3==s4? " + (s3 == s4));

        String s5 = "a" + "b";
        //true 因为相加的两个为常量所以编译器会把s5="a"+"b"优化为s5="ab"
        System.out.println("s3==s5? " + (s3 == s5));

        String s6 = s1 + s2;
        //false 因为是两个变量的相加所以编译器无法优化，
        // s1+s2即等同于(new StringBuilder(String.valueOf(s1))).append(s2).toString();
        // 在运行时，会有新的String地址空间的分配，而不是指向缓冲池中的“ab”
        System.out.println("s3==s6? " + (s3 == s6));

        //false 根据缓冲池的定义在new的时候实际会新分配地址空间，s7指向的是新分配的地址空间所以与缓冲池地址不同
        String s7 = new String("ab");
        System.out.println("s3==s7? " + (s3 == s7));

        final String s8 = "a";
        final String s9 = "b";
        String s10 = s8 + s9;
        //类似于s3与s5，因为是final类型编译器进行了优化所以相同。
        System.out.println("s3==s10? " + (s3 == s10));

    }
}

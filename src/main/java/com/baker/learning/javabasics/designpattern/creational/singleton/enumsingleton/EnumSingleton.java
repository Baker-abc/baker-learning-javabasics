package com.baker.learning.javabasics.designpattern.creational.singleton.enumsingleton;

/**
 * @author ylp
 * @Description 单例模式之枚举--最佳
 * @date 2020/7/2 12:53 上午
 * @see  https://blog.csdn.net/Wenlong_L/article/details/82817412
 */
public enum EnumSingleton {
    /**
     * 好处
     * 1、序列化与反序列化破坏：反序列化的IO类中对枚举类对象的构造是用class类型与名称进行的，
     *    同一枚举类类型中名称相同的对象一定是同一个，在内存中只有一份，故反序列化出来的对象与原对象相同。
     *    这样就天然抵挡了序列化与反序列化的破坏。
     *
     * 2、防止反射攻击：在newInstance方法中对构造的对象的class信息进行了判断，如果构造的是枚举类，则抛出异常，
     *    可见我们不能通过反射构造枚举类型的实例，这样就天然的使得枚举类实现的单例模式避免了反射攻击。
     *
     * 原理：
     *    枚举类反编译后，其只有一个私有构造器，有一个静态初始化块，在类初始化阶段对枚举类的实例进行初始化，
     *    这些非常符合恶汉式单例模式的构造方式
     *
     */
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }

    public void doSomething(){
        System.out.println("枚举单利真好");
    }
}

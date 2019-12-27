package com.baker.learning.javabasics.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * link https://www.sczyh30.com/posts/Java/java-reflection-1/
 *
 * @description
 * Java 反射主要提供以下功能：
 * 在运行时判断任意一个对象所属的类；
 * 在运行时构造任意一个类的对象；
 * 在运行时判断任意一个类所具有的成员变量和方法（通过反射甚至可以调用private方法）；
 * 在运行时调用任意一个对象的方法
 * 重点：是运行时而不是编译时
 * <p>
 * <p>
 * 四、反射的一些注意事项
 * 由于反射会额外消耗一定的系统资源，因此如果不需要动态地创建一个对象，那么就不需要用反射。
 * 另外，反射调用方法时可以忽略权限检查，因此可能会破坏封装性而导致安全问题。
 * @date 2019/12/24 18:59
 */
public class Test1 {


    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {

        System.out.println("=======  获得 Class 对象  =========");
        System.out.println(Class.forName("com.baker.learning.javabasics.reflection.People"));
        System.out.println(People.class);

        System.out.println("=======  判断是否为某个类的实例  =========");
        System.out.println(new People().getClass().isInstance(new People()));
        System.out.println(new People() instanceof People);

        System.out.println("=======  创建实例  =========");
        instance();
        constructor();

        System.out.println("=======  获取方法  =========");
        // 方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        System.out.println(new People().getClass().getDeclaredMethods());
        // 方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。
        System.out.println(new People().getClass().getMethods());
        System.out.println(new People().getClass().getMethod("setName", String.class));

        System.out.println("=======  获取构造器信息 创建实例 =========");
        System.out.println(People.class.getConstructor().newInstance());
        System.out.println(People.class.getConstructor(String.class).newInstance("bk"));

        System.out.println("=======  获取类的成员变量（字段）信息 =========");
        // 访问公有的成员变量
        System.out.println(new People().getClass().getFields());
        System.out.println(new People().getClass().getField("code").getInt("code"));
        // 所有已声明的成员变量，但不能得到其父类的成员变量
        System.out.println(new People().getClass().getDeclaredFields());

        System.out.println("=======  调用方法 =========");
        Class<?> klass = MethodClass.class;
        //创建methodClass的实例
        Object obj = klass.newInstance();
        //获取methodClass类的add方法
        Method method = klass.getMethod("add", int.class, int.class);
        //调用method对应的方法 => add(1,4)
        Object result = method.invoke(obj, 1, 4);
        System.out.println(result);

        System.out.println("=======  创建一个数组 定长数组！！！！ =========");
        Class<?> cls = Class.forName("java.lang.String");
        Object array = Array.newInstance(cls, 10);
        Array.set(array, 0, "a");
        Array.set(array, 1, "b");
        Array.set(array, 2, "c");
        Array.set(array, 2, "d");
        System.out.println(Array.get(array, 2));


    }

    public static void instance() throws IllegalAccessException, InstantiationException {
        Class<?> c = People.class;
        Object object = c.newInstance();
        System.out.println(object);
    }

    public static void constructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = People.class;
        System.out.println(c.getConstructor().newInstance());
        System.out.println(c.getConstructor(String.class).newInstance("bk"));
    }


}

class MethodClass {
    public final int fuck = 3;

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a + b;
    }
}

class People {

    public static final int code = 1;

    private String name;
    private String sex;

    public People() {

    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(name);
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

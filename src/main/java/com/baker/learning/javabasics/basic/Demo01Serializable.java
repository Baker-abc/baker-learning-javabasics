package com.baker.learning.javabasics.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @description 什么是serialVersionUID
 * 序列化是将对象的状态信息转换为可存储或传输的形式的过程。我们都知道，Java对象是保存在JVM的堆内存中的，也就是说，如果JVM堆不存在了，那么对象也就跟着消失了。
 * <p>
 * 而序列化提供了一种方案，可以让你在即使JVM停机的情况下也能把对象保存下来的方案。就像我们平时用的U盘一样。把Java对象序列化成可存储或传输的形式（如二进制流），
 * 比如保存在文件中。这样，当再次需要这个对象的时候，从文件中读取出二进制流，再从二进制流中反序列化出对象。
 * <p>
 * 虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化 ID 是否一致，这个所谓的序列化ID，
 * 就是我们在代码中定义的serialVersionUID。
 * <p>
 * 《阿里巴巴Java开发手册》中规定，在兼容性升级中，在修改类的时候，不要修改serialVersionUID的原因。
 * * 除非是完全不兼容的两个版本。所以，serialVersionUID其实是验证版本一致性的。
 * <p>
 * 如果serialVersionUID变了会反序列化失败。
 * <p>
 * 如果不设置serialVersionUID，那么在修改类结构后，之前的序列化文件就无法反序列化了。
 * @date 2020/4/30 14:34
 */
public class Demo01Serializable {

    public static void main(String[] args) {
        write();
//        read();
    }

    public static void write() {
        User1 user1 = new User1("baker", 12);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("tmp1"))) {
            objectOutputStream.writeObject(user1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        File file = new File("tmp1");

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            User1 user1 = (User1) objectInputStream.readObject();
            System.out.println(user1.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User1 implements Serializable {

    public static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
}

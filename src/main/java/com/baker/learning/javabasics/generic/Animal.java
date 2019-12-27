package com.baker.learning.javabasics.generic;

/**
 * @description
 * @date 2019/12/23 8:49
 */
public class Animal {

    private String sex;

    public Animal() {
        System.out.println("Animal");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "sex='" + sex + '\'' +
                '}';
    }
}

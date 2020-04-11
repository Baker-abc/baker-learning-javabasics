package com.baker.learning.javabasics.cglib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @description
 * @date 2020/4/11 12:30
 */
public class CopyObjectToObject {

    public static void main(String[] args) {
        Model2 model2 = new Model2("baker", 28, "男");
        Model3 model3 = new Model3();
        BeanCopier beanCopier = BeanCopier.create(Model2.class, Model3.class, false);
        beanCopier.copy(model2, model3, null);

//        org.springframework.beans.BeanUtils.copyProperties(model2, model3);

        System.out.println(model3.toString());

    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Model2 {
        private String name;
        private Integer age;
        private String sex;
    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Model3 {
        private String name;
        private Integer age;
    }
}

package com.baker.learning.javabasics.spring.testStaticUseBean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ylp
 * @Description
 * @date 2020/7/28 8:57 下午
 * @see
 */
@Component
public class TestPostConstruct {


    @Autowired
    private BeanTest beanTest;

    private static TestPostConstruct testPostConstruct;

    @PostConstruct
    public void init(){
        testPostConstruct = this;
        testPostConstruct.beanTest = this.beanTest;
    }

    public static void run(){
        System.out.println(testPostConstruct.beanTest.getS());
    }
}

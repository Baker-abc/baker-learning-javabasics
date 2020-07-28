package com.baker.learning.javabasics.spring;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author ylp
 * @Description
 * @date 2020/7/19 7:09 下午
 * @see
 */
@Lazy
@Component
public class LazyAndPostConstructTest {

    public void test(){
        System.out.println("====== test ======");
    }

    @PostConstruct
    public void init(){
        System.out.println(" ======= postConstrct ===========");
    }
}

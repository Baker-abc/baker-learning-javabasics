package com.baker.learning.javabasics.spring.testStaticUseBean;

import org.springframework.stereotype.Component;

/**
 * @author ylp
 * @Description
 * @date 2020/7/28 8:59 下午
 * @see
 */
@Component
public class BeanTest {

    public String getS(){
        return "测试 set 注入";
    }
}

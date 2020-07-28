package com.baker.learning.javabasics.spring.testStaticUseBean;

/**
 * @author ylp
 * @Description
 * @date 2020/7/28 9:21 下午
 * @see
 */
public class TestApplicationContextAware {

    static BeanTest bean = ApplicationContextAwareTest.getBean(BeanTest.class);

    public static void run() {
        System.out.println(bean.getS());
    }
}

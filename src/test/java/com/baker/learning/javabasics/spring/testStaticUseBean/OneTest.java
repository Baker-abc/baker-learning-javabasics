package com.baker.learning.javabasics.spring.testStaticUseBean;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ylp
 * @Description
 * @date 2020/7/28 9:02 下午
 * @see
 */
@SpringBootTest
public class OneTest {

    @Test
    public void testRun(){
        TestPostConstruct.run();
    }

    @Test
    public void testApplicationContextAware(){
        TestApplicationContextAware.run();
    }

}

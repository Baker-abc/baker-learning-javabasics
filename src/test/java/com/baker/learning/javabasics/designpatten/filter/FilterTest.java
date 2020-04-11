package com.baker.learning.javabasics.designpatten.filter;

import com.baker.learning.javabasics.designpattern.filter.FilterManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description
 * @date 2020/4/11 13:17
 */
@SpringBootTest
public class FilterTest {

    @Autowired
    FilterManager filterManager;

    @Test
    public void test1() {
        filterManager.execute("test");
    }
}

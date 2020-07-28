package com.baker.learning.javabasics.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ylp
 * @Description
 * @date 2020/7/19 7:11 下午
 * @see
 */
@RestController("1")
public class TestController {

    @Autowired
    LazyAndPostConstructTest lazyAndPostConstructTest;

    @GetMapping("/test1")
    public void test(){
        lazyAndPostConstructTest.test();
    }
}

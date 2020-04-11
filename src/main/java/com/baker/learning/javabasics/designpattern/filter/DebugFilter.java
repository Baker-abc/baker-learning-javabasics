package com.baker.learning.javabasics.designpattern.filter;

import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2020/4/11 13:11
 */
@Component
public class DebugFilter implements Filter {
    @Override
    public void execute(String string) {
        System.out.println("DebugFilter " + string);
    }
}

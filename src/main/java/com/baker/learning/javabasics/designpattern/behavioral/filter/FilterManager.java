package com.baker.learning.javabasics.designpattern.behavioral.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description test in test-modules
 * @date 2020/4/11 13:12
 */
@Component
public class FilterManager {

    //这里通过spring ioc初始化
    @Autowired
    private List<Filter> filters = new ArrayList<>();

    public void execute(String request) {
        filters.forEach(filter -> filter.execute(request));
    }
}

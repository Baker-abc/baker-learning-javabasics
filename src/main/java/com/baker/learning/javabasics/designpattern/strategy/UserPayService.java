package com.baker.learning.javabasics.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @Description
 * @Author
 * @Date 2020/3/6 22:42
 **/
public interface UserPayService {
    /**
     * 计算应付价格
     */
    public BigDecimal quote();
}

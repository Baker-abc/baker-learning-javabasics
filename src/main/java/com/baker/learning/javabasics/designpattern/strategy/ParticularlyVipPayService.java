package com.baker.learning.javabasics.designpattern.strategy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Description
 * @Author
 * @Date 2020/3/6 22:33
 **/
@Service
public class ParticularlyVipPayService implements UserPayService, InitializingBean {

    @Override
    public BigDecimal quote() {
        return new BigDecimal("70.00");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.register("ParticularlyVip", this);
    }
}

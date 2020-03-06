package com.baker.learning.javabasics.designpattern.strategy;

import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author
 * @Date 2020/3/6 22:38
 **/
public class UserPayServiceStrategyFactory {

    private static Map<String, UserPayService> services = new ConcurrentHashMap<String, UserPayService>();

    public static UserPayService getByUserType(String type) {
        return services.get(type);

    }

    public static void register(String userType, UserPayService userPayService) {
        Assert.notNull(userType, "userType can't be null");
        services.put(userType, userPayService);
    }

}

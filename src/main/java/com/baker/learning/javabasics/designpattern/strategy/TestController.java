package com.baker.learning.javabasics.designpattern.strategy;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 策略模式 + 工厂模式 + spring-init初始化工厂
 * 实现去除 if-else
 * @Author
 * @Date 2020/3/6 22:54
 **/
@RestController
public class TestController {

    @PostMapping("/strategy")
    public Object test(@RequestBody User user) {
        String vipType = user.getVipType();
        UserPayService strategy = UserPayServiceStrategyFactory.getByUserType(vipType);
        return strategy.quote();
    }


}

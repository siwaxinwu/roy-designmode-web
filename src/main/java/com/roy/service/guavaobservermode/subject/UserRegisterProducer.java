package com.roy.service.guavaobservermode.subject;

import org.springframework.stereotype.Component;

/**
 * 主题对象，提供注册主题方法
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 16:41
 */
@Component
public class UserRegisterProducer extends AbstractProducer<UserRegisterEvent> {

    @Override
    public void post(UserRegisterEvent event) {
        eventBus.post(event);
    }
}

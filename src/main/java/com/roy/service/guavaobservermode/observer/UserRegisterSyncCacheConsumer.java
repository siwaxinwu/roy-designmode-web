package com.roy.service.guavaobservermode.observer;

import com.google.common.eventbus.Subscribe;
import com.roy.service.guavaobservermode.subject.UserRegisterEvent;
import com.roy.service.guavaobservermode.subject.UserRegisterProducer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 16:51
 */
// 观察者对象，监听主题事件
@Component
public class UserRegisterSyncCacheConsumer implements EventConsumer<UserRegisterEvent>, InitializingBean {

    @Resource
    private UserRegisterProducer userRegisterProducer;

    @Override
    public void afterPropertiesSet() {
        userRegisterProducer.registerAsyncEvent(this);
    }

    /**
     * 监听事件
     * @param event 事件
     */
    @Override
    @Subscribe
    public void consume(UserRegisterEvent event) {
        System.out.println("接收到用户注册事件，开始同步 Cache");
        System.out.println(event.getUserDto());
        System.out.println("接收到用户注册事件，同步 Cache 完毕");
    }
}

package com.roy;

import com.roy.service.guavaobservermode.subject.UserDto;
import com.roy.service.guavaobservermode.subject.UserRegisterEvent;
import com.roy.service.guavaobservermode.subject.UserRegisterProducer;
import com.roy.service.javaobservermode.ConcreteObserver;
import com.roy.service.javaobservermode.ConcreteSubject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 16:53
 */

@SpringBootTest
public class UserRegisterProducerTest {

    @Resource
    private UserRegisterProducer userRegisterProducer;

    /**
     * 测试guava的生产消费观察者模式
     */
    @Test
    public void post() {
        UserRegisterEvent event = new UserRegisterEvent();
        event.setUserDto(new UserDto(1L, "张三", LocalDateTime.now()));
        userRegisterProducer.post(event);
    }

    @Test
    public void testJavaObserver() {
        ConcreteObserver concreteObserver = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();
        subject.addObserver(concreteObserver);
        subject.change();
    }



}
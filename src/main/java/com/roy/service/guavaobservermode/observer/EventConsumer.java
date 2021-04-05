package com.roy.service.guavaobservermode.observer;

/**
 * 定义抽象观察者
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 16:45
 */
public interface EventConsumer<T> {
    void consume(T event);
}
package com.roy.service.guavaobservermode.subject;

import com.google.common.eventbus.AsyncEventBus;
import com.roy.service.guavaobservermode.observer.EventConsumer;

import java.util.concurrent.Executors;

/**
 * 定义抽象主题，相当于subject，一对多中的一
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 16:41
 */
public abstract class AbstractProducer<T> {
    public static final AsyncEventBus eventBus = new AsyncEventBus("_event_async_", Executors.newFixedThreadPool(4));

    public void registerAsyncEvent(EventConsumer consumer) {
        eventBus.register(consumer);
    }

    public abstract void post(T event);
}
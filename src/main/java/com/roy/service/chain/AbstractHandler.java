package com.roy.service.chain;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 9:35
 */
public abstract class AbstractHandler {
    protected abstract void doHandle(OrderHandleContext context, OrderHandlerChain chain);

    /**
     * 订单处理器的权重
     */
    protected abstract int weight();
}
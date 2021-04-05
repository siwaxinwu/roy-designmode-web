package com.roy.service.chain.concrete;

import com.roy.service.chain.AbstractHandler;
import com.roy.service.chain.OrderHandleContext;
import com.roy.service.chain.OrderHandlerChain;
import com.roy.service.chain.OrderHandlerWeightEnum;
import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 10:00
 */
@Component
public class SalesOrderHandler extends AbstractHandler {
    @Override
    protected void doHandle(OrderHandleContext context, OrderHandlerChain chain) {
        Double amount = context.getAmount();
        if (amount > 80) {
            context.setAmount(amount * 0.9);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    protected int weight() {
        return OrderHandlerWeightEnum.SALES.getCode();
    }
}

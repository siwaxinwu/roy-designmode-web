package com.roy.service.chain.concrete;

import com.roy.service.chain.AbstractHandler;
import com.roy.service.chain.OrderHandleContext;
import com.roy.service.chain.OrderHandlerChain;
import com.roy.service.chain.OrderHandlerWeightEnum;
import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 10:01
 */
@Component
public class VipOrderHandler extends AbstractHandler {
    @Override
    protected void doHandle(OrderHandleContext context, OrderHandlerChain chain) {
        if (context.getVipLevel() > 2) {
            context.setAmount(context.getAmount() - 5);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    protected int weight() {
        return OrderHandlerWeightEnum.VIP.getCode();
    }
}
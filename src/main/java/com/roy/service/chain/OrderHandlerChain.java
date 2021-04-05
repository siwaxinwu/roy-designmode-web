package com.roy.service.chain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 9:57
 */
@Component
public class OrderHandlerChain implements ApplicationContextAware {
    private List<AbstractHandler> chain = new ArrayList<>(10);

    public void handle(OrderHandleContext context) {
        if (context.getPos() < chain.size()) {
            AbstractHandler handler = chain.get(context.getPos());
            // 移动位于处理器链中的位置
            context.setPos(context.getPos() + 1);
            handler.doHandle(context, this);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, AbstractHandler> beans = applicationContext.getBeansOfType(AbstractHandler.class);
        chain.addAll(beans.values());
        // 根据处理器的权重，对处理器链中元素进行排序
        chain.sort(Comparator.comparingInt(AbstractHandler::weight));
    }
}

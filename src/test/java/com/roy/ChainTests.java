package com.roy;

import com.roy.service.chain.OrderHandleContext;
import com.roy.service.chain.OrderHandlerChain;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest(classes = APP.class)
public class ChainTests {

  @Resource
  private OrderHandlerChain chain;

  /**
   * 应支付金额=订单金额-优惠券优惠金额-促销活动优惠金额-会员权益优惠金额
   *参照 Tomcat 源码中 Filter 的作法，引入了 Chain 类，统一对处理器封装为链，减少客户端使用时出错的可能
   */
  @Test
  public void name() {
    OrderHandleContext order = new OrderHandleContext()
            .setOrderNo("123")
            .setAmount(100d)
            .setVipLevel(3)
            .setCouponNo("111");
    chain.handle(order);
    System.out.println("订单最终金额为： " + order.getAmount());
  }
}

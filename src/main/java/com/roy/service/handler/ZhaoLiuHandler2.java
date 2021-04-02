package com.roy.service.handler;

import org.springframework.stereotype.Component;

@Component
public class ZhaoLiuHandler2 extends AbstractHandler {

  @Override
  public void AAA(String name) {
    // 业务逻辑A
    System.out.println("赵六完成任务");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory2.register("赵六", this);
  }
}

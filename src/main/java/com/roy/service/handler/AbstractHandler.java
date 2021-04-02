package com.roy.service.handler;

import org.springframework.beans.factory.InitializingBean;

/**
 * 模板方法设计模式
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 14:30 2021-03-19
 */
public abstract class AbstractHandler implements InitializingBean {

  public void AAA(String name) {
    throw new UnsupportedOperationException();
  }

  public String BBB(String name) {
    throw new UnsupportedOperationException();
  }
}

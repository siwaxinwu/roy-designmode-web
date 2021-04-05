package com.roy.service.state;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装具体状态实例工厂
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:02
 */
@Component
public class ActivityStateFactory implements ApplicationContextAware {
  public static final Map<Integer, ActivityState> STATE_MAP =
      new HashMap<>(ActivityStateEnum.values().length);

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    Map<String, ActivityState> beans = applicationContext.getBeansOfType(ActivityState.class);
    beans.values().forEach(item -> STATE_MAP.put(item.type(), item));
  }
}

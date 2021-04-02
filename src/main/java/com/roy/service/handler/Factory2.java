package com.roy.service.handler;

import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.Map;

/** 工厂设计模式 */
public class Factory2 {
  private static Map<String, AbstractHandler> strategyMap = Maps.newHashMap();

  public static AbstractHandler getInvokeStrategy(String str) {
    return strategyMap.get(str);
  }

  public static void register(String str, AbstractHandler handler) {
    if (StringUtils.isEmpty(str) || null == handler) {
      return;
    }
    strategyMap.put(str, handler);
  }
}

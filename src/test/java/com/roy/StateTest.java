package com.roy;

import com.roy.service.state.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:06
 */
@SpringBootTest(classes = APP.class)
public class StateTest {

  @Test
  public void test1() {
    // 一般活动都是从数据库查询出来了，此处为方便测试直接 new
    Activity activity =
        new Activity()
            .setId(1L)
            .setName("测试活动")
            .setStatus(ActivityStateEnum.DRAFT.getCode())
            .setCreateTime(LocalDateTime.now());

    ActivityState activityState = ActivityStateFactory.STATE_MAP.get(activity.getStatus());
    ActivityContext context = new ActivityContext();
    context.setActivityState(activityState);

    System.out.println("保存草稿: " + (context.saveDraft(activity) ? "成功" : "失败"));
    System.out.println("更新活动状态为已启用: " + (context.enable(activity) ? "成功" : "失败"));
    System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));
    System.out.println("更新活动状态为已停用: " + (context.disable(activity) ? "成功" : "失败"));
    System.out.println("更新活动状态为已启用: " + (context.enable(activity) ? "成功" : "失败"));
    System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));
    System.out.println("更新活动状态为已结束: " + (context.finish(activity) ? "成功" : "失败"));
    System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));

    // 清理资源
    activityState.clear();
  }
}

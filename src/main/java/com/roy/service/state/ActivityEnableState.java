package com.roy.service.state;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 定义具体状态角色 开启状态角色
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:01
 */
@Component
public class ActivityEnableState extends ActivityState {

  @Resource private ActivityDraftState activityDraftState;
  @Resource private ActivityStartState activityStartState;
  @Resource private ActivityDisableState activityDisableState;

  @Override
  public Integer type() {
    return ActivityStateEnum.ENABLE.getCode();
  }

  @Override
  public boolean saveDraft(Activity activity) {
    ActivityContext activityContext = this.activityContext.get();
    activityContext.setActivityState(activityDraftState);
    return activityContext.saveDraft(activity);
  }

  @Override
  public boolean enable(Activity activity) {
    // 如果当前状态已经是 enable 了，则无法再次 enable
    if (isSameStatus(activity)) {
      return false;
    }
    activity.setStatus(type());
    // TODO 更新数据库
    return true;
  }

  @Override
  public boolean start(Activity activity) {
    ActivityContext activityContext = this.activityContext.get();
    activityContext.setActivityState(activityDraftState);
    return activityContext.start(activity);
  }

  @Override
  public boolean disable(Activity activity) {
    ActivityContext activityContext = this.activityContext.get();
    activityContext.setActivityState(activityDraftState);
    return activityContext.disable(activity);
  }

  @Override
  public boolean finish(Activity activity) {
    // 非进行中的活动状态，不允许直接进行 finish
    return false;
  }
}

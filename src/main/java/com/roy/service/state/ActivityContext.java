package com.roy.service.state;

/**
 * 定义环境角色
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:00
 */
public class ActivityContext {

  /** 持有抽象状态角色引用 */
  private ActivityState activityState;

  public void setActivityState(ActivityState activityState) {
    this.activityState = activityState;
    this.activityState.setActivityContext(this);
  }

  public boolean saveDraft(Activity activity) {
    // 委托具体的状态角色
    return this.activityState.saveDraft(activity);
  }

  public boolean enable(Activity activity) {
    return this.activityState.enable(activity);
  }

  public boolean start(Activity activity) {
    return this.activityState.start(activity);
  }

  public boolean disable(Activity activity) {
    return this.activityState.disable(activity);
  }

  public boolean finish(Activity activity) {
    return this.activityState.finish(activity);
  }
}

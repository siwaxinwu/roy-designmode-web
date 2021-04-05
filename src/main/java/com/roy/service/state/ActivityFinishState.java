package com.roy.service.state;

import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:05
 */
@Component
public class ActivityFinishState extends ActivityState {

  @Override
  public Integer type() {
    return ActivityStateEnum.FINISH.getCode();
  }

  @Override
  public boolean saveDraft(Activity activity) {
    return false;
  }

  @Override
  public boolean enable(Activity activity) {
    return false;
  }

  @Override
  public boolean start(Activity activity) {
    return false;
  }

  @Override
  public boolean disable(Activity activity) {
    return false;
  }

  @Override
  public boolean finish(Activity activity) {
    if (isSameStatus(activity)) {
      return false;
    }
    activity.setStatus(type());
    // TODO 更新数据库
    return true;
  }
}

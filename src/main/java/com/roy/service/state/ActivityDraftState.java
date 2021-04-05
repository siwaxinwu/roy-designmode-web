package com.roy.service.state;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:04
 */
@Component
public class ActivityDraftState extends ActivityState {
  @Resource private ActivityEnableState activityEnableState;

  @Override
  public Integer type() {
    return ActivityStateEnum.DRAFT.getCode();
  }

  @Override
  public boolean saveDraft(Activity activity) {
    // 更新
    if (isSameStatus(activity)) {
      return false;
    }
    activity.setStatus(type());
    // TODO 更新数据库
    return true;
  }

  @Override
  public boolean enable(Activity activity) {
    activityContext.get().setActivityState(activityEnableState);
    return activityContext.get().enable(activity);
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
    return false;
  }
}

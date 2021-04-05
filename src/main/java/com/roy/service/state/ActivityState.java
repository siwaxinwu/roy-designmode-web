package com.roy.service.state;

/**
 * 定义抽象状态角色
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:00
 */
public abstract class ActivityState {

  /** 抽象状态角色需要持有环境上下文对象，防止并发出现线程安全问题，使用 ThreadLocal 进行包装 */
  protected ThreadLocal<ActivityContext> activityContext = new ThreadLocal<>();

  public void setActivityContext(ActivityContext activityContext) {
    this.activityContext.set(activityContext);
  }

  public abstract Integer type();

  /** 判断是否是当前状态 */
  protected boolean isSameStatus(Activity activity) {
    return type().equals(activity.getStatus());
  }

  /** 保存草稿 */
  public abstract boolean saveDraft(Activity activity);

  /** 启用 */
  public abstract boolean enable(Activity activity);

  /** 开始 */
  public abstract boolean start(Activity activity);

  /** 停用 */
  public abstract boolean disable(Activity activity);

  /** 停止 */
  public abstract boolean finish(Activity activity);

  /** 清理资源 */
  public void clear() {
    activityContext.remove();
  }
}

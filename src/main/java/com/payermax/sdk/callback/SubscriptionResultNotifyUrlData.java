package com.payermax.sdk.callback;

import java.io.Serializable;

/**
 * 订阅状态变更通知 - Data 数据
 **/
public class SubscriptionResultNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户创建订阅计划的单号。
      **/
    private String subscriptionRequestId;

    /**
     * 订阅计划
      **/
    private SubscriptionPlan subscriptionPlan;

    /**
     * 用户ID。
      **/
    private String userId;

    public String getSubscriptionRequestId() {
        return subscriptionRequestId;
    }

    public void setSubscriptionRequestId(String subscriptionRequestId) {
        this.subscriptionRequestId = subscriptionRequestId;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 嵌套对象
      **/
    public static final class SubscriptionPlan implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 订阅计划状态。
INACTIVE：未激活
EXPIRED：过期未激活
ACTIVE_FAILED：激活失败
ACTIVE：激活成功
FINISH：订阅完成
CANCEL：订阅取消
TERMINATE：订阅终止
          **/
        private String subscriptionStatus;

        /**
         * PMMAX订阅计划号。
          **/
        private String subscriptionNo;

        public String getSubscriptionStatus() {
            return subscriptionStatus;
        }

        public void setSubscriptionStatus(String subscriptionStatus) {
            this.subscriptionStatus = subscriptionStatus;
        }

        public String getSubscriptionNo() {
            return subscriptionNo;
        }

        public void setSubscriptionNo(String subscriptionNo) {
            this.subscriptionNo = subscriptionNo;
        }

    }
}

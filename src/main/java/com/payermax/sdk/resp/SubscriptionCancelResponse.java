package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 取消订阅计划 - 响应
 **/
public class SubscriptionCancelResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户创建订阅计划的单号。
     */
    private String subscriptionRequestId;

    /**
     * 
     */
    private SubscriptionPlan subscriptionPlan;

    /**
     * 用户号。
     */
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
     */
    public static final class SubscriptionPlan implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 订阅计划状态。
         */
        private String subscriptionStatus;

        /**
         * PMMAX订阅号。
         */
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

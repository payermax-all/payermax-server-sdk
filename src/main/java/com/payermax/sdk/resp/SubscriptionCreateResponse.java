package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 创建订阅计划 - 响应
 **/
public class SubscriptionCreateResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户创建订阅计划的单号。
     */
    private String subscriptionRequestId;

    /**
     * 
     */
    private SubscriptionPlan subscriptionPlan;

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

    /**
     * 嵌套对象
     */
    public static final class SubscriptionPlan implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 订阅计划状态。
INACTIVE：未激活
ACTIVE_FAILED：激活失败
ACTIVE：激活成功
EXPIRED：过期未激活
FINISH：订阅完成
CANCEL：订阅取消
TERMINATE：订阅终止
         */
        private String subscriptionStatus;

        /**
         * PMMAX订阅号
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

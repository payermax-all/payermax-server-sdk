package com.payermax.sdk.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
         * 扣款金额，商户管理订阅计划时必传
         */
        private String periodAmount;

        /**
         * 订阅主题，商户管理订阅计划时必传
         */
        private String subject;

        /**
         * 试用期参数
         */
        private String trialConfig;

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
         * 订阅描述，商户管理订阅计划时必传
         */
        private String description;

        /**
         * 订阅单号，PayerMax管理订阅计划时必传，商户管理订阅计划时不传
         */
        private String subscriptionNo;

        /**
         * 订阅扣款规则，商户管理订阅计划时必传
         */
        private String periodRule;

        /**
         * 价格和坐席列表
         */
        private List<Prices> prices;

        /**
         * 总期数，商户管理订阅计划时必传
         */
        private String totalPeriods;

        /**
         * 优惠期规则
         */
        private String trialPeriodConfig;

        public String getPeriodAmount() {
            return periodAmount;
        }

        public void setPeriodAmount(String periodAmount) {
            this.periodAmount = periodAmount;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTrialConfig() {
            return trialConfig;
        }

        public void setTrialConfig(String trialConfig) {
            this.trialConfig = trialConfig;
        }

        public String getSubscriptionStatus() {
            return subscriptionStatus;
        }

        public void setSubscriptionStatus(String subscriptionStatus) {
            this.subscriptionStatus = subscriptionStatus;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSubscriptionNo() {
            return subscriptionNo;
        }

        public void setSubscriptionNo(String subscriptionNo) {
            this.subscriptionNo = subscriptionNo;
        }

        public String getPeriodRule() {
            return periodRule;
        }

        public void setPeriodRule(String periodRule) {
            this.periodRule = periodRule;
        }

        public List<Prices> getPrices() {
            return prices;
        }

        public void setPrices(List<Prices> prices) {
            this.prices = prices;
        }

        public String getTotalPeriods() {
            return totalPeriods;
        }

        public void setTotalPeriods(String totalPeriods) {
            this.totalPeriods = totalPeriods;
        }

        public String getTrialPeriodConfig() {
            return trialPeriodConfig;
        }

        public void setTrialPeriodConfig(String trialPeriodConfig) {
            this.trialPeriodConfig = trialPeriodConfig;
        }

    }
    /**
     * 数组元素
     */
    public static final class Prices implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 坐席、数量
         */
        private BigDecimal quantity;

        /**
         * 价格ID
         */
        private String priceId;

        public BigDecimal getQuantity() {
            return quantity;
        }

        public void setQuantity(BigDecimal quantity) {
            this.quantity = quantity;
        }

        public String getPriceId() {
            return priceId;
        }

        public void setPriceId(String priceId) {
            this.priceId = priceId;
        }

    }
}

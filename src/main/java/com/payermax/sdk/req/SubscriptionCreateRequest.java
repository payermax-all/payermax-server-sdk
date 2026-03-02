package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.SubscriptionCreateResponse;
import java.io.Serializable;

/**
 * 创建订阅计划
 * PayerMax提供多种类型的订阅计划：普通订阅、n天试用、前n期优惠；可以通过创建订阅计划的入参来控制订阅计划的类型。
 *
 * API 路径: /aggregate-pay/api/gateway/subscriptionCreate
 * 请求方法: POST
 **/
public class SubscriptionCreateRequest extends BaseRequest<SubscriptionCreateResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户创建订阅计划的单号。
      **/
    private String subscriptionRequestId;

    /**
     * 订阅计划信息。
      **/
    private SubscriptionPlan subscriptionPlan;

    /**
     * 订阅结果和扣款结果的通知地址。
      **/
    private String callbackUrl;

    /**
     * 用户id。
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

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    protected String getApiName() {
        return "subscriptionCreate";
    }
    /**
     * 嵌套对象
      **/
    public static final class SubscriptionPlan implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 每期扣款金额。
          **/
        private PeriodAmount periodAmount;

        /**
         * 第一期扣款开始时间。如：2025-02-26T12:00:00+00:00
          **/
        private String firstPeriodStartDate;

        /**
         * 标题。
          **/
        private String subject;

        /**
         * 试用期配置
          **/
        private TrialConfig trialConfig;

        /**
         * 后续的每期扣款提前发起的天数。如advanceDays=2表示提前2天开始发起扣款。
          **/
        private Long advanceDays;

        /**
         * 描述。
          **/
        private String description;

        /**
         * 扣款规则。
          **/
        private PeriodRule periodRule;

        /**
         * 总期数。
          **/
        private Long totalPeriods;

        /**
         * 优惠期配置。
          **/
        private TrialPeriodConfig trialPeriodConfig;

        public PeriodAmount getPeriodAmount() {
            return periodAmount;
        }

        public void setPeriodAmount(PeriodAmount periodAmount) {
            this.periodAmount = periodAmount;
        }

        public String getFirstPeriodStartDate() {
            return firstPeriodStartDate;
        }

        public void setFirstPeriodStartDate(String firstPeriodStartDate) {
            this.firstPeriodStartDate = firstPeriodStartDate;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public TrialConfig getTrialConfig() {
            return trialConfig;
        }

        public void setTrialConfig(TrialConfig trialConfig) {
            this.trialConfig = trialConfig;
        }

        public Long getAdvanceDays() {
            return advanceDays;
        }

        public void setAdvanceDays(Long advanceDays) {
            this.advanceDays = advanceDays;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public PeriodRule getPeriodRule() {
            return periodRule;
        }

        public void setPeriodRule(PeriodRule periodRule) {
            this.periodRule = periodRule;
        }

        public Long getTotalPeriods() {
            return totalPeriods;
        }

        public void setTotalPeriods(Long totalPeriods) {
            this.totalPeriods = totalPeriods;
        }

        public TrialPeriodConfig getTrialPeriodConfig() {
            return trialPeriodConfig;
        }

        public void setTrialPeriodConfig(TrialPeriodConfig trialPeriodConfig) {
            this.trialPeriodConfig = trialPeriodConfig;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class PeriodAmount implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 金额。
          **/
        private Long amount;

        /**
         * 币种。
          **/
        private String currency;

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class TrialConfig implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 试用天数
          **/
        private Long trialDays;

        /**
         * 试用期金额信息
          **/
        private TrialAmount trialAmount;

        public Long getTrialDays() {
            return trialDays;
        }

        public void setTrialDays(Long trialDays) {
            this.trialDays = trialDays;
        }

        public TrialAmount getTrialAmount() {
            return trialAmount;
        }

        public void setTrialAmount(TrialAmount trialAmount) {
            this.trialAmount = trialAmount;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class TrialAmount implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 试用期金额
          **/
        private Long amount;

        /**
         * 试用期币种
          **/
        private String currency;

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class PeriodRule implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 扣款频次。如periodUnit=M、periodCount=1表示每1个月扣款一次。
          **/
        private Long periodCount;

        /**
         * 按M（月），D(日)，W（周），Y（年）扣款。
          **/
        private String periodUnit;

        public Long getPeriodCount() {
            return periodCount;
        }

        public void setPeriodCount(Long periodCount) {
            this.periodCount = periodCount;
        }

        public String getPeriodUnit() {
            return periodUnit;
        }

        public void setPeriodUnit(String periodUnit) {
            this.periodUnit = periodUnit;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class TrialPeriodConfig implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 优惠期数。
          **/
        private Long trialPeriodCount;

        /**
         * 优惠期扣款金额。
          **/
        private TrialPeriodAmount trialPeriodAmount;

        public Long getTrialPeriodCount() {
            return trialPeriodCount;
        }

        public void setTrialPeriodCount(Long trialPeriodCount) {
            this.trialPeriodCount = trialPeriodCount;
        }

        public TrialPeriodAmount getTrialPeriodAmount() {
            return trialPeriodAmount;
        }

        public void setTrialPeriodAmount(TrialPeriodAmount trialPeriodAmount) {
            this.trialPeriodAmount = trialPeriodAmount;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class TrialPeriodAmount implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 金额。
          **/
        private Long amount;

        /**
         * 币种。
          **/
        private String currency;

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }
}

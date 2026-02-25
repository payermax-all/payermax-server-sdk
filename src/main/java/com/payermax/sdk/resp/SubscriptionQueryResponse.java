package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 订阅结果查询 - 响应
 **/
public class SubscriptionQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private List<SubscriptionPaymentDetails> subscriptionPaymentDetails;

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

    /**
     * 商户号。
     */
    private String merchantNo;

    public List<SubscriptionPaymentDetails> getSubscriptionPaymentDetails() {
        return subscriptionPaymentDetails;
    }

    public void setSubscriptionPaymentDetails(List<SubscriptionPaymentDetails> subscriptionPaymentDetails) {
        this.subscriptionPaymentDetails = subscriptionPaymentDetails;
    }

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

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * 数组元素
     */
    public static final class SubscriptionPaymentDetails implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 卡组。
         */
        private String cardOrg;

        /**
         * 支付金额。
         */
        private PayAmount payAmount;

        /**
         * 卡信息	
         */
        private CardInfo cardInfo;

        /**
         * 本期最新一次支付详情。
         */
        private LastPaymentInfo lastPaymentInfo;

        /**
         * 本期开始时间。如：2025-01-13T15:59:59+0000
         */
        private String periodStartTime;

        /**
         * 本期结束时间，如：2025-02-13T15:59:59+0000。
         */
        private String periodEndTime;

        /**
         * 扣款期数。
         */
        private Long subscriptionIndex;

        /**
         * 支付方式。
         */
        private String paymentMethodType;

        /**
         * 本期订单状态。
         */
        private String paymentStatus;

        public String getCardOrg() {
            return cardOrg;
        }

        public void setCardOrg(String cardOrg) {
            this.cardOrg = cardOrg;
        }

        public PayAmount getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(PayAmount payAmount) {
            this.payAmount = payAmount;
        }

        public CardInfo getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }

        public LastPaymentInfo getLastPaymentInfo() {
            return lastPaymentInfo;
        }

        public void setLastPaymentInfo(LastPaymentInfo lastPaymentInfo) {
            this.lastPaymentInfo = lastPaymentInfo;
        }

        public String getPeriodStartTime() {
            return periodStartTime;
        }

        public void setPeriodStartTime(String periodStartTime) {
            this.periodStartTime = periodStartTime;
        }

        public String getPeriodEndTime() {
            return periodEndTime;
        }

        public void setPeriodEndTime(String periodEndTime) {
            this.periodEndTime = periodEndTime;
        }

        public Long getSubscriptionIndex() {
            return subscriptionIndex;
        }

        public void setSubscriptionIndex(Long subscriptionIndex) {
            this.subscriptionIndex = subscriptionIndex;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public void setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class PayAmount implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 金额。
         */
        private Long amount;

        /**
         * 币种。
         */
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
     */
    public static final class CardInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 卡组织，当paymentMethodType为CARD时返回，只有交易成功且用户选择卡组织支付时才返回	
         */
        private String cardOrg;

        /**
         * 发卡国家
         */
        private String country;

        /**
         * 持卡人姓名，掩码返回。
         */
        private String cardHolderName;

        /**
         * 卡有效月。
         */
        private String cardExpirationMonth;

        /**
         * 卡类型，DEBIT、CREDIT等。
         */
        private String cardType;

        /**
         * 卡的所有卡组织，双标卡会返回两个。
         */
        private List<String> totalCardOrg;

        /**
         * 卡有效年。
         */
        private String cardExpirationYear;

        /**
         * 卡信息来源。CARD、`APPLEPAY`、`GOOGLEPAY_PAN`、`GOOGLEPAY_CRYPTOGRAM`、`NETWORK_TOKEN`
         */
        private String source;

        /**
         * 卡性质。`PAN`为真实卡；`NETWORK_TOKEN`为虚拟卡，如APPLEPAY。
         */
        private String type;

        /**
         * 卡号，掩码返回。
         */
        private String cardNumber;

        /**
         * 真实卡号后四位。
         */
        private String cardLast4;

        /**
         * 卡bin号。
         */
        private String cardBinNo;

        public String getCardOrg() {
            return cardOrg;
        }

        public void setCardOrg(String cardOrg) {
            this.cardOrg = cardOrg;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCardHolderName() {
            return cardHolderName;
        }

        public void setCardHolderName(String cardHolderName) {
            this.cardHolderName = cardHolderName;
        }

        public String getCardExpirationMonth() {
            return cardExpirationMonth;
        }

        public void setCardExpirationMonth(String cardExpirationMonth) {
            this.cardExpirationMonth = cardExpirationMonth;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public List<String> getTotalCardOrg() {
            return totalCardOrg;
        }

        public void setTotalCardOrg(List<String> totalCardOrg) {
            this.totalCardOrg = totalCardOrg;
        }

        public String getCardExpirationYear() {
            return cardExpirationYear;
        }

        public void setCardExpirationYear(String cardExpirationYear) {
            this.cardExpirationYear = cardExpirationYear;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getCardLast4() {
            return cardLast4;
        }

        public void setCardLast4(String cardLast4) {
            this.cardLast4 = cardLast4;
        }

        public String getCardBinNo() {
            return cardBinNo;
        }

        public void setCardBinNo(String cardBinNo) {
            this.cardBinNo = cardBinNo;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class LastPaymentInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 支付时间，如：2025-01-12T15:59:59+0000。
         */
        private String payTime;

        /**
         * 支付结果。
PENDING：支付中
SUCCESS：支付成功
FAILED：支付失败
         */
        private String lastPaymentStatus;

        /**
         * 扣款失败code。
         */
        private String errorCode;

        /**
         * 支付单号，可用于退款。
注：成功时必有该值。
         */
        private String tradeToken;

        /**
         * 扣款失败msg。
         */
        private String errorMsg;

        public String getPayTime() {
            return payTime;
        }

        public void setPayTime(String payTime) {
            this.payTime = payTime;
        }

        public String getLastPaymentStatus() {
            return lastPaymentStatus;
        }

        public void setLastPaymentStatus(String lastPaymentStatus) {
            this.lastPaymentStatus = lastPaymentStatus;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getTradeToken() {
            return tradeToken;
        }

        public void setTradeToken(String tradeToken) {
            this.tradeToken = tradeToken;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

    }

    /**
     * 嵌套对象
     */
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

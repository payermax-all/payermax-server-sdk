package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 付款查询 - 响应
 **/
public class PaymentOrderQryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易创建时间，符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss Z
      **/
    private String transactionUtcTime;

    /**
     * PayerMax交易流水号
      **/
    private String tradeNo;

    /**
     * 退票时间，符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss Z
      **/
    private String bounceBackTime;

    /**
     * 资金动账时间，符合rfc3339规范，格式：yyyy-MM-dd'T'HH:mm:ss Z
      **/
    private String fundsFreezeTime;

    /**
     * 交易完成时间，符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss Z
      **/
    private String payFinishTime;

    /**
     * 收款信息（用户）
      **/
    private Destination destination;

    /**
     * 付款信息（商户）
      **/
    private Source source;

    /**
     * 交易附加信息，出款回调升级到3.0版本以上，才会返回该字段。如有需求，可以联系PayerMax技术支持进行调整
      **/
    private AdditionalIdentifier additionalIdentifier;

    /**
     * 通知电话
      **/
    private String notifyPhone;

    /**
     * 交易子状态, 当订单交易状态为PENDING时，PayerMax将提供子状态，展示交易处理进度，具体枚举值请参考：交易子状态介绍。未返回可联系技术支持升级。
      **/
    private String subStatus;

    /**
     * 订单失败错误码，详见错误码
      **/
    private String responseCode;

    /**
     * 附加数据，上送的值
      **/
    private String reference;

    /**
     * 1.FAWRY取款码，2.运营商充值PIN码
      **/
    private String redeemCode;

    /**
     * 交易信息
      **/
    private Trade trade;

    /**
     * 商户订单号
      **/
    private String outTradeNo;

    /**
     * 资金返还时间，符合rfc3339规范，格式：yyyy-MM-dd'T'HH:mm:ss Z
      **/
    private String fundsReturnTime;

    /**
     * 订单过期时间，符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss Z
      **/
    private String expiryTime;

    /**
     * 通知邮箱
      **/
    private String notifyEmail;

    /**
     * 交易状态，SUCCESS成功, FAILED失败 ，PENDING进行中，BOUNCEBACK退票
      **/
    private String status;

    /**
     * 订单失败错误码描述
      **/
    private String responseMsg;

    public String getTransactionUtcTime() {
        return transactionUtcTime;
    }

    public void setTransactionUtcTime(String transactionUtcTime) {
        this.transactionUtcTime = transactionUtcTime;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getBounceBackTime() {
        return bounceBackTime;
    }

    public void setBounceBackTime(String bounceBackTime) {
        this.bounceBackTime = bounceBackTime;
    }

    public String getFundsFreezeTime() {
        return fundsFreezeTime;
    }

    public void setFundsFreezeTime(String fundsFreezeTime) {
        this.fundsFreezeTime = fundsFreezeTime;
    }

    public String getPayFinishTime() {
        return payFinishTime;
    }

    public void setPayFinishTime(String payFinishTime) {
        this.payFinishTime = payFinishTime;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public AdditionalIdentifier getAdditionalIdentifier() {
        return additionalIdentifier;
    }

    public void setAdditionalIdentifier(AdditionalIdentifier additionalIdentifier) {
        this.additionalIdentifier = additionalIdentifier;
    }

    public String getNotifyPhone() {
        return notifyPhone;
    }

    public void setNotifyPhone(String notifyPhone) {
        this.notifyPhone = notifyPhone;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRedeemCode() {
        return redeemCode;
    }

    public void setRedeemCode(String redeemCode) {
        this.redeemCode = redeemCode;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFundsReturnTime() {
        return fundsReturnTime;
    }

    public void setFundsReturnTime(String fundsReturnTime) {
        this.fundsReturnTime = fundsReturnTime;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    /**
     * 嵌套对象
      **/
    public static final class Destination implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 收款方到账金额
          **/
        private String amount;

        /**
         * 收款方-税费币种
          **/
        private String taxCurrency;

        /**
         * 交易币种转换为到账币种的汇率
          **/
        private String exchangeRate;

        /**
         * 收款方-手续费
          **/
        private String fee;

        /**
         * 收款方-手续费币种
          **/
        private String feeCurrency;

        /**
         * 收款方到账金额币种
          **/
        private String currency;

        /**
         * 收款方-税费
          **/
        private String tax;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getTaxCurrency() {
            return taxCurrency;
        }

        public void setTaxCurrency(String taxCurrency) {
            this.taxCurrency = taxCurrency;
        }

        public String getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(String exchangeRate) {
            this.exchangeRate = exchangeRate;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getFeeCurrency() {
            return feeCurrency;
        }

        public void setFeeCurrency(String feeCurrency) {
            this.feeCurrency = feeCurrency;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class Source implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 付款方-扣款金额
          **/
        private String amount;

        /**
         * 付款方-税费币种
          **/
        private String taxCurrency;

        /**
         * 交易币种转换为扣款币种的汇率
          **/
        private String exchangeRate;

        /**
         * 付款方-手续费
          **/
        private String fee;

        /**
         * 付款方-手续费币种
          **/
        private String feeCurrency;

        /**
         * 付款方-扣款币种
          **/
        private String currency;

        /**
         * 付款方-税费
          **/
        private String tax;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getTaxCurrency() {
            return taxCurrency;
        }

        public void setTaxCurrency(String taxCurrency) {
            this.taxCurrency = taxCurrency;
        }

        public String getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(String exchangeRate) {
            this.exchangeRate = exchangeRate;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getFeeCurrency() {
            return feeCurrency;
        }

        public void setFeeCurrency(String feeCurrency) {
            this.feeCurrency = feeCurrency;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class AdditionalIdentifier implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 收款银行/机构的交易单号（依据历史经验，目前仅沙特BankTransfer返回的该单号可以作为凭证跟收款行确认是否到账，交易单号格式如：20240418SAARNBARNB1B44410558522170）
          **/
        private String referenceId;

        public String getReferenceId() {
            return referenceId;
        }

        public void setReferenceId(String referenceId) {
            this.referenceId = referenceId;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class Trade implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 请求中传入的付款金额
          **/
        private String amount;

        /**
         * 付款币种，商户在请求中传入的付款金额对应货币代码
          **/
        private String currency;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
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

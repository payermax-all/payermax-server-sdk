package com.payermax.sdk.callback;

import java.io.Serializable;

/**
 * 本地银行收款通知 - Data 数据
 **/
public class VaResultNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易创建时间，符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
      **/
    private String transactionUtcTime;

    /**
     * 支付要素
      **/
    private PaymentDetail paymentDetail;

    /**
     * 银行单号/外部订单号
      **/
    private String channelTradeNo;

    /**
     * 交易完成时间，符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
      **/
    private String completeTime;

    /**
     * 订单失败错误码,详见[错误码列表]
      **/
    private String errorCode;

    /**
     * PayerMax交易流水号
      **/
    private String requestNo;

    /**
     * TO_BE_PROVED 需要补交材料；SETTLED 交易成功已入账 REJECTED'；交易失败已退回
      **/
    private String status;

    /**
     * 订单失败错误码描述
      **/
    private String errorMsg;

    public String getTransactionUtcTime() {
        return transactionUtcTime;
    }

    public void setTransactionUtcTime(String transactionUtcTime) {
        this.transactionUtcTime = transactionUtcTime;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public String getChannelTradeNo() {
        return channelTradeNo;
    }

    public void setChannelTradeNo(String channelTradeNo) {
        this.channelTradeNo = channelTradeNo;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 嵌套对象
      **/
    public static final class PaymentDetail implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 交易信息
          **/
        private Trade trade;

        /**
         * 付款方账户信息
          **/
        private PayerInfo payerInfo;

        /**
         * 收款方账户信息
          **/
        private PayeeInfo payeeInfo;

        /**
         * 入账信息
          **/
        private Settle settle;

        /**
         * 附加数据，银行转账备注
          **/
        private String remark;

        public Trade getTrade() {
            return trade;
        }

        public void setTrade(Trade trade) {
            this.trade = trade;
        }

        public PayerInfo getPayerInfo() {
            return payerInfo;
        }

        public void setPayerInfo(PayerInfo payerInfo) {
            this.payerInfo = payerInfo;
        }

        public PayeeInfo getPayeeInfo() {
            return payeeInfo;
        }

        public void setPayeeInfo(PayeeInfo payeeInfo) {
            this.payeeInfo = payeeInfo;
        }

        public Settle getSettle() {
            return settle;
        }

        public void setSettle(Settle settle) {
            this.settle = settle;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class Trade implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 银行实际到账金额，单位元
          **/
        private String amount;

        /**
         * 银行实际到账金额对应货币代码
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
    /**
     * 嵌套对象
      **/
    public static final class PayerInfo implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 付款方银行CODE
          **/
        private String bankCode;

        /**
         * 付款方全名
          **/
        private String accountName;

        /**
         * 付款人银行网点号/分行号
          **/
        private String bankBranch;

        /**
         * 付款方账号，根据付款方式不同填入相应账号
          **/
        private String accountNo;

        /**
         * 付款方银行名称
          **/
        private String bankName;

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getBankBranch() {
            return bankBranch;
        }

        public void setBankBranch(String bankBranch) {
            this.bankBranch = bankBranch;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class PayeeInfo implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 收款方账户所属国家
          **/
        private String country;

        /**
         * 银行编码
          **/
        private String bankCode;

        /**
         * 收款方账号
          **/
        private String accountNo;

        /**
         * 收款方昵称
          **/
        private String accountNickName;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountNickName() {
            return accountNickName;
        }

        public void setAccountNickName(String accountNickName) {
            this.accountNickName = accountNickName;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class Settle implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 给商户实际入账金额
          **/
        private String amount;

        /**
         * 税费币种
          **/
        private String taxCurrency;

        /**
         * 手续费
          **/
        private String fee;

        /**
         * 手续费币种
          **/
        private String feeCurrency;

        /**
         * 给商户实际入账金额对应货币代码
          **/
        private String currency;

        /**
         * 税费
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
}

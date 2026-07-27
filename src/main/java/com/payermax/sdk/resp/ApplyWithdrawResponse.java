package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 账户提现发起 - 响应
 **/
public class ApplyWithdrawResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易币种
     */
    private String transactionCurrency;

    /**
     * 订单到达终态时的回调地址
     */
    private String callBackUrl;

    /**
     * 平台订单号
     */
    private String tradeNo;

    /**
     * 到账币种
     */
    private String targetCurrency;

    /**
     * 到账金额
     */
    private String targetAmount;

    /**
     * 汇率时间
     */
    private String rateTime;

    /**
     * 收款银行卡号
     */
    private String payeeBankAccountNo;

    /**
     * 手续费
     */
    private Fee fee;

    /**
     * 备注
     */
    private String remark;

    /**
     * 付款资金账户
     */
    private String payerFundsAccountNo;

    /**
     * 汇率
     */
    private String rate;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 交易金额
     */
    private String transactionAmount;

    /**
     * -PROCESSING 处理中
-SUCCESS 成功
-FAILED 失败
     */
    private String status;

    /**
     * 会员号
     */
    private String memberId;

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getRateTime() {
        return rateTime;
    }

    public void setRateTime(String rateTime) {
        this.rateTime = rateTime;
    }

    public String getPayeeBankAccountNo() {
        return payeeBankAccountNo;
    }

    public void setPayeeBankAccountNo(String payeeBankAccountNo) {
        this.payeeBankAccountNo = payeeBankAccountNo;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayerFundsAccountNo() {
        return payerFundsAccountNo;
    }

    public void setPayerFundsAccountNo(String payerFundsAccountNo) {
        this.payerFundsAccountNo = payerFundsAccountNo;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * 嵌套对象
     */
    public static final class Fee implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 手续费金额
         */
        private String serviceFeeAmount;

        /**
         * 手续费币种
         */
        private String serviceFeeCurrency;

        public String getServiceFeeAmount() {
            return serviceFeeAmount;
        }

        public void setServiceFeeAmount(String serviceFeeAmount) {
            this.serviceFeeAmount = serviceFeeAmount;
        }

        public String getServiceFeeCurrency() {
            return serviceFeeCurrency;
        }

        public void setServiceFeeCurrency(String serviceFeeCurrency) {
            this.serviceFeeCurrency = serviceFeeCurrency;
        }

    }
}

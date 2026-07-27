package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 自由换汇交易发起 - 响应
 **/
public class ApplyExchangeResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private AccountInfo accountInfo;

    /**
     * 汇率版本
     */
    private String rateReferenceId;

    /**
     * 交易币种
     */
    private String transactionCurrency;

    /**
     * 针对交易币种的买卖方向
     */
    private String side;

    /**
     * 平台订单号
     */
    private String tradeNo;

    /**
     * 目标币种
     */
    private String targetCurrency;

    /**
     * 目标金额
     */
    private String targetAmount;

    /**
     * 完成时间
     */
    private String completeTime;

    /**
     * 币种对(=交易币种目标币种)
     */
    private String ccyPair;

    /**
     * 汇率(1交易币种=?目标币种)
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

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getRateReferenceId() {
        return rateReferenceId;
    }

    public void setRateReferenceId(String rateReferenceId) {
        this.rateReferenceId = rateReferenceId;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
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

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public void setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
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

    /**
     * 嵌套对象
     */
    public static final class AccountInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 卖出资金账户
         */
        private String sellFundsAccountNo;

        /**
         * 买入资金账户
         */
        private String buyFundsAccountNo;

        public String getSellFundsAccountNo() {
            return sellFundsAccountNo;
        }

        public void setSellFundsAccountNo(String sellFundsAccountNo) {
            this.sellFundsAccountNo = sellFundsAccountNo;
        }

        public String getBuyFundsAccountNo() {
            return buyFundsAccountNo;
        }

        public void setBuyFundsAccountNo(String buyFundsAccountNo) {
            this.buyFundsAccountNo = buyFundsAccountNo;
        }

    }
}

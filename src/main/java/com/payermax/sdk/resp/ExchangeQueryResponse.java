package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 换汇结果查询 - 响应
 **/
public class ExchangeQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易币种
      **/
    private String transactionCcy;

    /**
     * 针对交易货币的买卖方向，买入BUY,卖出SELL
      **/
    private String side;

    /**
     * PayerMax交易流水号
      **/
    private String tradeNo;

    /**
     * 到账金额
      **/
    private String targetAmount;

    /**
     * 汇率生成时间
      **/
    private String rateTime;

    /**
     * 交易完成时间，符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
      **/
    private String completeTime;

    /**
     * 订单失败错误码
      **/
    private String errorCode;

    /**
     * 汇率版本号
      **/
    private String rateVersion;

    /**
     * 目标币种
      **/
    private String targetCcy;

    /**
     * 订单失败错误码描述
      **/
    private String errorMsg;

    /**
     * 货币对
      **/
    private String ccyPair;

    /**
     * 汇率
      **/
    private String rate;

    /**
     * PayerMax交易流水号
      **/
    private String outTradeNo;

    /**
     * 交易金额
      **/
    private String transactionAmount;

    /**
     * 交易状态，SUCCESS成功, FAILED失败,PENDING进行中； 终态才进行回调
      **/
    private String status;

    public String getTransactionCcy() {
        return transactionCcy;
    }

    public void setTransactionCcy(String transactionCcy) {
        this.transactionCcy = transactionCcy;
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

    public String getRateVersion() {
        return rateVersion;
    }

    public void setRateVersion(String rateVersion) {
        this.rateVersion = rateVersion;
    }

    public String getTargetCcy() {
        return targetCcy;
    }

    public void setTargetCcy(String targetCcy) {
        this.targetCcy = targetCcy;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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

}

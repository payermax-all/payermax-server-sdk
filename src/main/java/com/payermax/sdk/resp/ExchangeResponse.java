package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 换汇申请 - 响应
 **/
public class ExchangeResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private String transactionCcy;

    /**
     * 
     */
    private String side;

    /**
     * 
     */
    private String tradeNo;

    /**
     * 
     */
    private String targetAmount;

    /**
     * 符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
     */
    private String rateTime;

    /**
     * 符合rfc3339规范，格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX
     */
    private String completeTime;

    /**
     * 
     */
    private String errorCode;

    /**
     * 
     */
    private String rateVersion;

    /**
     * 
     */
    private String targetCcy;

    /**
     * 
     */
    private String errorMsg;

    /**
     * 
     */
    private String ccyPair;

    /**
     * 
     */
    private String rate;

    /**
     * 
     */
    private String outTradeNo;

    /**
     * 
     */
    private String transactionAmount;

    /**
     * 
     */
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

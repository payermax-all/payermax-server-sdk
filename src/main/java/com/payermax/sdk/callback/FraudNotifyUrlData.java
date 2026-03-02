package com.payermax.sdk.callback;

import java.io.Serializable;

/**
 * 风控欺诈通知 - Data 数据
 **/
public class FraudNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 原交易金额
      **/
    private String tradeAmount;

    /**
     * 商户订单号
      **/
    private String outTradeNo;

    /**
     * 欺诈接收时间，符合rfc3339规范，格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX 时间需要在当前时间两分钟内	
      **/
    private String receiveDate;

    /**
     * 商户外部用户唯一标识
      **/
    private String outUserId;

    /**
     * 原交易币种
      **/
    private String tradeCurrency;

    /**
     * 商户号唯一标识编号
      **/
    private String merchantNo;

    /**
     * 原交易创建时间，符合rfc3339规范，格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX 时间需要在当前时间两分钟内	
      **/
    private String tradeCreateTime;

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getOutUserId() {
        return outUserId;
    }

    public void setOutUserId(String outUserId) {
        this.outUserId = outUserId;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTradeCreateTime() {
        return tradeCreateTime;
    }

    public void setTradeCreateTime(String tradeCreateTime) {
        this.tradeCreateTime = tradeCreateTime;
    }

}

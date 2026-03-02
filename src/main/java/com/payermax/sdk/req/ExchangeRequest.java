package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ExchangeResponse;
import java.io.Serializable;

/**
 * 换汇申请
 * 换汇功能用于将商户不同币种之间的可用余额进行换汇（当前仅支持其中一个币种为USD）。
 *
 * API 路径: /aggregate-pay/api/gateway/exchange
 * 请求方法: POST
 **/
public class ExchangeRequest extends BaseRequest<ExchangeResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易货币
      **/
    private String transactionCcy;

    /**
     * 针对交易货币的买卖方向，买入BUY,卖出SELL
      **/
    private String side;

    /**
     * 货币对
      **/
    private String ccyPair;

    /**
     * 商户订单号
      **/
    private String outTradeNo;

    /**
     * 交易货币金额
      **/
    private String transactionAmount;

    /**
     * 目标币种
      **/
    private String targetCcy;

    /**
     * 汇率版本，如果不输入则表示使用最近一次版本进行交易
      **/
    private String rateVersion;

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

    public String getCcyPair() {
        return ccyPair;
    }

    public void setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
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

    public String getTargetCcy() {
        return targetCcy;
    }

    public void setTargetCcy(String targetCcy) {
        this.targetCcy = targetCcy;
    }

    public String getRateVersion() {
        return rateVersion;
    }

    public void setRateVersion(String rateVersion) {
        this.rateVersion = rateVersion;
    }

    @Override
    protected String getApiName() {
        return "exchange";
    }
}

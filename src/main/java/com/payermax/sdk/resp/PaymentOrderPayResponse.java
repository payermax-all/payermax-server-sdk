package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 申请付款 - 响应
 **/
public class PaymentOrderPayResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PayerMax交易流水号
     */
    private String tradeNo;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 交易状态
     */
    private String status;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 收银台-下单  - 响应
 **/
public class OrderAndPayResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 跳转地址	
     */
    private String redirectUrl;

    /**
     * 商户订单号	
     */
    private String outTradeNo;

    /**
     * PayerMax流水号	
     */
    private String tradeToken;

    /**
     * 交易状态，详见【[交易状态](https://docs-v2.payermax.com/doc-center/appendix/collection/transaction-status.html)】
     */
    private String status;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

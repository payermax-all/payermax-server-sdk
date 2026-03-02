package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 商户入账结果确认 - 响应
 **/
public class OrderConfirmResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户的还款合同号，其中前五位由PayerMax生成。
      **/
    private String referenceNo;

    /**
     * PayerMax订单号。
      **/
    private String tradeToken;

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

}

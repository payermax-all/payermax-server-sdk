package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * paymentTokenID查询 - 响应
 **/
public class InquirePaymentTokenResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * token列表
     */
    private String tokenList;

    public String getTokenList() {
        return tokenList;
    }

    public void setTokenList(String tokenList) {
        this.tokenList = tokenList;
    }

}

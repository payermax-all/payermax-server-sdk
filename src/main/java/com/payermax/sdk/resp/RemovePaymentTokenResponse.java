package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * paymentTokenID解绑 - 响应
 **/
public class RemovePaymentTokenResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PMMax token
     */
    private String paymentTokenID;

    /**
     * token状态
     */
    private String paymentTokenStatus;

    /**
     * 商户内部的的用户号，必须唯一
     */
    private String userId;

    public String getPaymentTokenID() {
        return paymentTokenID;
    }

    public void setPaymentTokenID(String paymentTokenID) {
        this.paymentTokenID = paymentTokenID;
    }

    public String getPaymentTokenStatus() {
        return paymentTokenStatus;
    }

    public void setPaymentTokenStatus(String paymentTokenStatus) {
        this.paymentTokenStatus = paymentTokenStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}

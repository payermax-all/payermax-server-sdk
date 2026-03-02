package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * PaymentTokenID申请 - 响应
 **/
public class ApplyPaymentTokenResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * token认证地址，当status=PENDING时有值
      **/
    private String redirectUrl;

    /**
     * 请求单号
      **/
    private String requestId;

    /**
     * token值，当status=SUCCESS时有值
      **/
    private String paymentTokenID;

    /**
     * 状态
      **/
    private String status;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPaymentTokenID() {
        return paymentTokenID;
    }

    public void setPaymentTokenID(String paymentTokenID) {
        this.paymentTokenID = paymentTokenID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

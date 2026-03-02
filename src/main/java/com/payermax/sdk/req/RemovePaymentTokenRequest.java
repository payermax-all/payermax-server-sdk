package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.RemovePaymentTokenResponse;
import java.io.Serializable;

/**
 * paymentTokenID解绑
 *
 * API 路径: /aggregate-pay/api/gateway/removePaymentToken
 * 请求方法: POST
 **/
public class RemovePaymentTokenRequest extends BaseRequest<RemovePaymentTokenResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PMMax token
      **/
    private String paymentTokenID;

    /**
     * 解绑原因
      **/
    private String removeReason;

    /**
     * 商户内部的的用户号，必须唯一
      **/
    private String userId;

    public String getPaymentTokenID() {
        return paymentTokenID;
    }

    public void setPaymentTokenID(String paymentTokenID) {
        this.paymentTokenID = paymentTokenID;
    }

    public String getRemoveReason() {
        return removeReason;
    }

    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    protected String getApiName() {
        return "removePaymentToken";
    }
}

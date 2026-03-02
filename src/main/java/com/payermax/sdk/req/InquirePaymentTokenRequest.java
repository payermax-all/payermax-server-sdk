package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.InquirePaymentTokenResponse;
import java.io.Serializable;

/**
 * paymentTokenID查询
 *
 * API 路径: /aggregate-pay/api/gateway/inquirePaymentToken
 * 请求方法: POST
 **/
public class InquirePaymentTokenRequest extends BaseRequest<InquirePaymentTokenResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 不填默认为tokenAcq
      **/
    private String tokenScope;

    /**
     * 目标机构，当paymentMethodType=CARD时，该字段不传或传空字符串
      **/
    private String targetOrg;

    /**
     * 卡组，当paymentMethodType=CARD时，可传VISA、MASTERCARD等卡组
      **/
    private String cardOrg;

    /**
     * token绑定的唯一标识
      **/
    private String referralCode;

    /**
     * PMMax token
      **/
    private String paymentTokenID;

    /**
     * 商户内部的的用户号，必须唯一
      **/
    private String userId;

    /**
     * 支付方式类型，可传CARD、WALLET等
      **/
    private String paymentMethodType;

    public String getTokenScope() {
        return tokenScope;
    }

    public void setTokenScope(String tokenScope) {
        this.tokenScope = tokenScope;
    }

    public String getTargetOrg() {
        return targetOrg;
    }

    public void setTargetOrg(String targetOrg) {
        this.targetOrg = targetOrg;
    }

    public String getCardOrg() {
        return cardOrg;
    }

    public void setCardOrg(String cardOrg) {
        this.cardOrg = cardOrg;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getPaymentTokenID() {
        return paymentTokenID;
    }

    public void setPaymentTokenID(String paymentTokenID) {
        this.paymentTokenID = paymentTokenID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    @Override
    protected String getApiName() {
        return "inquirePaymentToken";
    }
}

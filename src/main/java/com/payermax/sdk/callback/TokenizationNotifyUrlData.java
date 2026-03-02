package com.payermax.sdk.callback;

import java.io.Serializable;

/**
 * 异步通知 - Data 数据
 **/
public class TokenizationNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 适用范围
      **/
    private String tokenScope;

    /**
     * 国家编码
      **/
    private String country;

    /**
     * token是否支持MIT的标识
      **/
    private Boolean supportMIT;

    /**
     * 掩码卡号，按照前6后4脱敏，如533333**2222
      **/
    private String cardInfo;

    /**
     * token状态，卡token支付时，此字段为必填
      **/
    private String paymentTokenStatus;

    /**
     * 商户内部的的用户号，必须唯一
      **/
    private String userId;

    /**
     * token有效期，符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
      **/
    private String paymentTokenExpiry;

    /**
     * 目标机构，当paymentMethodType不是CARD时，值为DANA、GCASH等，paymentMethodType为CARD时，targetOrg为空字符串
      **/
    private String targetOrg;

    /**
     * 是否需要CVV。 Y: 使用Token支付时需要再次输入CVV; N:使用Token支付时不需要再次输入CVV。 注：根据发卡行规则存在再次验证CVV的情况
      **/
    private String ifCVV;

    /**
     * token申请单号，最新回调版本返回字段，
      **/
    private String requestId;

    /**
     * 原支付交易对应的商户订单号。只有当第一次授权绑卡支付成功后的通知接口中返回改字段。paymentTokenStatus 状态发生变更再次通知商户时，该字段为空。
      **/
    private String outTradeNo;

    /**
     * token绑定唯一标识
      **/
    private String referralCode;

    /**
     * PMMax token	
      **/
    private String paymentTokenID;

    /**
     * 掩码授权账号，如63-9****72123，paymentMethodType为CARD时，accountDisplay为空字符串，paymentMethodType值不是CARD时，显示掩码授权账号
      **/
    private String accountDisplay;

    /**
     * 卡组，如Visa，Mastercard，双标卡则都返回
      **/
    private String brand;

    /**
     * 支付方式类型，值为CARD、ONE_TOUCH等
      **/
    private String paymentMethodType;

    /**
     * token申请状态
      **/
    private String status;

    public String getTokenScope() {
        return tokenScope;
    }

    public void setTokenScope(String tokenScope) {
        this.tokenScope = tokenScope;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getSupportMIT() {
        return supportMIT;
    }

    public void setSupportMIT(Boolean supportMIT) {
        this.supportMIT = supportMIT;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
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

    public String getPaymentTokenExpiry() {
        return paymentTokenExpiry;
    }

    public void setPaymentTokenExpiry(String paymentTokenExpiry) {
        this.paymentTokenExpiry = paymentTokenExpiry;
    }

    public String getTargetOrg() {
        return targetOrg;
    }

    public void setTargetOrg(String targetOrg) {
        this.targetOrg = targetOrg;
    }

    public String getIfCVV() {
        return ifCVV;
    }

    public void setIfCVV(String ifCVV) {
        this.ifCVV = ifCVV;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    public String getAccountDisplay() {
        return accountDisplay;
    }

    public void setAccountDisplay(String accountDisplay) {
        this.accountDisplay = accountDisplay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

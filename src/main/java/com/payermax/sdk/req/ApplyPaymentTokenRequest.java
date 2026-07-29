package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ApplyPaymentTokenResponse;
import java.io.Serializable;

/**
 * PaymentTokenID申请
 *
 * API 路径: /aggregate-pay/api/gateway/applyPaymentToken
 * 请求方法: POST
 **/
public class ApplyPaymentTokenRequest extends BaseRequest<ApplyPaymentTokenResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 目标机构，当paymentMethodType=BANKTRANSFER，值传YUSHANBANK
     */
    private String targetOrg;

    /**
     * 固定值：tokenAcq
     */
    private String tokenScope;

    /**
     * 国家代码，大写字母
     */
    private String country;

    /**
     * 详见风控业务数据商户上送信息
     */
    private Object riskParams;

    /**
     * 卡信息，当paymentMethodType=CARD时，必需
     */
    private String cardInfo;

    /**
     * 商户指定的跳转URL，完成token绑定后会被跳转到该地址，以http/https开头或者商户应用的scheme地址。
     */
    private String frontCallbackUrl;

    /**
     * 请求单号，唯一标识商户的一笔请求
     */
    private String requestId;

    /**
     * 
     */
    private String envInfo;

    /**
     * mit类型，token申请完成后用于mit代扣的类型；为空时，生成的token只能用于CIT；不为空时，值为SCHEDULE、UNSCHEDULE，生成的token可用于CIT和MIT代扣
     */
    private String mitType;

    /**
     * 支付方式类型，支持CARD、BANKTRANSFER
     */
    private String paymentMethodType;

    /**
     * 商户内部的用户Id，需要保证每个ID唯一性
     */
    private String userId;

    public String getTargetOrg() {
        return targetOrg;
    }

    public void setTargetOrg(String targetOrg) {
        this.targetOrg = targetOrg;
    }

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

    public Object getRiskParams() {
        return riskParams;
    }

    public void setRiskParams(Object riskParams) {
        this.riskParams = riskParams;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getFrontCallbackUrl() {
        return frontCallbackUrl;
    }

    public void setFrontCallbackUrl(String frontCallbackUrl) {
        this.frontCallbackUrl = frontCallbackUrl;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEnvInfo() {
        return envInfo;
    }

    public void setEnvInfo(String envInfo) {
        this.envInfo = envInfo;
    }

    public String getMitType() {
        return mitType;
    }

    public void setMitType(String mitType) {
        this.mitType = mitType;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    protected String getApiName() {
        return "applyPaymentToken";
    }
}

package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ApplyDropinSessionResponse;
import java.io.Serializable;
import java.util.List;

/**
 * Apply Drop-in Session
 * 在商户服务端调用该接口，获取用于初始化前置组件的主要参数。
&gt; 注：商户如果有换汇或营销的诉求，可联系PayerMax技术支持。
 *
 * API 路径: /aggregate-pay/api/gateway/applyDropinSession
 * 请求方法: POST
 **/
public class ApplyDropinSessionRequest extends BaseRequest<ApplyDropinSessionResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 非必填，如果需要传值，则只有传了mitType时，totalAmount才支持传0；其他情况需要大于0
     */
    private String totalAmount;

    /**
     * 国家代码，大写字母，参见【交易支持国家/地区与币种】。 如指定了paymentMethodType，则国家代码必须上送且和支付方式对应国家匹配。 收银台可用国家地区选择策略为：上送国家代码地区&gt;用户历史使用国家代码地区&gt;用户IP所在国家代码地区。（可用国家地区：交易币种对应的国家与签约国家取交集）
     */
    private String country;

    /**
     * 用于更精准的支付方式推荐，如设备ID、设备指纹等。
     */
    private String referralCode;

    /**
     * 如：CARD，APPLEPAY，GOOGLEPAY
     */
    private List<String> componentList;

    /**
     * 标价币种，大写字母，参见【交易支持国家/地区与币种】
     */
    private String currency;

    /**
     * 签约代扣产品后，可传mitType
     */
    private String mitType;

    /**
     * 商户内部的用户Id，需要保证每个ID唯一性。支付方式绑定后会根据userId进行支付方式推荐
     */
    private String userId;

    /**
     * token支付标识，true标识支持token支付，false表示不支持token支付，默认false
     */
    private String tokenForFutureUse;

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public List<String> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<String> componentList) {
        this.componentList = componentList;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMitType() {
        return mitType;
    }

    public void setMitType(String mitType) {
        this.mitType = mitType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTokenForFutureUse() {
        return tokenForFutureUse;
    }

    public void setTokenForFutureUse(String tokenForFutureUse) {
        this.tokenForFutureUse = tokenForFutureUse;
    }

    @Override
    protected String getApiName() {
        return "applyDropinSession";
    }
}

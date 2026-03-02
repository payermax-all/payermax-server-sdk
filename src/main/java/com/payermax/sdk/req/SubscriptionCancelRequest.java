package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.SubscriptionCancelResponse;
import java.io.Serializable;

/**
 * 取消订阅计划
 * 商户创建订阅计划后，可以主动取消订阅计划。但如果出现下面情况，则商户不能取消订阅计划：
（1）该订阅计划处于激活中。
（2）该订阅计划的某一期扣款处于支付中。
 *
 * API 路径: /aggregate-pay/api/gateway/subscriptionCancel
 * 请求方法: POST
 **/
public class SubscriptionCancelRequest extends BaseRequest<SubscriptionCancelResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PMMAX订阅计划号。
     */
    private String subscriptionNo;

    public String getSubscriptionNo() {
        return subscriptionNo;
    }

    public void setSubscriptionNo(String subscriptionNo) {
        this.subscriptionNo = subscriptionNo;
    }

    @Override
    protected String getApiName() {
        return "subscriptionCancel";
    }
}

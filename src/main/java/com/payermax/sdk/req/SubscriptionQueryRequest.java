package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.SubscriptionQueryResponse;
import java.io.Serializable;

/**
 * 订阅结果查询
 * 商户创建订阅计划后，可通过此接口查询订阅状态和扣款信息。
 *
 * API 路径: /aggregate-pay/api/gateway/subscriptionQuery
 * 请求方法: POST
 **/
public class SubscriptionQueryRequest extends BaseRequest<SubscriptionQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户创建订阅计划的单号。注：subscriptionNo和requestId至少传一个。
     */
    private String subscriptionRequestId;

    /**
     * PMMAX订阅计划号。注：subscriptionNo和requestId必须传一个
     */
    private String subscriptionNo;

    public String getSubscriptionRequestId() {
        return subscriptionRequestId;
    }

    public void setSubscriptionRequestId(String subscriptionRequestId) {
        this.subscriptionRequestId = subscriptionRequestId;
    }

    public String getSubscriptionNo() {
        return subscriptionNo;
    }

    public void setSubscriptionNo(String subscriptionNo) {
        this.subscriptionNo = subscriptionNo;
    }

    @Override
    protected String getApiName() {
        return "subscriptionQuery";
    }
}

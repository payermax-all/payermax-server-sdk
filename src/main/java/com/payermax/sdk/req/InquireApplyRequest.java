package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.InquireApplyResponse;
import java.io.Serializable;

/**
 * PaymentTokenID申请结果查询
 *
 * API 路径: /aggregate-pay/api/gateway/InquireApplyRequest
 * 请求方法: POST
 **/
public class InquireApplyRequest extends BaseRequest<InquireApplyResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 固定值：tokenAcq
      **/
    private String tokenScope;

    /**
     * 请求单号，唯一标识商户的一笔请求
      **/
    private String requestId;

    /**
     * 商户内部的用户Id，需要保证每个ID唯一性
      **/
    private String userId;

    public String getTokenScope() {
        return tokenScope;
    }

    public void setTokenScope(String tokenScope) {
        this.tokenScope = tokenScope;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    protected String getApiName() {
        return "InquireApplyRequest";
    }
}

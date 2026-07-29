package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.CancelResponse;
import java.io.Serializable;

/**
 * 撤销
 *
 * API 路径: /aggregate-pay/api/gateway/cancel
 * 请求方法: POST
 **/
public class CancelRequest extends BaseRequest<CancelResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户撤销请求的唯一id
     */
    private String requestId;

    /**
     * 商户订单号
     */
    private String outTradeNo;

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

    @Override
    protected String getApiName() {
        return "cancel";
    }
}

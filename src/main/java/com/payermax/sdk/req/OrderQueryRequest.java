package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.OrderQueryResponse;
import java.io.Serializable;

/**
 * 交易查询
 * 对于未同步返回交易结果的请求，商户可以主动发起查询查回交易结果。
 *
 * API 路径: /aggregate-pay/api/gateway/orderQuery
 * 请求方法: POST
 **/
public class OrderQueryRequest extends BaseRequest<OrderQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 原商户订单号	
     */
    private String outTradeNo;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    protected String getApiName() {
        return "orderQuery";
    }
}

package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ExchangeQueryResponse;
import java.io.Serializable;

/**
 * 换汇结果查询
 * 商户可以通过换汇结果查询接口，查询历史的换汇交易结果。
 *
 * API 路径: /aggregate-pay/api/gateway/exchangeQuery
 * 请求方法: POST
 **/
public class ExchangeQueryRequest extends BaseRequest<ExchangeQueryResponse> implements Serializable {

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
        return "exchangeQuery";
    }
}

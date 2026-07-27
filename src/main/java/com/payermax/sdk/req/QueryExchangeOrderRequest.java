package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.QueryExchangeOrderResponse;
import java.io.Serializable;

/**
 * 自由换汇交易结果查询
 * API发起的自由换汇的交易,可以通过该接口查询交易结果


 *
 * API 路径: /aggregate-pay/api/gateway/queryExchangeOrder
 * 请求方法: POST
 **/
public class QueryExchangeOrderRequest extends BaseRequest<QueryExchangeOrderResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户订单号
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
        return "queryExchangeOrder";
    }
}

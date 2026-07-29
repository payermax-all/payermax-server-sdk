package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.PaymentOrderQryResponse;
import java.io.Serializable;

/**
 * 付款查询
 * 此接口为API付款查询接口，该接口返回参数请注意以下事项，否则可能会有资损风险：
1. 当"code": "APPLY_SUCCESS"且返回status，代表查询成功，订单状态请以status为准；...
 *
 * API 路径: /aggregate-pay/api/gateway/paymentOrderQry
 * 请求方法: POST
 **/
public class PaymentOrderQryRequest extends BaseRequest<PaymentOrderQryResponse> implements Serializable {

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
        return "paymentOrderQry";
    }
}

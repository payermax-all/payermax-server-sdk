package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.CaptureResponse;
import java.io.Serializable;

/**
 * 请款
 *
 * API 路径: /aggregate-pay/api/gateway/capture
 * 请求方法: POST
 **/
public class CaptureRequest extends BaseRequest<CaptureResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请款金额
      **/
    private Long amount;

    /**
     * 商户请款请求的唯一id
      **/
    private String requestId;

    /**
     * 商户订单号
      **/
    private String outTradeNo;

    /**
     * 请款币种
      **/
    private String currency;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    protected String getApiName() {
        return "capture";
    }
}

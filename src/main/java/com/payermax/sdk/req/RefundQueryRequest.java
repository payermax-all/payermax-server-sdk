package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.RefundQueryResponse;
import java.io.Serializable;

/**
 * 退款查询
 *
 * API 路径: /aggregate-pay/api/gateway/refundQuery
 * 请求方法: POST
 **/
public class RefundQueryRequest extends BaseRequest<RefundQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 原商户退款单号	
     */
    private String outRefundNo;

    /**
     * PayerMax退款流水号，与原商户退款单号二选一上送	
     */
    private String refundTradeNo;

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundTradeNo() {
        return refundTradeNo;
    }

    public void setRefundTradeNo(String refundTradeNo) {
        this.refundTradeNo = refundTradeNo;
    }

    @Override
    protected String getApiName() {
        return "refundQuery";
    }
}

package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 退款申请 - 响应
 **/
public class RefundResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户退款申请号	
     */
    private String outRefundNo;

    /**
     * 交易订单号	
     */
    private String tradeOrderNo;

    /**
     * PayerMax退款流水号	
     */
    private String refundTradeNo;

    /**
     * 退款状态：REFUND_PENDING，REFUND_FAILED	
     */
    private String status;

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    public String getRefundTradeNo() {
        return refundTradeNo;
    }

    public void setRefundTradeNo(String refundTradeNo) {
        this.refundTradeNo = refundTradeNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

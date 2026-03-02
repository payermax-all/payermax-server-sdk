package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 退款查询 - 响应
 **/
public class RefundQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户退款申请号	
      **/
    private String outRefundNo;

    /**
     * 原商户订单号	
      **/
    private String outTradeNo;

    /**
     * 退款币种（原交易币种）	
      **/
    private String refundCurrency;

    /**
     * PayerMax退款流水号	
      **/
    private String refundTradeNo;

    /**
     * 退款完成时间
      **/
    private String refundFinishTime;

    /**
     * 退款金额，金额的单位为元。	
      **/
    private Long refundAmount;

    /**
     * 退款单状态，详见退款状态	
      **/
    private String status;

    /**
     * 交易状态结果描述，仅失败时有值	
      **/
    private String resultMsg;

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }

    public String getRefundTradeNo() {
        return refundTradeNo;
    }

    public void setRefundTradeNo(String refundTradeNo) {
        this.refundTradeNo = refundTradeNo;
    }

    public String getRefundFinishTime() {
        return refundFinishTime;
    }

    public void setRefundFinishTime(String refundFinishTime) {
        this.refundFinishTime = refundFinishTime;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

}

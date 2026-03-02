package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 请款 - 响应
 **/
public class CaptureResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请款金额
      **/
    private String amount;

    /**
     * 成功时间
      **/
    private String succeededTime;

    /**
     * 失败时间
      **/
    private String failedTime;

    /**
     * 商户请求id
      **/
    private String requestId;

    /**
     * 商户外部订单号
      **/
    private String outTradeNo;

    /**
     * 创建时间
      **/
    private String createdTime;

    /**
     * 失败的错误码
      **/
    private String errorCode;

    /**
     * 请款币种
      **/
    private String currency;

    /**
     * 是否最终请款
      **/
    private String isFinal;

    /**
     * Payermax生成的请款流水单号
      **/
    private String captureNo;

    /**
     * 请款状态。SUCCESS、FAILED 、PENDING
      **/
    private String status;

    /**
     * 失败的错误msg
      **/
    private String errorMsg;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSucceededTime() {
        return succeededTime;
    }

    public void setSucceededTime(String succeededTime) {
        this.succeededTime = succeededTime;
    }

    public String getFailedTime() {
        return failedTime;
    }

    public void setFailedTime(String failedTime) {
        this.failedTime = failedTime;
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(String isFinal) {
        this.isFinal = isFinal;
    }

    public String getCaptureNo() {
        return captureNo;
    }

    public void setCaptureNo(String captureNo) {
        this.captureNo = captureNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}

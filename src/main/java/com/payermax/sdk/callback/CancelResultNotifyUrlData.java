package com.payermax.sdk.callback;

import java.io.Serializable;

/**
 * 撤销通知 - Data 数据
 **/
public class CancelResultNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功时间
      **/
    private String succeededTime;

    /**
     * Payermax生成的撤销流水单号
      **/
    private String cancelNo;

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
     * 撤销状态。SUCCESS、FAILED 、PENDING
      **/
    private String status;

    /**
     * 失败的错误msg
      **/
    private String errorMsg;

    public String getSucceededTime() {
        return succeededTime;
    }

    public void setSucceededTime(String succeededTime) {
        this.succeededTime = succeededTime;
    }

    public String getCancelNo() {
        return cancelNo;
    }

    public void setCancelNo(String cancelNo) {
        this.cancelNo = cancelNo;
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

package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 账单支付校验接口 - 响应
 **/
public class BillPaymentValidationUrlResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 最小支付金额。
      **/
    private Long minAmount;

    /**
     * 商户的还款合同号，其中前五位由PayerMax生成。
      **/
    private String referenceNo;

    /**
     * 校验失败的原因。注意：confirmation为N时，该值必填。
      **/
    private String failureReason;

    /**
     * 订单币种
      **/
    private String currency;

    /**
     * 校验结果，"Y"或"N"。
      **/
    private String confirmation;

    /**
     * 最大支付金额。
      **/
    private Long maxAmount;

    public Long getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

}

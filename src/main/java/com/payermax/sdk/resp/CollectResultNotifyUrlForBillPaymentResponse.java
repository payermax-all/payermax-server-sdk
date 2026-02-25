package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 支付成功通知商户 - 响应
 **/
public class CollectResultNotifyUrlForBillPaymentResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单金额
     */
    private Long amount;

    /**
     * 商户的还款合同号，其中前五位由PayerMax生成。
     */
    private String referenceNo;

    /**
     * 商户入账确认失败的原因。注意：confirmation为N时，该值必填。
     */
    private String failureReason;

    /**
     * PayerMax订单号。
     */
    private String tradeToken;

    /**
     * 订单币种
     */
    private String currency;

    /**
     * 商户入账确认的结果。"Y"或"N"。注：为N时PayerMax不会对该笔做结算。
     */
    private String confirmation;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
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

}

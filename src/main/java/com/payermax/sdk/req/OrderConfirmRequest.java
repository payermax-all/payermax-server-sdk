package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.OrderConfirmResponse;
import java.io.Serializable;

/**
 * 商户入账结果确认
 * 商户收到支付通知且进行内部入账处理后，返回给PayerMax最终的入账结果；如果是返回入账成功，则PayerMax将该笔计入清分账户并进行结算。
 *
 * API 路径: /aggregate-pay/api/gateway/orderConfirm
 * 请求方法: POST
 **/
public class OrderConfirmRequest extends BaseRequest<OrderConfirmResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单金额。
     */
    private Long amount;

    /**
     * 商户的还款合同号，其中前五位由PayerMax生成。
     */
    private String referenceNo;

    /**
     * 商户入账确认失败原因。注：confirmation为"N"时，该字段为必填。
     */
    private String failureReason;

    /**
     * PayerMax订单号。
     */
    private String tradeToken;

    /**
     * 订单币种。
     */
    private String currency;

    /**
     * 商户入账确认结果，"Y"或"N"
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

    @Override
    protected String getApiName() {
        return "orderConfirm";
    }
}

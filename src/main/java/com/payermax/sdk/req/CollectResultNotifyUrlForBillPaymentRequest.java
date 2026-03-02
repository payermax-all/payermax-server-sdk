package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.CollectResultNotifyUrlForBillPaymentResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 支付成功通知商户
 * 对客扣款成功后，PayerMax会自动入账并将调用该接口通知商户入账结果，商户可仅响应code和msg，无需响应data。 
&gt; 注：如商户希望PayerMax先不处理入账，可联系PayerMax进行...
 *
 * API 路径: /collectResultNotifyUrlForBillPayment
 * 请求方法: POST
 **/
public class CollectResultNotifyUrlForBillPaymentRequest extends BaseRequest<CollectResultNotifyUrlForBillPaymentResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单金额。
     */
    private Long totalAmount;

    /**
     * 商户的还款合同号，其中前五位由PayerMax生成。
     */
    private String referenceNo;

    /**
     * 订单号。注：该单号由PayerMax生成。
     */
    private String outTradeNo;

    /**
     * 用户真实付款的时间。
     */
    private String completeTime;

    /**
     * PayerMax订单号。
     */
    private String tradeToken;

    /**
     * 订单币种。
     */
    private String currency;

    /**
     * 支付详情。
     */
    private List<PaymentDetails> paymentDetails;

    /**
     * 支付状态. PAY_SUCCESS
     */
    private String payStatus;

    /**
     * 支付完成时间。
     */
    private String paymentSucceedTime;

    /**
     * 付款人邮箱。
     */
    private String payerEmail;

    /**
     * 付款人手机号。
     */
    private String payerMobileNumber;

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
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

    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPaymentSucceedTime() {
        return paymentSucceedTime;
    }

    public void setPaymentSucceedTime(String paymentSucceedTime) {
        this.paymentSucceedTime = paymentSucceedTime;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getPayerMobileNumber() {
        return payerMobileNumber;
    }

    public void setPayerMobileNumber(String payerMobileNumber) {
        this.payerMobileNumber = payerMobileNumber;
    }

    @Override
    protected String getApiName() {
        return "collectResultNotifyUrlForBillPayment";
    }
    /**
     * 数组元素
     */
    public static final class PaymentDetails implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 用户选择的目标机构。
         */
        private String targetOrg;

        /**
         * 用户选择的支付方式。
         */
        private String paymentMethodType;

        public String getTargetOrg() {
            return targetOrg;
        }

        public void setTargetOrg(String targetOrg) {
            this.targetOrg = targetOrg;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public void setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
        }

    }
}

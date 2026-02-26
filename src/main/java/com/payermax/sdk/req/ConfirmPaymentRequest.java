package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ConfirmPaymentResponse;
import java.io.Serializable;

/**
 * 支付确认
 * 支付确认接口
 *
 * API 路径: /aggregate-pay/api/gateway/confirmPayment
 * 请求方法: POST
 **/
public class ConfirmPaymentRequest extends BaseRequest<ConfirmPaymentResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 退款回调地址，可后台配置配置地址
     */
    private PaymentDetail paymentDetail;

    /**
     * 原商户订单号	
     */
    private String outTradeNo;

    /**
     * 正向交易单的交易Token
     */
    private String tradeToken;

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

    @Override
    protected String getApiName() {
        return "confirmPayment";
    }
    /**
     * 嵌套对象
     */
    public static final class PaymentDetail implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 
         */
        private String verificationCode;

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }

    }

}

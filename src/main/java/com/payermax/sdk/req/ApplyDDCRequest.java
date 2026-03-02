package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ApplyDDCResponse;
import java.io.Serializable;

/**
 * 纯API支付DDC申请
 * API模式接入的商户追求极致的用户体验，减少支付流程耗时，降低用户3DS认证放弃率。
在卡号收集阶段，静默调用此接口完成设备信息采集。
 *
 * API 路径: /aggregate-pay/api/gateway/applyDDC
 * 请求方法: POST
 **/
public class ApplyDDCRequest extends BaseRequest<ApplyDDCResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 卡号，明文卡号或GOOGLEPAY解密出来的卡号。和paymentTokenID二选一
     */
    private String cardIdentifierNo;

    /**
     * PMMax token ID，授权成功后支付。和cardIdentifierNo二选一
     */
    private String paymentTokenID;

    /**
     * 交易币种，大写字母。换汇场景使用换汇后的币种
     */
    private String paymentCurrency;

    /**
     * 支付方式类型，枚举值：CARD、GOOGLEPAY
     */
    private String paymentMethodType;

    /**
     * 交易金额，金额的单位为元。换汇场景使用换汇后的金额
     */
    private Long paymentAmount;

    /**
     * 商户内部的用户Id，&lt;span style="color:red"&gt;需要保证每个ID唯一性&lt;/span&gt;。
     */
    private String userId;

    public String getCardIdentifierNo() {
        return cardIdentifierNo;
    }

    public void setCardIdentifierNo(String cardIdentifierNo) {
        this.cardIdentifierNo = cardIdentifierNo;
    }

    public String getPaymentTokenID() {
        return paymentTokenID;
    }

    public void setPaymentTokenID(String paymentTokenID) {
        this.paymentTokenID = paymentTokenID;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    protected String getApiName() {
        return "applyDDC";
    }
}

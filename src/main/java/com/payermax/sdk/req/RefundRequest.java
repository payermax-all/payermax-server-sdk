package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.RefundResponse;
import java.io.Serializable;

/**
 * 退款申请
 * 仅适用于支持退款的支付方式，同时仅支持180天内的交易发起退款。
退款到账时效取决于银行和机构的处理时效。
 *
 * API 路径: /aggregate-pay/api/gateway/refund
 * 请求方法: POST
 **/
public class RefundRequest extends BaseRequest<RefundResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户退款申请号，唯一标识一笔退款申请交易
     */
    private String outRefundNo;

    /**
     * 退款说明（商户退款理由）	
     */
    private String comments;

    /**
     * 原商户订单号，可以传outTradeNo，也可以传tradeToken，不能outTradeNo和tradeToken同时不传
     */
    private String outTradeNo;

    /**
     * 退款币种（原交易币种）	
     */
    private String refundCurrency;

    /**
     * 正向交易单的交易Token，可以传outTradeNo，也可以传tradeToken，不能outTradeNo和tradeToken同时不传
     */
    private String tradeToken;

    /**
     * 退款金额，金额的单位为元。 除以下国家外按照各国币种支持的小数点位（最大四位）上送。 注意：巴林、科威特、伊拉克，约旦、突尼斯、利比亚、奥马尔地区，本币只支持两位小数； 印尼、中国台湾、巴基斯坦、哥伦比亚地区，本币不支持带小数金额。
     */
    private Long refundAmount;

    /**
     * 退款回调地址，可后台配置【[配置地址](https://docs-v2.payermax.com/doc-center/developer/config-settings.html)】
     */
    private String refundNotifyUrl;

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl;
    }

    @Override
    protected String getApiName() {
        return "refund";
    }
}

package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ApplyWithdrawResponse;
import java.io.Serializable;

/**
 * 账户提现发起
 * 发起提现交易
 *
 * API 路径: /aggregate-pay/api/gateway/applyWithdraw
 * 请求方法: POST
 **/
public class ApplyWithdrawRequest extends BaseRequest<ApplyWithdrawResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易币种
     */
    private String transactionCurrency;

    /**
     * 订单到达终态时的回调地址
     */
    private String callBackUrl;

    /**
     * 到账币种
     */
    private String targetCurrency;

    /**
     * 商户订单号,要保证商户下唯一
     */
    private String outTradeNo;

    /**
     * 收款银行账号，测试环境固定传送:456789213
产线根据商户实际银行账户传送
     */
    private String payeeBankAccountNo;

    /**
     * 交易金额
     */
    private String transactionAmount;

    /**
     * 附言
     */
    private String remark;

    /**
     * 付款资金账户,可通过资金账户信息查询接口获取
     */
    private String payerFundsAccountNo;

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getPayeeBankAccountNo() {
        return payeeBankAccountNo;
    }

    public void setPayeeBankAccountNo(String payeeBankAccountNo) {
        this.payeeBankAccountNo = payeeBankAccountNo;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayerFundsAccountNo() {
        return payerFundsAccountNo;
    }

    public void setPayerFundsAccountNo(String payerFundsAccountNo) {
        this.payerFundsAccountNo = payerFundsAccountNo;
    }

    @Override
    protected String getApiName() {
        return "applyWithdraw";
    }
}

package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ApplyExchangeResponse;
import java.io.Serializable;

/**
 * 自由换汇交易发起
 * 发起自由换汇交易
 *
 * API 路径: /aggregate-pay/api/gateway/applyExchange
 * 请求方法: POST
 **/
public class ApplyExchangeRequest extends BaseRequest<ApplyExchangeResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private AccountInfo accountInfo;

    /**
     * 汇率版本,可通过自由换汇汇率查询接口获取
     */
    private String rateReferenceId;

    /**
     * 针对交易币种的买卖方向
     */
    private String side;

    /**
     * 交易币种
     */
    private String transactionCurrency;

    /**
     * 订单到达终态时的回调地址
     */
    private String callBackUrl;

    /**
     * 目标币种
     */
    private String targetCurrency;

    /**
     * 要保证商户下唯一
     */
    private String outTradeNo;

    /**
     * 交易金额
     */
    private String transactionAmount;

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getRateReferenceId() {
        return rateReferenceId;
    }

    public void setRateReferenceId(String rateReferenceId) {
        this.rateReferenceId = rateReferenceId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

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

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    protected String getApiName() {
        return "applyExchange";
    }
    /**
     * 嵌套对象
     */
    public static final class AccountInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 卖出资金账号,交易成功后该账户流出资金
         */
        private String sellFundsAccountNo;

        /**
         * 买入资金账号,交易成功后该账户流入资金
         */
        private String buyFundsAccountNo;

        public String getSellFundsAccountNo() {
            return sellFundsAccountNo;
        }

        public void setSellFundsAccountNo(String sellFundsAccountNo) {
            this.sellFundsAccountNo = sellFundsAccountNo;
        }

        public String getBuyFundsAccountNo() {
            return buyFundsAccountNo;
        }

        public void setBuyFundsAccountNo(String buyFundsAccountNo) {
            this.buyFundsAccountNo = buyFundsAccountNo;
        }

    }
}

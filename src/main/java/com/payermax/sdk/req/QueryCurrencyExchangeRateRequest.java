package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.QueryCurrencyExchangeRateResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 自由换汇汇率查询
 * 支持查询资金账户换汇场景汇率
 *
 * API 路径: /aggregate-pay/api/gateway/queryCurrencyExchangeRate
 * 请求方法: POST
 **/
public class QueryCurrencyExchangeRateRequest extends BaseRequest<QueryCurrencyExchangeRateResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 币种对列表
     */
    private List<CcyPairList> ccyPairList;

    public List<CcyPairList> getCcyPairList() {
        return ccyPairList;
    }

    public void setCcyPairList(List<CcyPairList> ccyPairList) {
        this.ccyPairList = ccyPairList;
    }

    @Override
    protected String getApiName() {
        return "queryCurrencyExchangeRate";
    }
    /**
     * 数组元素
     */
    public static final class CcyPairList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 对于交易币种的买卖方向
         */
        private String side;

        /**
         * 外汇交易币种
         */
        private String transactionCurrency;

        /**
         * 外汇目标币种
         */
        private String targetCurrency;

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

        public String getTargetCurrency() {
            return targetCurrency;
        }

        public void setTargetCurrency(String targetCurrency) {
            this.targetCurrency = targetCurrency;
        }

    }
}

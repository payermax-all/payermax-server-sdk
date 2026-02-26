package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 收单/付款汇率查询 - 响应
 **/
public class QueryClientExchangeRateResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private List<CurrencyList> currencyList;

    public List<CurrencyList> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<CurrencyList> currencyList) {
        this.currencyList = currencyList;
    }

    /**
     * 数组元素
     */
    public static final class CurrencyList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 
         */
        private String rateReferenceId;

        /**
         * 1、非锁汇产品,只支持reference(汇率仅参考)
2、PAYIN锁汇产品,可支持Tradable和Reference;如果有交易需求,可联系PM商务经理沟通
         */
        private String rateType;

        /**
         * 站在客户视角,对于交易币种的买卖方向
         */
        private String side;

        /**
         * 
         */
        private String transactionCurrency;

        /**
         * 外汇交易币种/外汇目标币种
         */
        private String ccyPair;

        /**
         * 
         */
        private String targetCurrency;

        /**
         * 代表一个单位的交易币种等于多少目标币种
         */
        private Long rate;

        /**
         * 代表汇率已过期，理论上不应该使用
只有汇率Tradable场景,才会返回该字段
格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX
         */
        private String expiryTime;

        /**
         * 超过这个时间系统会进行拦截，该汇率不再可交易
只有汇率Tradable场景,才会返回该字段
格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX
         */
        private String validTime;

        /**
         * 代表最早可以使用这个汇率的时间
只有汇率Tradable场景,才会返回该字段
格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX
         */
        private String effectTime;

        public String getRateReferenceId() {
            return rateReferenceId;
        }

        public void setRateReferenceId(String rateReferenceId) {
            this.rateReferenceId = rateReferenceId;
        }

        public String getRateType() {
            return rateType;
        }

        public void setRateType(String rateType) {
            this.rateType = rateType;
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

        public String getCcyPair() {
            return ccyPair;
        }

        public void setCcyPair(String ccyPair) {
            this.ccyPair = ccyPair;
        }

        public String getTargetCurrency() {
            return targetCurrency;
        }

        public void setTargetCurrency(String targetCurrency) {
            this.targetCurrency = targetCurrency;
        }

        public Long getRate() {
            return rate;
        }

        public void setRate(Long rate) {
            this.rate = rate;
        }

        public String getExpiryTime() {
            return expiryTime;
        }

        public void setExpiryTime(String expiryTime) {
            this.expiryTime = expiryTime;
        }

        public String getValidTime() {
            return validTime;
        }

        public void setValidTime(String validTime) {
            this.validTime = validTime;
        }

        public String getEffectTime() {
            return effectTime;
        }

        public void setEffectTime(String effectTime) {
            this.effectTime = effectTime;
        }

    }
}

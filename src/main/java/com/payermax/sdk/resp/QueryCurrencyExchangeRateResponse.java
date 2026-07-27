package com.payermax.sdk.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 自由换汇汇率查询 - 响应
 **/
public class QueryCurrencyExchangeRateResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 汇率列表
     */
    private List<RateList> rateList;

    public List<RateList> getRateList() {
        return rateList;
    }

    public void setRateList(List<RateList> rateList) {
        this.rateList = rateList;
    }

    /**
     * 数组元素
     */
    public static final class RateList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 汇率唯一ID
         */
        private String rateReferenceId;

        /**
         * 汇率类型，Tradable可交易/Reference仅供参考
         */
        private String rateType;

        /**
         * 对于交易币种的买卖方向，BUY/SELL
         */
        private String side;

        /**
         * 外汇交易币种
         */
        private String transactionCurrency;

        /**
         * 币种对
         */
        private String ccyPair;

        /**
         * 外汇目标币种
         */
        private String targetCurrency;

        /**
         * 汇率，代表一个单位的外汇交易币种=?目标币种汇率
         */
        private BigDecimal rate;

        /**
         * 汇率失效时间，可能为空，格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
         */
        private String expiryTime;

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

        public BigDecimal getRate() {
            return rate;
        }

        public void setRate(BigDecimal rate) {
            this.rate = rate;
        }

        public String getExpiryTime() {
            return expiryTime;
        }

        public void setExpiryTime(String expiryTime) {
            this.expiryTime = expiryTime;
        }

    }
}

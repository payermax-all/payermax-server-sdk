package com.payermax.sdk.callback;

import java.io.Serializable;

/**
 * 动账通知 - Data 数据
 **/
public class BalanceNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 动账
      **/
    private Amount amount;

    /**
     * 手续费
      **/
    private Fee fee;

    /**
     * 交易对手方
      **/
    private Counterparty counterparty;

    /**
     * 汇率信息
      **/
    private Exchange exchange;

    /**
     * 动账方向：INCREASE/DECREASE
      **/
    private String direction;

    /**
     * 关联PayerMax交易流水号
      **/
    private String relatedTradeNo;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRelatedTradeNo() {
        return relatedTradeNo;
    }

    public void setRelatedTradeNo(String relatedTradeNo) {
        this.relatedTradeNo = relatedTradeNo;
    }

    /**
     * 嵌套对象
      **/
    public static final class Amount implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 动账币种
          **/
        private String currency;

        /**
         * 动账金额
          **/
        private String value;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class Fee implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 手续费币种
          **/
        private String currency;

        /**
         * 手续费金额
          **/
        private String value;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class Counterparty implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 交易对手名称
          **/
        private String identifyName;

        /**
         * 交易对手标识，充提为银行账号，转汇为商户号
          **/
        private String identifyId;

        public String getIdentifyName() {
            return identifyName;
        }

        public void setIdentifyName(String identifyName) {
            this.identifyName = identifyName;
        }

        public String getIdentifyId() {
            return identifyId;
        }

        public void setIdentifyId(String identifyId) {
            this.identifyId = identifyId;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class Exchange implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 货币对
          **/
        private String ccyPair;

        /**
         * 汇率
          **/
        private String rate;

        /**
         * 汇率基准时间
          **/
        private String rateTime;

        public String getCcyPair() {
            return ccyPair;
        }

        public void setCcyPair(String ccyPair) {
            this.ccyPair = ccyPair;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getRateTime() {
            return rateTime;
        }

        public void setRateTime(String rateTime) {
            this.rateTime = rateTime;
        }

    }
}

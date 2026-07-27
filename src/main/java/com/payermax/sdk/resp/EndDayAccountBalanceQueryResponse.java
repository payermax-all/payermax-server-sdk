package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 账户期末余额 - 响应
 **/
public class EndDayAccountBalanceQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账务日期,格式:yyyy-MM-dd
     */
    private String acctTime;

    /**
     * 时区
     */
    private String timeZone;

    /**
     * 
     */
    private List<EndDayAccountBalanceInfoList> endDayAccountBalanceInfoList;

    public String getAcctTime() {
        return acctTime;
    }

    public void setAcctTime(String acctTime) {
        this.acctTime = acctTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public List<EndDayAccountBalanceInfoList> getEndDayAccountBalanceInfoList() {
        return endDayAccountBalanceInfoList;
    }

    public void setEndDayAccountBalanceInfoList(List<EndDayAccountBalanceInfoList> endDayAccountBalanceInfoList) {
        this.endDayAccountBalanceInfoList = endDayAccountBalanceInfoList;
    }

    /**
     * 数组元素
     */
    public static final class EndDayAccountBalanceInfoList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 流入金额
         */
        private Integer inflowAmount;

        /**
         * 资金账号
         */
        private String fundsAccountNo;

        /**
         * 日终余额
         */
        private Integer endBalance;

        /**
         * 日初余额
         */
        private Integer initialBalance;

        /**
         * 币种
         */
        private String currency;

        /**
         * 流出金额
         */
        private Integer outflowAmount;

        public Integer getInflowAmount() {
            return inflowAmount;
        }

        public void setInflowAmount(Integer inflowAmount) {
            this.inflowAmount = inflowAmount;
        }

        public String getFundsAccountNo() {
            return fundsAccountNo;
        }

        public void setFundsAccountNo(String fundsAccountNo) {
            this.fundsAccountNo = fundsAccountNo;
        }

        public Integer getEndBalance() {
            return endBalance;
        }

        public void setEndBalance(Integer endBalance) {
            this.endBalance = endBalance;
        }

        public Integer getInitialBalance() {
            return initialBalance;
        }

        public void setInitialBalance(Integer initialBalance) {
            this.initialBalance = initialBalance;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Integer getOutflowAmount() {
            return outflowAmount;
        }

        public void setOutflowAmount(Integer outflowAmount) {
            this.outflowAmount = outflowAmount;
        }

    }
}

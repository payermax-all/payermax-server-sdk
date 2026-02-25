package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 日终余额查询  - 响应
 **/
public class DayEndBalanceQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
     */
    private String acctTime;

    /**
     * 目前只支持(UTC 、CST）
     */
    private String timezone;

    /**
     * 
     */
    private String errorCode;

    /**
     * 查询到的账户类型
     */
    private List<AccountEndDayTimeTypes> accountEndDayTimeTypes;

    /**
     * 
     */
    private String errorMsg;

    public String getAcctTime() {
        return acctTime;
    }

    public void setAcctTime(String acctTime) {
        this.acctTime = acctTime;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<AccountEndDayTimeTypes> getAccountEndDayTimeTypes() {
        return accountEndDayTimeTypes;
    }

    public void setAccountEndDayTimeTypes(List<AccountEndDayTimeTypes> accountEndDayTimeTypes) {
        this.accountEndDayTimeTypes = accountEndDayTimeTypes;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 数组元素
     */
    public static final class AccountEndDayTimeTypes implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 当日内流入金额
         */
        private Long inflowAmount;

        /**
         * 
         */
        private Long initalBalance;

        /**
         * 计算公式
endBalance = initalBalance+ inflowAmount - outflowAmount
         */
        private Long endBalance;

        /**
         * 
         */
        private String accountType;

        /**
         * 符合ISO 4217规范. 当未指定币种时，返回全部余额大于0的币种
         */
        private String currency;

        /**
         * 当日内流出金额
         */
        private Long outflowAmount;

        public Long getInflowAmount() {
            return inflowAmount;
        }

        public void setInflowAmount(Long inflowAmount) {
            this.inflowAmount = inflowAmount;
        }

        public Long getInitalBalance() {
            return initalBalance;
        }

        public void setInitalBalance(Long initalBalance) {
            this.initalBalance = initalBalance;
        }

        public Long getEndBalance() {
            return endBalance;
        }

        public void setEndBalance(Long endBalance) {
            this.endBalance = endBalance;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Long getOutflowAmount() {
            return outflowAmount;
        }

        public void setOutflowAmount(Long outflowAmount) {
            this.outflowAmount = outflowAmount;
        }

    }

}

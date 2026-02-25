package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 实时余额查询 - 响应
 **/
public class CurrentBalanceQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private List<AccountRealTimeTypes> accountRealTimeTypes;

    /**
     * 符合rfc3339规范，格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX
     */
    private String inquiryTime;

    /**
     * 查询失败错误码
     */
    private String errorCode;

    /**
     * 查询失败错误码描述
     */
    private String errorMsg;

    public List<AccountRealTimeTypes> getAccountRealTimeTypes() {
        return accountRealTimeTypes;
    }

    public void setAccountRealTimeTypes(List<AccountRealTimeTypes> accountRealTimeTypes) {
        this.accountRealTimeTypes = accountRealTimeTypes;
    }

    public String getInquiryTime() {
        return inquiryTime;
    }

    public void setInquiryTime(String inquiryTime) {
        this.inquiryTime = inquiryTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
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
    public static final class AccountRealTimeTypes implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 单位元
         */
        private Long balance;

        /**
         * 
         */
        private String accountType;

        /**
         * 符合ISO 4217规范.
         */
        private String currency;

        public Long getBalance() {
            return balance;
        }

        public void setBalance(Long balance) {
            this.balance = balance;
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

    }

}

package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 实时余额查询 - 响应
 **/
public class RealTimeAccountBalanceQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private List<AccountBalanceInfoList> accountBalanceInfoList;

    /**
     * 查询时间
     */
    private String inquiryTime;

    public List<AccountBalanceInfoList> getAccountBalanceInfoList() {
        return accountBalanceInfoList;
    }

    public void setAccountBalanceInfoList(List<AccountBalanceInfoList> accountBalanceInfoList) {
        this.accountBalanceInfoList = accountBalanceInfoList;
    }

    public String getInquiryTime() {
        return inquiryTime;
    }

    public void setInquiryTime(String inquiryTime) {
        this.inquiryTime = inquiryTime;
    }

    /**
     * 数组元素
     */
    public static final class AccountBalanceInfoList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 当前实时余额
         */
        private String balance;

        /**
         * 资金账号
         */
        private String fundsAccountNo;

        /**
         * 币种
         */
        private String fundsAccountCurrency;

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getFundsAccountNo() {
            return fundsAccountNo;
        }

        public void setFundsAccountNo(String fundsAccountNo) {
            this.fundsAccountNo = fundsAccountNo;
        }

        public String getFundsAccountCurrency() {
            return fundsAccountCurrency;
        }

        public void setFundsAccountCurrency(String fundsAccountCurrency) {
            this.fundsAccountCurrency = fundsAccountCurrency;
        }

    }
}

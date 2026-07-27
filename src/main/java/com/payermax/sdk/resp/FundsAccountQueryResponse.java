package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 资金账户信息查询 - 响应
 **/
public class FundsAccountQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private List<FundsAccountInfoList> fundsAccountInfoList;

    public List<FundsAccountInfoList> getFundsAccountInfoList() {
        return fundsAccountInfoList;
    }

    public void setFundsAccountInfoList(List<FundsAccountInfoList> fundsAccountInfoList) {
        this.fundsAccountInfoList = fundsAccountInfoList;
    }

    /**
     * 数组元素
     */
    public static final class FundsAccountInfoList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 资金账号别名
         */
        private String accountAlias;

        /**
         * 资金账号状态 1可用/0不可用
         */
        private String accountStatus;

        /**
         * 开户时间
         */
        private String accountOpenTime;

        /**
         * 资金账号名称(=客户英文注册名称)
         */
        private String accountName;

        /**
         * 资金账号
         */
        private String accountNo;

        /**
         * 资金账号下已经开通的币种列表
         */
        private List<String> currencyList;

        public String getAccountAlias() {
            return accountAlias;
        }

        public void setAccountAlias(String accountAlias) {
            this.accountAlias = accountAlias;
        }

        public String getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(String accountStatus) {
            this.accountStatus = accountStatus;
        }

        public String getAccountOpenTime() {
            return accountOpenTime;
        }

        public void setAccountOpenTime(String accountOpenTime) {
            this.accountOpenTime = accountOpenTime;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public List<String> getCurrencyList() {
            return currencyList;
        }

        public void setCurrencyList(List<String> currencyList) {
            this.currencyList = currencyList;
        }

    }
}

package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 账户授权关系查询 - 响应
 **/
public class QueryAuthorizedAccountResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private List<MerchantAuthorizedAccountInfoList> merchantAuthorizedAccountInfoList;

    public List<MerchantAuthorizedAccountInfoList> getMerchantAuthorizedAccountInfoList() {
        return merchantAuthorizedAccountInfoList;
    }

    public void setMerchantAuthorizedAccountInfoList(List<MerchantAuthorizedAccountInfoList> merchantAuthorizedAccountInfoList) {
        this.merchantAuthorizedAccountInfoList = merchantAuthorizedAccountInfoList;
    }

    /**
     * 数组元素
     */
    public static final class MerchantAuthorizedAccountInfoList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 授权的资金账号别名,客户可通过mmc自行修改别名
         */
        private String authorizedFundsAccountAlias;

        /**
         * 授权的资金账号
         */
        private String authorizedFundsAccountNo;

        /**
         * 产品大类
         */
        private String productType;

        /**
         * 商户号
         */
        private String merchantNo;

        /**
         * 会员号
         */
        private String memberId;

        public String getAuthorizedFundsAccountAlias() {
            return authorizedFundsAccountAlias;
        }

        public void setAuthorizedFundsAccountAlias(String authorizedFundsAccountAlias) {
            this.authorizedFundsAccountAlias = authorizedFundsAccountAlias;
        }

        public String getAuthorizedFundsAccountNo() {
            return authorizedFundsAccountNo;
        }

        public void setAuthorizedFundsAccountNo(String authorizedFundsAccountNo) {
            this.authorizedFundsAccountNo = authorizedFundsAccountNo;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getMerchantNo() {
            return merchantNo;
        }

        public void setMerchantNo(String merchantNo) {
            this.merchantNo = merchantNo;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

    }
}

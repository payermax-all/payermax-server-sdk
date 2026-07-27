package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.RealTimeAccountBalanceQueryResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 实时余额查询
 * 查询资金账户的实时余额
 *
 * API 路径: /aggregate-pay/api/gateway/realTimeAccountBalanceQuery
 * 请求方法: POST
 **/
public class RealTimeAccountBalanceQueryRequest extends BaseRequest<RealTimeAccountBalanceQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否返回余额为0的账户 true返回 false不返回 默认值: "false"
     */
    private Boolean plainSign;

    /**
     * 
     */
    private RealTimeAccountBalanceQueryReq realTimeAccountBalanceQueryReq;

    public Boolean getPlainSign() {
        return plainSign;
    }

    public void setPlainSign(Boolean plainSign) {
        this.plainSign = plainSign;
    }

    public RealTimeAccountBalanceQueryReq getRealTimeAccountBalanceQueryReq() {
        return realTimeAccountBalanceQueryReq;
    }

    public void setRealTimeAccountBalanceQueryReq(RealTimeAccountBalanceQueryReq realTimeAccountBalanceQueryReq) {
        this.realTimeAccountBalanceQueryReq = realTimeAccountBalanceQueryReq;
    }

    @Override
    protected String getApiName() {
        return "realTimeAccountBalanceQuery";
    }
    /**
     * 嵌套对象
     */
    public static final class RealTimeAccountBalanceQueryReq implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 资金账号列表
         */
        private List<String> fundsAccountNoList;

        /**
         * 币种列表
         */
        private List<String> fundsAccountCurrencyList;

        public List<String> getFundsAccountNoList() {
            return fundsAccountNoList;
        }

        public void setFundsAccountNoList(List<String> fundsAccountNoList) {
            this.fundsAccountNoList = fundsAccountNoList;
        }

        public List<String> getFundsAccountCurrencyList() {
            return fundsAccountCurrencyList;
        }

        public void setFundsAccountCurrencyList(List<String> fundsAccountCurrencyList) {
            this.fundsAccountCurrencyList = fundsAccountCurrencyList;
        }

    }
}

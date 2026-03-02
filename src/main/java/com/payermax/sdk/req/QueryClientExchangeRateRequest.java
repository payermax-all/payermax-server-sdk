package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.QueryClientExchangeRateResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 收单/付款汇率查询
 * **接口能力描述**:
本接口支持根据收单或付款业务查询相应的汇率信息，为您的外汇交易决策提供参考。请注意，查询到的汇率仅供参考，不构成交易承诺。
注：调用此接口前，请确保您已开通相关的业务产品服务。...
 *
 * API 路径: /aggregate-pay/api/gateway/queryClientExchangeRate
 * 请求方法: POST
 **/
public class QueryClientExchangeRateRequest extends BaseRequest<QueryClientExchangeRateResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PAY_IN收单 / PAY_OUT付款
      **/
    private String product;

    /**
     * 最大支持80个货币对
      **/
    private List<CcyPairList> ccyPairList;

    /**
     * 格式: yyyyMMdd
此字段仅适用于收单锁汇场景
- 未开通锁汇情况下该字段无效(默认返回当前汇率)
- 收单锁汇场景
  - 如该字段为空则默认返回当期锁汇汇率
  - 可提前 15min 查询下一期锁汇汇率(此时传送次日日期)
  - 不支持查询历史过期汇率
      **/
    private String validTime;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<CcyPairList> getCcyPairList() {
        return ccyPairList;
    }

    public void setCcyPairList(List<CcyPairList> ccyPairList) {
        this.ccyPairList = ccyPairList;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    @Override
    protected String getApiName() {
        return "queryClientExchangeRate";
    }
    /**
     * 数组元素
      **/
    public static final class CcyPairList implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 站在客户的视角,对于交易币种的买卖方向
BUY / SELL
          **/
        private String side;

        /**
         * 
          **/
        private String transactionCurrency;

        /**
         * 
          **/
        private String targetCurrency;

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

        public String getTargetCurrency() {
            return targetCurrency;
        }

        public void setTargetCurrency(String targetCurrency) {
            this.targetCurrency = targetCurrency;
        }

    }
}

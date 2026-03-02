package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.CurrentBalanceQueryResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 实时余额查询
 * 基于商户的请求时间、账户类型、币种查询实时的客户账余额
 *
 * API 路径: /aggregate-pay/api/gateway/currentBalanceQuery
 * 请求方法: POST
 **/
public class CurrentBalanceQueryRequest extends BaseRequest<CurrentBalanceQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  ACQUIRING 收单账户 -DISBURSEMENT 代发账户 FREEZE   冻结账户 SETTLE   待结算账户 REVERSE  保证金账户 当未指定账户类型时，返回全部不为0的账户
      **/
    private List<String> accountType;

    /**
     * 是否返回余额为0的账户 true返回 false不返回  默认值: "false"
      **/
    private Boolean plainSign;

    /**
     * 符合ISO 4217规范. 当未指定币种时，返回全部不为0的账户
      **/
    private List<String> accountCurrency;

    public List<String> getAccountType() {
        return accountType;
    }

    public void setAccountType(List<String> accountType) {
        this.accountType = accountType;
    }

    public Boolean getPlainSign() {
        return plainSign;
    }

    public void setPlainSign(Boolean plainSign) {
        this.plainSign = plainSign;
    }

    public List<String> getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(List<String> accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    @Override
    protected String getApiName() {
        return "currentBalanceQuery";
    }
}

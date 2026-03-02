package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.DayEndBalanceQueryResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 日终余额查询 
 * 返回指定日期及时区下的余额信息
 *
 * API 路径: /aggregate-pay/api/gateway/dayEndBalanceQuery
 * 请求方法: POST
 **/
public class DayEndBalanceQueryRequest extends BaseRequest<DayEndBalanceQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 目前只支持(UTC 、CST)，不区分大小写
      **/
    private String timezone;

    /**
     *  -ACQUIRING 收单账户 -DISBURSEMENT 代发账户可用余额户 当未指定账户类型时，返回全部
      **/
    private List<String> accountType;

    /**
     * 符合ISO 4217规范. 当未指定币种时，返回全部
      **/
    private String accountCurrency;

    /**
     * 支持查询近90天
      **/
    private String inquiryDate;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<String> getAccountType() {
        return accountType;
    }

    public void setAccountType(List<String> accountType) {
        this.accountType = accountType;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    @Override
    protected String getApiName() {
        return "dayEndBalanceQuery";
    }
}

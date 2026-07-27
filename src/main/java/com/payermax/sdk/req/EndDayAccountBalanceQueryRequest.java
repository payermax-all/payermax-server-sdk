package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.EndDayAccountBalanceQueryResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 账户期末余额
 * 查询资金账户的日终余额(只支持查UTC+0和UTC+8两个时区的期末)
 *
 * API 路径: /aggregate-pay/api/gateway/endDayAccountBalanceQuery
 * 请求方法: POST
 **/
public class EndDayAccountBalanceQueryRequest extends BaseRequest<EndDayAccountBalanceQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 时区,只支持 CST和UTC
CST:GMT+8:00 
UTC:GMT+0:00 
     */
    private String timezone;

    /**
     * 
     */
    private EndDayAccountBalanceQueryReq endDayAccountBalanceQueryReq;

    /**
     * 账务日期,支持查询近90天 
     */
    private String inquiryDate;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public EndDayAccountBalanceQueryReq getEndDayAccountBalanceQueryReq() {
        return endDayAccountBalanceQueryReq;
    }

    public void setEndDayAccountBalanceQueryReq(EndDayAccountBalanceQueryReq endDayAccountBalanceQueryReq) {
        this.endDayAccountBalanceQueryReq = endDayAccountBalanceQueryReq;
    }

    public String getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    @Override
    protected String getApiName() {
        return "endDayAccountBalanceQuery";
    }
    /**
     * 嵌套对象
     */
    public static final class EndDayAccountBalanceQueryReq implements Serializable {
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

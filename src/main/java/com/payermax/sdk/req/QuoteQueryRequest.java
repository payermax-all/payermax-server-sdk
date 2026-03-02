package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.QuoteQueryResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 自由换汇汇率查询
 *
 * API 路径: /aggregate-pay/api/gateway/quoteQuery
 * 请求方法: POST
 **/
public class QuoteQueryRequest extends BaseRequest<QuoteQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 币种对列表长度须大于0且小于25,列表中的币种对为基于美金标价法拼接，需要USD在前，最终效果例如:USDIDR
     */
    private List<String> ccyPairList;

    /**
     * 价格类型列表，买入价BID,卖出价OFFER,默认查询全部
     */
    private String priceTypeList;

    public List<String> getCcyPairList() {
        return ccyPairList;
    }

    public void setCcyPairList(List<String> ccyPairList) {
        this.ccyPairList = ccyPairList;
    }

    public String getPriceTypeList() {
        return priceTypeList;
    }

    public void setPriceTypeList(String priceTypeList) {
        this.priceTypeList = priceTypeList;
    }

    @Override
    protected String getApiName() {
        return "quoteQuery";
    }
}

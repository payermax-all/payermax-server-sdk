package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 自由换汇汇率查询 - 响应
 **/
public class QuoteQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
      **/
    private String rateList;

    public String getRateList() {
        return rateList;
    }

    public void setRateList(String rateList) {
        this.rateList = rateList;
    }

}

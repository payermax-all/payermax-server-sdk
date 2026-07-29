package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 添加或删除风控名单 - 响应
 **/
public class AddOrDelRiskNameListResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求体中的requestId
     */
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}

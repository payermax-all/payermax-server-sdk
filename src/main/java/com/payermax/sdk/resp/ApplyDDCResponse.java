package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 纯API支付DDC申请 - 响应
 **/
public class ApplyDDCResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口orderAndPay时需要携带此字段
     */
    private String ddcSessionId;

    /**
     * 加载ddc的地址，商户客户端在隐藏iframe中加载此url
     */
    private String ddcUrl;

    public String getDdcSessionId() {
        return ddcSessionId;
    }

    public void setDdcSessionId(String ddcSessionId) {
        this.ddcSessionId = ddcSessionId;
    }

    public String getDdcUrl() {
        return ddcUrl;
    }

    public void setDdcUrl(String ddcUrl) {
        this.ddcUrl = ddcUrl;
    }

}

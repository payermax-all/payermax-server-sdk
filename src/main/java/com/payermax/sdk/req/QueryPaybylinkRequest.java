package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.QueryPaybylinkResponse;
import java.io.Serializable;

/**
 * 查询链接详情
 * 接口名称：queryPaybylink

 *
 * API 路径: /aggregate-pay/api/gateway/queryPaybylink
 * 请求方法: POST
 **/
public class QueryPaybylinkRequest extends BaseRequest<QueryPaybylinkResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户链接唯一订单号
     */
    private String merchantLinkId;

    public String getMerchantLinkId() {
        return merchantLinkId;
    }

    public void setMerchantLinkId(String merchantLinkId) {
        this.merchantLinkId = merchantLinkId;
    }

    @Override
    protected String getApiName() {
        return "queryPaybylink";
    }
}

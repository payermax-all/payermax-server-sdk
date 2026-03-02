package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ExpirePaybylinkResponse;
import java.io.Serializable;

/**
 * 失效支付链接
 * 接口名称：expirePaybylink
 *
 * API 路径: /aggregate-pay/api/gateway/expirePaybylink
 * 请求方法: POST
 **/
public class ExpirePaybylinkRequest extends BaseRequest<ExpirePaybylinkResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户链接唯一订单号
      **/
    private String merchantLinkId;

    public String getMerchantLinkId() {
        return merchantLinkId;
    }

    public void setMerchantLinkId(String merchantLinkId) {
        this.merchantLinkId = merchantLinkId;
    }

    @Override
    protected String getApiName() {
        return "expirePaybylink";
    }
}

package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.PageReturnResponse;
import java.io.Serializable;

/**
 * 页面回跳
 * 1、使用PayerMax结果页面
用户在PayerMax支付结果页可以点击返回商户按钮，跳回商户指定页面。
2、不使用Payermax 结果页面（API模式下均为此流程）
用户支付完成后直接跳回商户指...
 *
 * API 路径: /pageReturn
 * 请求方法: POST
 **/
public class PageReturnRequest extends BaseRequest<PageReturnResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    protected String getApiName() {
        return "pageReturn";
    }
}

package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.BillPaymentValidationUrlResponse;
import java.io.Serializable;

/**
 * 账单支付校验接口
 * 此接口仅适用于菲律宾当地的Bill Payment支付方式。

PayerMax调用该接口请求商户获取本次支付操作的可行性（是否能够支付）。
 *
 * API 路径: /billPaymentValidationUrl
 * 请求方法: POST
 **/
public class BillPaymentValidationUrlRequest extends BaseRequest<BillPaymentValidationUrlResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    protected String getApiName() {
        return "billPaymentValidationUrl";
    }
}

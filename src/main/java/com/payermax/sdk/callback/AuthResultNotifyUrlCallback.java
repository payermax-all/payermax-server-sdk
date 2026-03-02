package com.payermax.sdk.callback;


/**
 * 授权结果通知 - 回调数据
 * 支付完成后，PayerMax 会把相关支付结果通过数据流的形式发送给商户，商户需要接收处理，并按文档规范返回应答。
提示：该地址无需商户主动请求，以下request.body为payermax对订单状...
 * 
 * <p>注意：这是回调接口的数据对象，用于接收 PayerMax 的回调通知。</p>
 * 
 * 回调路径: /authResultNotifyUrl
 **/
public class AuthResultNotifyUrlCallback extends BaseCallback<AuthResultNotifyUrlData> {

    private static final long serialVersionUID = 1L;

}

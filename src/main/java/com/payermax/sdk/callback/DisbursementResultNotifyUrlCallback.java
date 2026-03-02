package com.payermax.sdk.callback;


/**
 * 付款结果通知 - 回调数据
 * 该地址无需商户主动请求，以下request.body为payermax对订单状态的回调内容，您在收到回调后需要响应{"msg": "Success","code": "SUCCESS"}
 * 
 * <p>注意：这是回调接口的数据对象，用于接收 PayerMax 的回调通知。</p>
 * 
 * 回调路径: /disbursementResultNotifyUrl
 **/
public class DisbursementResultNotifyUrlCallback extends BaseCallback<DisbursementResultNotifyUrlData> {

    private static final long serialVersionUID = 1L;

}

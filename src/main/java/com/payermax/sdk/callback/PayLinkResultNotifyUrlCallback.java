package com.payermax.sdk.callback;


/**
 * 支付链接更新回调 - 回调数据
 * 链接被支付成功时，回调链接详情。
提示：该地址无需商户主动请求，以下request.body为payermax对订单状态的回调内容，商户收到回调后需要响应
{"msg": "Success","cod...
 * 
 * <p>注意：这是回调接口的数据对象，用于接收 PayerMax 的回调通知。</p>
 * 
 * 回调路径: /payLinkResultNotifyUrl
 **/
public class PayLinkResultNotifyUrlCallback extends BaseCallback<PayLinkResultNotifyUrlData> {

    private static final long serialVersionUID = 1L;

}

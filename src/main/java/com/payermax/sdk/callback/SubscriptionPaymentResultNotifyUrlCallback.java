package com.payermax.sdk.callback;


/**
 * 扣款结果通知 - 回调数据
 * 当订阅计划激活后，PayerMax会按照商户创建订阅计划时指定的扣款周期进行扣款，每一期扣款成功后，都会通知商户扣款结果；当某期扣款失败后，PayerMax会在24小时内重试3次（总共会有4次扣款），...
 * 
 * <p>注意：这是回调接口的数据对象，用于接收 PayerMax 的回调通知。</p>
 * 
 * 回调路径: /subscriptionPaymentResultNotifyUrl
 **/
public class SubscriptionPaymentResultNotifyUrlCallback extends BaseCallback<SubscriptionPaymentResultNotifyUrlData> {

    private static final long serialVersionUID = 1L;

}

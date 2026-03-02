package com.payermax.sdk.callback;


/**
 * 订阅状态变更通知 - 回调数据
 * 当订阅状态变更后，PayerMax会通知商户订阅当前的状态。
 * 
 * <p>注意：这是回调接口的数据对象，用于接收 PayerMax 的回调通知。</p>
 * 
 * 回调路径: /subscriptionResultNotifyUrl
 **/
public class SubscriptionResultNotifyUrlCallback extends BaseCallback<SubscriptionResultNotifyUrlData> {

    private static final long serialVersionUID = 1L;

}

package com.payermax.sdk.callback;


/**
 * 风控欺诈通知 - 回调数据
 * 欺诈通知接口，用于通知商户产生了欺诈的交易，可用于商户自己对于欺诈交易或用户做风险管理
 * 
 * <p>注意：这是回调接口的数据对象，用于接收 PayerMax 的回调通知。</p>
 * 
 * 回调路径: /fraudNotifyUrl
 **/
public class FraudNotifyUrlCallback extends BaseCallback<FraudNotifyUrlData> {

    private static final long serialVersionUID = 1L;

}

package com.payermax.sdk.callback;


/**
 * 动账通知 - 回调数据
 * 当商户因为充值、转账、换汇、提现操作产生账户余额变动的时候，我们将会通过该API进行通知。
 * 
 * <p>注意：这是回调接口的数据对象，用于接收 PayerMax 的回调通知。</p>
 * 
 * 回调路径: /balanceNotifyUrl
 **/
public class BalanceNotifyUrlCallback extends BaseCallback<BalanceNotifyUrlData> {

    private static final long serialVersionUID = 1L;

}

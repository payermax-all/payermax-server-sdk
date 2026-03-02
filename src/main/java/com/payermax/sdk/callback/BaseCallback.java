package com.payermax.sdk.callback;

import java.io.Serializable;

/**
 * 回调基类
 * <p>
 * 所有 PayerMax 回调通知的基类，包含公共字段。
 * </p>
 */
public abstract class BaseCallback<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回描述，交易成功时，msg:Success. 且status：SUCCESS;
     * 交易失败，msg会返回交易失败错误msg 且status为FAILED或CLOSED。
     */
    private String msg;

    /**
     * 返回码，交易成功时，code:APPLY_SUCCESS 且status：SUCCESS;
     * 交易失败，code会返回交易失败错误码 且status为FAILED或CLOSED。
     */
    private String code;

    /**
     * 通知类型 PAYMENT
     */
    private String notifyType;

    /**
     * 密钥版本。当前值为：1
     */
    private String keyVersion;

    /**
     * 回调数据
     */
    private T data;

    /**
     * 通知时间，符合rfc3339规范，格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX
     */
    private String notifyTime;

    /**
     * 商户app id
     */
    private String appId;

    /**
     * 商户Id
     */
    private String merchantNo;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getKeyVersion() {
        return keyVersion;
    }

    public void setKeyVersion(String keyVersion) {
        this.keyVersion = keyVersion;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}

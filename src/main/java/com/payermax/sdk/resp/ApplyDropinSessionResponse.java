package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * Apply Drop-in Session - 响应
 **/
public class ApplyDropinSessionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Drop-in
      **/
    private String sessionKey;

    /**
     * 前端SDK初始化参数
      **/
    private String clientKey;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

}

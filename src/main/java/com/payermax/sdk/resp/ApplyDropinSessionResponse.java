package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * Apply Drop-in Session - 响应
 **/
public class ApplyDropinSessionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Drop-in
     */
    private String sessionKey;

    /**
     * 
     */
    private List<String> notSupportedComponent;

    /**
     * 前端SDK初始化参数
     */
    private String clientKey;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public List<String> getNotSupportedComponent() {
        return notSupportedComponent;
    }

    public void setNotSupportedComponent(List<String> notSupportedComponent) {
        this.notSupportedComponent = notSupportedComponent;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

}

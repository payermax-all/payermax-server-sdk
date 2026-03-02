package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 创建链接 - 响应
 **/
public class CreatePaybylinkResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ACTIVE、EXPIRED
      **/
    private String linkStatus;

    /**
     * PMmax链接唯一单号
      **/
    private String linkId;

    /**
     * PayByLink QRcode url
      **/
    private String qrCodeUrl;

    /**
     * PayByLink url
      **/
    private String linkUrl;

    /**
     * 商户链接唯一订单号
      **/
    private String merchantLinkId;

    /**
     * 链接具体失效时间
      **/
    private String expiresAt;

    public String getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(String linkStatus) {
        this.linkStatus = linkStatus;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getMerchantLinkId() {
        return merchantLinkId;
    }

    public void setMerchantLinkId(String merchantLinkId) {
        this.merchantLinkId = merchantLinkId;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

}

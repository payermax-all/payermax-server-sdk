package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 失效支付链接 - 响应
 **/
public class ExpirePaybylinkResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 链接状态，ACTIVE、EXPIRED
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
     * 链接失效具体时间
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

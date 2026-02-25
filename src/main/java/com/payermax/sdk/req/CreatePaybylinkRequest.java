package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.CreatePaybylinkResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 创建链接
 * 接口名称：createPaybylink
 *
 * API 路径: /aggregate-pay/api/gateway/createPaybylink
 * 请求方法: POST
 **/
public class CreatePaybylinkRequest extends BaseRequest<CreatePaybylinkResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 国家代码，大写字母，如果所传的国家代码与币种不匹配，则以货币代码对应的地区展示收银台。国家上送参见【[交易支持国家/地区与币种](https://docs-v2.payermax.com/doc-center/appendix/collection/supported-country-region-currency.html)】
     */
    private String country;

    /**
     * 用户信息
     */
    private UserInfo userInfo;

    /**
     * 商品信息，支持传多个。
     */
    private List<GoodsDetails> goodsDetails;

    /**
     * 订单描述，在链接页面展示给用户
     */
    private String description;

    /**
     * 链接页面语言，默认英语
     */
    private String language;

    /**
     * 链接页面展示商户信息
     */
    private MerchantInfo merchantInfo;

    /**
     * 商户链接唯一订单号
     */
    private String merchantLinkId;

    /**
     * 链接有效时长，单位为秒，最长可30天，默认24h，最小1h
     */
    private String expiresTime;

    /**
     * 标价金额，金额的单位为元。 除以下国家外，按照各国币种支持的小数点位上送 注意：巴林、科威特、约旦、阿曼、突尼斯，本币只支持两位小数； 印尼、中国台湾、韩国、越南、智利、巴基斯坦、哥伦比亚、日本、冰岛、巴拉圭，本币不支持带小数金额。
     */
    private String totalAmount;

    /**
     * 链接描述，不展示给用户，用于商户备注
     */
    private String linkDescription;

    /**
     * 服务端回调通知URL，以http/https开头，可以通过MerchantDashboard平台配置商户通知地址，如果订单中上送，则以此为准
     */
    private String notifyUrl;

    /**
     * 枚举值：ONETIME，当前仅支持ONETIME
     */
    private String linkType;

    /**
     * 标价币种，大写字母，参见【[交易支持国家/地区与币种](https://docs-v2.payermax.com/doc-center/appendix/collection/supported-country-region-currency.html)】
     */
    private String currency;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<GoodsDetails> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetails> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public String getMerchantLinkId() {
        return merchantLinkId;
    }

    public void setMerchantLinkId(String merchantLinkId) {
        this.merchantLinkId = merchantLinkId;
    }

    public String getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(String expiresTime) {
        this.expiresTime = expiresTime;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    protected String getApiName() {
        return "createPaybylink";
    }
    /**
     * 嵌套对象
     */
    public static final class UserInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * oneTime类可传入，用户在商户侧唯一id
         */
        private String userId;

        /**
         * oneTime类可传入，用户姓名
         */
        private String username;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }

    /**
     * 数组元素
     */
    public static final class GoodsDetails implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 商品数量
         */
        private String quantity;

        /**
         * 商品价格，商户系统的报价
         */
        private String price;

        /**
         * 商品展示地址
         */
        private String showUrl;

        /**
         * 商品报价币种，大写字母。参见【[交易支持国家/地区与币种](https://docs-v2.payermax.com/doc-center/appendix/collection/supported-country-region-currency.html)】
         */
        private String goodsCurrency;

        /**
         * 商品名称
         */
        private String goodsName;

        /**
         * 商品描述。
         */
        private String goodsDescription;

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getShowUrl() {
            return showUrl;
        }

        public void setShowUrl(String showUrl) {
            this.showUrl = showUrl;
        }

        public String getGoodsCurrency() {
            return goodsCurrency;
        }

        public void setGoodsCurrency(String goodsCurrency) {
            this.goodsCurrency = goodsCurrency;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsDescription() {
            return goodsDescription;
        }

        public void setGoodsDescription(String goodsDescription) {
            this.goodsDescription = goodsDescription;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class MerchantInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 用户联系商户邮箱
         */
        private String contactEmail;

        /**
         * 链接页面展示的商户logo图片
         */
        private String logoUrl;

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

    }

}

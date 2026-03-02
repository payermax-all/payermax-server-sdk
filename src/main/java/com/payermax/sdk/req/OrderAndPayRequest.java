package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.OrderAndPayResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 收银台-下单 
 * 


 *
 * API 路径: /aggregate-pay/api/gateway/orderAndPay(for-auth-capture-dont-copy-me)
 * 请求方法: POST
 **/
public class OrderAndPayRequest extends BaseRequest<OrderAndPayResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 国家代码，大写字母，参见交易支持国家/地区与币种。
如指定了paymentMethodType，则国家代码必须上送且和支付方式对应国家匹配。
收银台可用国家地区选择策略为：上送国家代码地区&gt;用户历史使用国家代码地区&gt;用户IP所在国家代码地区。（可用国家地区：交易币种对应的国家与签约国家取交集）

      **/
    private String country;

    /**
     * 详见风控业务数据商户上送信息
      **/
    private Object riskParams;

    /**
     * 商品信息，支持传多个。&lt;span style="color:red"&gt;注：电商场景下需要上送。如果传入该对象，则内层必填字段必须传入&lt;/span&gt;

      **/
    private List<GoodsDetails> goodsDetails;

    /**
     * 商户指定的跳转URL，用户完成支付后会被跳转到该地址，以http/https开头或者商户应用的scheme地址。详见结果页跳转说明
      **/
    private String frontCallbackUrl;

    /**
     * 订单标题或产品信息，会展示在用户支付页面，避免使用纯数字。注：巴西钱包Pix不能超过43位
      **/
    private String subject;

    /**
     * 
      **/
    private SubscriptionPlan subscriptionPlan;

    /**
     * 邮寄信息 &lt;span style="color:red"&gt;注：电商场景下需要上送。如果传入该对象，则内层必填字段必须传入&lt;/span&gt;
      **/
    private ShippingInfo shippingInfo;

    /**
     * 收银台页面语言。支持的国家与币种
优先级：用户上次使用的语言 &gt; 用户浏览器语言 &gt; 用户ip国家语言 &gt; 商户下单传的语言 &gt; 默认EN
      **/
    private String language;

    /**
     * 商户内部的用户Id，&lt;span style="color:red"&gt;需要保证每个ID唯一性&lt;/span&gt;。支付方式绑定后会根据userId进行支付方式推荐
      **/
    private String userId;

    /**
     * 使用PayerMax_Hosted_Payment_Page进行付款方支付信息收集及处理，需传入参数：Hosted_Checkout
      **/
    private String integrate;

    /**
     * 商户自定义附加数据，可支持商户自定义并在响应中返回	
      **/
    private String reference;

    /**
     * 标价金额，金额的单位为元。各个国家币种支持的小数位详见交易支持国家/地区与币种,风控限额详见风控行业限额
      **/
    private Long totalAmount;

    /**
     * 信用卡账单信息。&lt;span style="color:red"&gt;注：如果传入该对象，则内层必填字段必须传入&lt;/span&gt;
      **/
    private BillingInfo billingInfo;

    /**
     * 指定关单时间(单位：秒)。最小30分钟，最大1天。若传入则以该时间为关单时间。默认30分钟
      **/
    private String expireTime;

    /**
     * 二级商户信息 平台类商户需要上送子商户信息
      **/
    private SubMerchant subMerchant;

    /**
     * 支付信息，非必填 。
1、可指定支付方式类型，收银台会拉起该支付方式类型支持的所有目标机构 。
2、可指定支付方式类型+目标机构。
      **/
    private PaymentDetail paymentDetail;

    /**
     * 商户订单号，唯一标识商户的一笔交易，不能重复，只能包含字母、数字、下划线且不支持大小写敏感。如：AAA和AAa被认为是相同的。
      **/
    private String outTradeNo;

    /**
     * 用于更精准的支付方式推荐，如设备ID、设备指纹等。
      **/
    private String referralCode;

    /**
     * 设备信息
      **/
    private EnvInfo envInfo;

    /**
     *  授权类型:FINAL_AUTH
      **/
    private String authorizationType;

    /**
     * 服务端回调通知URL，以http/https开头 可以通过MerchantDashboard平台配置商户通知地址，详情见配置异步通知地址，如果交易中上送，则以交易为准，即优先使用接口中传的url。&lt;span style="color:red"&gt;注：如商户平台未配置通知地址，交易也没上送地址，则无法进行回调通知&lt;/span&gt;
      **/
    private String notifyUrl;

    /**
     * 请款模式：MANUAL
      **/
    private String captureMode;

    /**
     * 标价币种，大写字母，参见交易支持国家/地区与币种
      **/
    private String currency;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getRiskParams() {
        return riskParams;
    }

    public void setRiskParams(Object riskParams) {
        this.riskParams = riskParams;
    }

    public List<GoodsDetails> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetails> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public String getFrontCallbackUrl() {
        return frontCallbackUrl;
    }

    public void setFrontCallbackUrl(String frontCallbackUrl) {
        this.frontCallbackUrl = frontCallbackUrl;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIntegrate() {
        return integrate;
    }

    public void setIntegrate(String integrate) {
        this.integrate = integrate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public SubMerchant getSubMerchant() {
        return subMerchant;
    }

    public void setSubMerchant(SubMerchant subMerchant) {
        this.subMerchant = subMerchant;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public EnvInfo getEnvInfo() {
        return envInfo;
    }

    public void setEnvInfo(EnvInfo envInfo) {
        this.envInfo = envInfo;
    }

    public String getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(String authorizationType) {
        this.authorizationType = authorizationType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getCaptureMode() {
        return captureMode;
    }

    public void setCaptureMode(String captureMode) {
        this.captureMode = captureMode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    protected String getApiName() {
        return "orderAndPay";
    }
    /**
     * 数组元素
      **/
    public static final class GoodsDetails implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 商品数量
          **/
        private String quantity;

        /**
         * 商品ID
          **/
        private String goodsId;

        /**
         * 商品价格，商户系统的报价
          **/
        private String price;

        /**
         * 商品类别。&lt;span style="color:red"&gt;注：电商场景下需要上送&lt;/span&gt;
          **/
        private String goodsCategory;

        /**
         * 商品链接地址。&lt;span style="color:red"&gt;注：电商场景下需要上送&lt;/span&gt;
          **/
        private String showUrl;

        /**
         * 商品报价币种，大写字母，参见交易支持国家/地区与币种
          **/
        private String goodsCurrency;

        /**
         * 商品名称
          **/
        private String goodsName;

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getGoodsCategory() {
            return goodsCategory;
        }

        public void setGoodsCategory(String goodsCategory) {
            this.goodsCategory = goodsCategory;
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

    }
    /**
     * 嵌套对象
      **/
    public static final class SubscriptionPlan implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 通过PayerMax创建订阅计划后生成的订阅单号，激活订阅计划时必传
          **/
        private String subscriptionNo;

        public String getSubscriptionNo() {
            return subscriptionNo;
        }

        public void setSubscriptionNo(String subscriptionNo) {
            this.subscriptionNo = subscriptionNo;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class ShippingInfo implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 收货人名	
          **/
        private String firstName;

        /**
         * 收货人姓
          **/
        private String lastName;

        /**
         * 收货地址所在国家	
          **/
        private String country;

        /**
         * 收货地址邮编
          **/
        private String zipCode;

        /**
         * 收货地址2
          **/
        private String address2;

        /**
         * 收货地址所在城市
          **/
        private String city;

        /**
         * 收货地址1
          **/
        private String address1;

        /**
         * 收货人中间名
          **/
        private String middleName;

        /**
         * 收货地址所在州 送货到加拿大，美国，英国，澳大利亚时必填
          **/
        private String state;

        /**
         * 收货地址所在区域
          **/
        private String region;

        /**
         * 收货人手机号
          **/
        private String phoneNo;

        /**
         * 收货邮箱地址
          **/
        private String email;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class BillingInfo implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 账单人名
          **/
        private String firstName;

        /**
         * 账单人姓
          **/
        private String lastName;

        /**
         * 账单地址所在国家
          **/
        private String country;

        /**
         * 账单地址邮编
          **/
        private String zipCode;

        /**
         * 账单地址2
          **/
        private String address2;

        /**
         * 账单地址所在城市
          **/
        private String city;

        /**
         * 账单地址1
          **/
        private String address1;

        /**
         * 账单人中间名
          **/
        private String middleName;

        /**
         * 账单地址所在州 送货到加拿大，美国，英国，澳大利亚时需要上送
          **/
        private String state;

        /**
         * 账单地址所在区域
          **/
        private String region;

        /**
         * 账单人手机号
          **/
        private String phoneNo;

        /**
         * 账单邮箱地址
          **/
        private String email;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class SubMerchant implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 二级商户号
          **/
        private String subMerchantNo;

        public String getSubMerchantNo() {
            return subMerchantNo;
        }

        public void setSubMerchantNo(String subMerchantNo) {
            this.subMerchantNo = subMerchantNo;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class PaymentDetail implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 目标机构，可以为空，如果指定目标机构，则paymentMethodType也必须指定。参见收银台支付-支付方式列表	
          **/
        private String targetOrg;

        /**
         * 代表是否MIT交易，不传默认为false。
          **/
        private Boolean merchantInitiated;

        /**
         * token支付或商家代扣后续支付时，此字段为必填；
          **/
        private String paymentTokenID;

        /**
         * 支付账号，当指定支付方式和目标机构时，支持上送用户在该目标机构的支付账号信息。参见收银台支付-支付方式列表下的支持上送账号类型列
          **/
        private List<PayAccountInfo> payAccountInfo;

        /**
         * 代扣类型；枚举值：SCHEDULED、UNSCHEDULED
          **/
        private String mitType;

        /**
         * 支付方式类型，为空时，拉取所有可用支付方式，参见收银台支付-支付方式列表
          **/
        private String paymentMethodType;

        /**
         * 指定收银台可使用的卡组
          **/
        private List<String> allowedCardOrg;

        /**
         * true代表用户已授权进行支付信息绑定，用于后续使用，默认为false。
          **/
        private Boolean tokenForFutureUse;

        public String getTargetOrg() {
            return targetOrg;
        }

        public void setTargetOrg(String targetOrg) {
            this.targetOrg = targetOrg;
        }

        public Boolean getMerchantInitiated() {
            return merchantInitiated;
        }

        public void setMerchantInitiated(Boolean merchantInitiated) {
            this.merchantInitiated = merchantInitiated;
        }

        public String getPaymentTokenID() {
            return paymentTokenID;
        }

        public void setPaymentTokenID(String paymentTokenID) {
            this.paymentTokenID = paymentTokenID;
        }

        public List<PayAccountInfo> getPayAccountInfo() {
            return payAccountInfo;
        }

        public void setPayAccountInfo(List<PayAccountInfo> payAccountInfo) {
            this.payAccountInfo = payAccountInfo;
        }

        public String getMitType() {
            return mitType;
        }

        public void setMitType(String mitType) {
            this.mitType = mitType;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public void setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
        }

        public List<String> getAllowedCardOrg() {
            return allowedCardOrg;
        }

        public void setAllowedCardOrg(List<String> allowedCardOrg) {
            this.allowedCardOrg = allowedCardOrg;
        }

        public Boolean getTokenForFutureUse() {
            return tokenForFutureUse;
        }

        public void setTokenForFutureUse(Boolean tokenForFutureUse) {
            this.tokenForFutureUse = tokenForFutureUse;
        }

    }
    /**
     * 数组元素
      **/
    public static final class PayAccountInfo implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 账号类型：EMAIL，PHONE，ACCOUNT	
          **/
        private String accountNoType;

        /**
         * 用户在该支付方式下的目标机构注册的支付账号,详见每个支付方式介绍
          **/
        private String accountNo;

        public String getAccountNoType() {
            return accountNoType;
        }

        public void setAccountNoType(String accountNoType) {
            this.accountNoType = accountNoType;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class EnvInfo implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 设备宽度
          **/
        private String screenWidth;

        /**
         * 设备高度
          **/
        private String screenHeight;

        /**
         * 设备默认语言
          **/
        private String deviceLanguage;

        /**
         * 商户设备唯一标识
          **/
        private String deviceId;

        public String getScreenWidth() {
            return screenWidth;
        }

        public void setScreenWidth(String screenWidth) {
            this.screenWidth = screenWidth;
        }

        public String getScreenHeight() {
            return screenHeight;
        }

        public void setScreenHeight(String screenHeight) {
            this.screenHeight = screenHeight;
        }

        public String getDeviceLanguage() {
            return deviceLanguage;
        }

        public void setDeviceLanguage(String deviceLanguage) {
            this.deviceLanguage = deviceLanguage;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

    }
}

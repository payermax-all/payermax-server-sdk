package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.PaymentOrderPayResponse;
import java.io.Serializable;

/**
 * 申请付款
 * 此接口为API付款接口，该接口返回参数请注意以下事项，否则可能会有资损风险：
1. 当"code": "APPLY_SUCCESS"且返回"status":"PENDING"，代表下单成功，订单状态请...
 *
 * API 路径: /aggregate-pay/api/gateway/paymentOrderPay
 * 请求方法: POST
 **/
public class PaymentOrderPayRequest extends BaseRequest<PaymentOrderPayResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 国家代码，大写字母，参见支持的国家与币种
     */
    private String country;

    /**
     * 风控业务数据
     */
    private RiskParams riskParams;

    /**
     * 扣款账户的币种代码，大写字母	
     */
    private String sourceAccount;

    /**
     * 出款目的，枚举值，ISUBIL:向公用事业提供商付款(i.e.水电煤账单)； EPTOUR:旅游业； EPTKAG:支付旅游门票或旅行社费用； ISPAYR:支付工资； ISPAYRA:支付代理工资； ISGDDS:货物买卖； ISSCVE:购买和销售服务； ISSUPP:供应商付款； ISLOGS:物流和运输服务付款； INCEN:激励/促销/用户获取活动； GAME:游戏设备、游戏币和其他游戏物品； SAMENM:企业同名账户转账； PAYCMSN:报销/福利发放/佣金发放； SAMENMC:法人/股东/董事个人账户； AGOPEXP:代运营费用结算； ADEXP:广告费用结算；RFND:退货；SMCNTST:子商户结算；LGTEP:供应商付款-物流费用结算；GOODPAY:供应商付款-货款结算；SINVEST:股票投资；FINVEST:基金投资；TAXPAY:纳税/支付税款；LOANPAY:支付贷款； OTHER:其他；
     */
    private String purpose;

    /**
     * 出款附言或备注，允许英文，数字，中划线，空格，点；受渠道约束，该字段可能会进行特殊处理，如超长截断或填充默认值
     */
    private String remark;

    /**
     * 商户内部的用户Id，需要保证每个ID唯一性
     */
    private String userId;

    /**
     * 收款方通知电话
     */
    private String notifyPhone;

    /**
     * 费用承担模式，是否必传参照《付款申请模板及填写规范 (https://docs-v2.payermax.com/doc-center/appendix/disbursement/disbursement-application-template.html)》
     */
    private String chargeOption;

    /**
     * 透传数据，在付款异步回调通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    private String reference;

    /**
     * 交易信息
     */
    private Trade trade;

    /**
     * 付款方信息
     */
    private PayerInfo payerInfo;

    /**
     * 枚举值为：SWIFT, SEPA, LOCAL，分别对应签约的SWIFT、SEPA、Local Banks支付方式，请根据实际要用的支付方式来上送，请参照《付款申请模板及填写规范 (https://docs-v2.payermax.com/doc-center/appendix/disbursement/disbursement-application-template.html)》
     */
    private String clearingRail;

    /**
     * 收款方信息
     */
    private PayeeInfo payeeInfo;

    /**
     * 商户订单号，唯一标识商户的一笔交易，不能重复，只能包含字母、数字、下划线
     */
    private String outTradeNo;

    /**
     * 指定到账币种，请参考支付方式列表，如有标明到账币种的，需要指定到账币种；若未标明，则到账币种仅支持本币，不需要进行指定
     */
    private String destinationCurrency;

    /**
     * 商户接收付款结果的后台回调地址，以http/https开头
     */
    private String notifyUrl;

    /**
     * 取款码有效天数，当前仅在FawryCash中有效，支持传入1~15整数（1=24Hours），其他值或不传则默认为7
     */
    private String expiryDays;

    /**
     * 收款方通知邮箱，目前只有个别支付方式会发送取款码邮件，比如FAWRY
     */
    private String notifyEmail;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public RiskParams getRiskParams() {
        return riskParams;
    }

    public void setRiskParams(RiskParams riskParams) {
        this.riskParams = riskParams;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNotifyPhone() {
        return notifyPhone;
    }

    public void setNotifyPhone(String notifyPhone) {
        this.notifyPhone = notifyPhone;
    }

    public String getChargeOption() {
        return chargeOption;
    }

    public void setChargeOption(String chargeOption) {
        this.chargeOption = chargeOption;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public PayerInfo getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(PayerInfo payerInfo) {
        this.payerInfo = payerInfo;
    }

    public String getClearingRail() {
        return clearingRail;
    }

    public void setClearingRail(String clearingRail) {
        this.clearingRail = clearingRail;
    }

    public PayeeInfo getPayeeInfo() {
        return payeeInfo;
    }

    public void setPayeeInfo(PayeeInfo payeeInfo) {
        this.payeeInfo = payeeInfo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(String expiryDays) {
        this.expiryDays = expiryDays;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    @Override
    protected String getApiName() {
        return "paymentOrderPay";
    }
    /**
     * 嵌套对象
     */
    public static final class RiskParams implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 账号绑定邮箱
         */
        private String bindEmail;

        /**
         * 第三方 帐户类型： 枚举值 Facebook, Google, AppleID，Others 
         */
        private String thirdAccountNoType;

        /**
         * 商户网站/app上用户的昵称
         */
        private String nickName;

        /**
         * 现居住地址（国家维度），如CN
         */
        private String liveCountry;

        /**
         * 账号等级
         */
        private String accountLevel;

        /**
         * 第三方账号标识
         */
        private String thirdAccountNo;

        /**
         * 商户网站/app上用户的注册标识
         */
        private String registerNo;

        /**
         * 账号绑定手机号
         */
        private String bindPhoneNo;

        /**
         * VIP等级
         */
        private String vipLevel;

        /**
         * 最后一次登录/活跃时间，格式：yyyy-MM-dd HH:mm:ss
         */
        private String lastLoginTime;

        /**
         * 账号注册时间，格式：yyyy-MM-dd HH:mm:ss
         */
        private String regTime;

        /**
         * 用户在商户侧，最近3个月累计出款成功金额（USD）
         */
        private String cumPayoutAmount;

        /**
         * 用户税号
         */
        private String taxId;

        /**
         * 针对平台类商户下，在平台注册的卖家注册账号
         */
        private String expressMerchantID;

        /**
         * 用户在商户侧，最近3个月累计出款成功笔数
         */
        private String cumPayoutTxn;

        /**
         * 用户在商户侧，用户账号当前余额 (金币/钻石)
         */
        private String accountBalance;

        /**
         * 注册账号持有人姓名
         */
        private String registerName;

        public String getBindEmail() {
            return bindEmail;
        }

        public void setBindEmail(String bindEmail) {
            this.bindEmail = bindEmail;
        }

        public String getThirdAccountNoType() {
            return thirdAccountNoType;
        }

        public void setThirdAccountNoType(String thirdAccountNoType) {
            this.thirdAccountNoType = thirdAccountNoType;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getLiveCountry() {
            return liveCountry;
        }

        public void setLiveCountry(String liveCountry) {
            this.liveCountry = liveCountry;
        }

        public String getAccountLevel() {
            return accountLevel;
        }

        public void setAccountLevel(String accountLevel) {
            this.accountLevel = accountLevel;
        }

        public String getThirdAccountNo() {
            return thirdAccountNo;
        }

        public void setThirdAccountNo(String thirdAccountNo) {
            this.thirdAccountNo = thirdAccountNo;
        }

        public String getRegisterNo() {
            return registerNo;
        }

        public void setRegisterNo(String registerNo) {
            this.registerNo = registerNo;
        }

        public String getBindPhoneNo() {
            return bindPhoneNo;
        }

        public void setBindPhoneNo(String bindPhoneNo) {
            this.bindPhoneNo = bindPhoneNo;
        }

        public String getVipLevel() {
            return vipLevel;
        }

        public void setVipLevel(String vipLevel) {
            this.vipLevel = vipLevel;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getRegTime() {
            return regTime;
        }

        public void setRegTime(String regTime) {
            this.regTime = regTime;
        }

        public String getCumPayoutAmount() {
            return cumPayoutAmount;
        }

        public void setCumPayoutAmount(String cumPayoutAmount) {
            this.cumPayoutAmount = cumPayoutAmount;
        }

        public String getTaxId() {
            return taxId;
        }

        public void setTaxId(String taxId) {
            this.taxId = taxId;
        }

        public String getExpressMerchantID() {
            return expressMerchantID;
        }

        public void setExpressMerchantID(String expressMerchantID) {
            this.expressMerchantID = expressMerchantID;
        }

        public String getCumPayoutTxn() {
            return cumPayoutTxn;
        }

        public void setCumPayoutTxn(String cumPayoutTxn) {
            this.cumPayoutTxn = cumPayoutTxn;
        }

        public String getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(String accountBalance) {
            this.accountBalance = accountBalance;
        }

        public String getRegisterName() {
            return registerName;
        }

        public void setRegisterName(String registerName) {
            this.registerName = registerName;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class Trade implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 交易金额 ，按照各国币种支持的小数点位上送。注意：印尼，越南，韩国，智利，本币不支持带小数金额
         */
        private String amount;

        /**
         * 交易币种，大写字母	
         */
        private String currency;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class PayerInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 付款公司行业分类，枚举值，DIGITAL_GOODS_MEDIA：数娱类产品-媒介；DIGITAL_GOODS_APPLICATION：数字产品-应用软件类；TRAVEL_AGENCIES_AND_TRAVEL_RELATED_SERVICES：旅行社；COURIER_SERVICES_AIR_AND_GROUND_AND_FREIGHT_FORWARDERS：快递服务-空运、陆运及货物运输代理商；ADVERTISING_SERVICES：广告业务；TELECOMMUNICATION_SERVICE：电信服务；COMPUTER_NETWORKS_AND_INFORMATION_SERVICES：计算机网络/信息服务；MISCELLANEOUS_GENERAL_MERCHANDISE：电商-杂项百货。
         */
        private String merchantCategoryCode;

        /**
         * 子商户号。子商户在系统中的唯一标识
         */
        private String subMerchantNo;

        /**
         * 付款公司所属机构/平台商户号
         */
        private String payerId;

        /**
         * 付款方姓名，支持英文、空格、逗号、中划线、点，在不同国家-支付方式下填写规范不同
         */
        private Name name;

        /**
         * 付款公司主体注册名
         */
        private String businessLegalName;

        /**
         * 付款公司主体注册国家，2位大写国家编码
         */
        private String registrationCountry;

        public String getMerchantCategoryCode() {
            return merchantCategoryCode;
        }

        public void setMerchantCategoryCode(String merchantCategoryCode) {
            this.merchantCategoryCode = merchantCategoryCode;
        }

        public String getSubMerchantNo() {
            return subMerchantNo;
        }

        public void setSubMerchantNo(String subMerchantNo) {
            this.subMerchantNo = subMerchantNo;
        }

        public String getPayerId() {
            return payerId;
        }

        public void setPayerId(String payerId) {
            this.payerId = payerId;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public String getBusinessLegalName() {
            return businessLegalName;
        }

        public void setBusinessLegalName(String businessLegalName) {
            this.businessLegalName = businessLegalName;
        }

        public String getRegistrationCountry() {
            return registrationCountry;
        }

        public void setRegistrationCountry(String registrationCountry) {
            this.registrationCountry = registrationCountry;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class Name implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 付款方名
         */
        private String firstName;

        /**
         * 付款方姓
         */
        private String lastName;

        /**
         * 付款方全名
         */
        private String fullName;

        /**
         * 付款方中间名，多段中间名时，使用空格进行分隔
         */
        private String middleName;

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

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class PayeeInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 收款账户信息
         */
        private AccountInfo accountInfo;

        /**
         * 收款方银行信息
         */
        private BankInfo bankInfo;

        /**
         * 收款方移动电话号码，在不同国家-支付方式下填写规范不同
         */
        private String payeePhone;

        /**
         * 收款方地址信息
         */
        private Address address;

        /**
         * 收款方个人身份信息
         */
        private Document document;

        /**
         * 收款人出生国家，ISO 3166-1 alpha-2标准，如CN，US
         */
        private String payeeBirthCountry;

        /**
         * 收款方出生日期，yyyy-MM-dd格式
         */
        private String birthDate;

        /**
         * 目标机构，请参考支付方式列表
         */
        private String targetOrg;

        /**
         * 收款人国籍，ISO 3166-1 alpha-2标准，如CN，US
         */
        private String payeeNationality;

        /**
         * 收款方姓名，支持英文、空格、逗号、中划线、点，在不同国家-支付方式下填写规范不同
         */
        private Name name;

        /**
         * 收款人性别，枚举值F 或M（F=Female，M=Male）
         */
        private String payeeGender;

        /**
         * 收款方类型（PERSONAL/CORPORATION），默认PERSONAL
         */
        private String payeeType;

        /**
         * 支付方式，请参考支付方式列表
         */
        private String paymentMethodType;

        /**
         * 收款方邮箱
         */
        private String email;

        public AccountInfo getAccountInfo() {
            return accountInfo;
        }

        public void setAccountInfo(AccountInfo accountInfo) {
            this.accountInfo = accountInfo;
        }

        public BankInfo getBankInfo() {
            return bankInfo;
        }

        public void setBankInfo(BankInfo bankInfo) {
            this.bankInfo = bankInfo;
        }

        public String getPayeePhone() {
            return payeePhone;
        }

        public void setPayeePhone(String payeePhone) {
            this.payeePhone = payeePhone;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Document getDocument() {
            return document;
        }

        public void setDocument(Document document) {
            this.document = document;
        }

        public String getPayeeBirthCountry() {
            return payeeBirthCountry;
        }

        public void setPayeeBirthCountry(String payeeBirthCountry) {
            this.payeeBirthCountry = payeeBirthCountry;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getTargetOrg() {
            return targetOrg;
        }

        public void setTargetOrg(String targetOrg) {
            this.targetOrg = targetOrg;
        }

        public String getPayeeNationality() {
            return payeeNationality;
        }

        public void setPayeeNationality(String payeeNationality) {
            this.payeeNationality = payeeNationality;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public String getPayeeGender() {
            return payeeGender;
        }

        public void setPayeeGender(String payeeGender) {
            this.payeeGender = payeeGender;
        }

        public String getPayeeType() {
            return payeeType;
        }

        public void setPayeeType(String payeeType) {
            this.payeeType = payeeType;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public void setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
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
     */
    public static final class AccountInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 收款方账号，根据付款方式不同填入相应账号	
         */
        private String accountNo;

        /**
         * 收款账户类型,在不同国家-支付方式下规范不同	
         */
        private String accountType;

        /**
         * 收款方账户验证数字	
         */
        private String checkDigit;

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public String getCheckDigit() {
            return checkDigit;
        }

        public void setCheckDigit(String checkDigit) {
            this.checkDigit = checkDigit;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class BankInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 用于识别特定金融机构下的收款方银行代码，在不同国家下填写规范不同，参见付款申请模板及填写规范以及支持银行范围列表
         */
        private String bankCode;

        /**
         * 收款方银行的代理账号（correspondent account）
         */
        private String corAccountNo;

        /**
         * 收款人银行网点号/分行号
         */
        private String bankBranch;

        /**
         * 收款方银行名称
         */
        private String bankName;

        /**
         * 收款方银行所在城市
         */
        private String bankCity;

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getCorAccountNo() {
            return corAccountNo;
        }

        public void setCorAccountNo(String corAccountNo) {
            this.corAccountNo = corAccountNo;
        }

        public String getBankBranch() {
            return bankBranch;
        }

        public void setBankBranch(String bankBranch) {
            this.bankBranch = bankBranch;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBankCity() {
            return bankCity;
        }

        public void setBankCity(String bankCity) {
            this.bankCity = bankCity;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class Address implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 收款方邮编
         */
        private String zipCode;

        /**
         * 收款方地址
         */
        private String address;

        /**
         * 收款方城市
         */
        private String city;

        /**
         * 州
         */
        private String state;

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

    }

    /**
     * 嵌套对象
     */
    public static final class Document implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 收款方个人身份证明类型，在不同国家下可选类型不同，参见《付款申请模板及填写规范 (https://img-cdn-sg.payermax.com/public/20240402-57418710-d8d2-41ad-a613-6b81922ee119.xlsx)》
         */
        private String documentType;

        /**
         * 收款方个人识别号码生效日期，在不同国家下可选类型不同，yyyy-MM-dd格式
         */
        private String documentIssueDate;

        /**
         * 收款方个人识别号码，在不同国家下可选类型不同，参见《付款申请模板及填写规范 (https://img-cdn-sg.payermax.com/public/20240402-57418710-d8d2-41ad-a613-6b81922ee119.xlsx)》
         */
        private String documentId;

        /**
         * 收款方个人识别号码失效日期，在不同国家下可选类型不同，yyyy-MM-dd格式
         */
        private String documentExpireDate;

        public String getDocumentType() {
            return documentType;
        }

        public void setDocumentType(String documentType) {
            this.documentType = documentType;
        }

        public String getDocumentIssueDate() {
            return documentIssueDate;
        }

        public void setDocumentIssueDate(String documentIssueDate) {
            this.documentIssueDate = documentIssueDate;
        }

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getDocumentExpireDate() {
            return documentExpireDate;
        }

        public void setDocumentExpireDate(String documentExpireDate) {
            this.documentExpireDate = documentExpireDate;
        }

    }

}

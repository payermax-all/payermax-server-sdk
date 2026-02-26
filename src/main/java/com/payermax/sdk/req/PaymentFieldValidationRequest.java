package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.PaymentFieldValidationResponse;
import java.io.Serializable;

/**
 * 出款要素校验
 * 本接口用于在实际发起出款前，对商户提供的收款人要素字段（如账户、姓名、证件等）进行结构化校验，确保发起交易时，收款人信息符合格式规则。校验范围包括填写格式是否正确（如长度、正则、更细化的算法规则）、是...
 *
 * API 路径: /aggregate-pay/api/gateway/paymentFieldValidation
 * 请求方法: POST
 **/
public class PaymentFieldValidationRequest extends BaseRequest<PaymentFieldValidationResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 国家代码，大写字母，参见【[支持的国家与币种](https://docs.payermax.com/doc-center/appendix/disbursement/supported-country-region-currency.html)】
     */
    private String country;

    /**
     * 扣款账户的币种代码，大写字母
     */
    private String sourceAccount;

    /**
     * 付款方信息
     */
    private PayerInfo payerInfo;

    /**
     * 出款目的，枚举值，ISUBIL:向公用事业提供商付款(i.e.水电煤账单)； EPTOUR:旅游业； EPTKAG:支付旅游门票或旅行社费用； ISPAYR:支付工资； ISPAYRA:支付代理工资； ISGDDS:货物买卖； ISSCVE:购买和销售服务； ISSUPP:供应商付款； ISLOGS:物流和运输服务付款； INCEN:激励/促销/用户获取活动； GAME:游戏设备、游戏币和其他游戏物品； SAMENM:企业同名账户转账； PAYCMSN:报销/福利发放/佣金发放； SAMENMC:法人/股东/董事个人账户； AGOPEXP:代运营费用结算； ADEXP:广告费用结算；RFND:退货；SMCNTST:子商户结算；LGTEP:供应商付款-物流费用结算；GOODPAY:供应商付款-货款结算；SINVEST:股票投资；FINVEST:基金投资；TAXPAY:纳税/支付税款；LOANPAY:支付贷款； OTHER:其他；
     */
    private String purpose;

    /**
     * 枚举值为：SWIFT, SEPA, LOCAL，分别对应签约的SWIFT、SEPA、Local Banks支付方式，请根据实际要用的支付方式来上送，请参照《[付款申请模板及填写规范](https://docs-v2.payermax.com/doc-center/appendix/disbursement/disbursement-application-template.html)》
     */
    private String clearingRail;

    /**
     * 收款方信息
     */
    private PayeeInfo payeeInfo;

    /**
     * 到账币种，请参考【[支付方式列表](https://docs.payermax.com/doc-center/disbursement/payment-method-list/southeast-asia.html)】，如有标明到账币种的，需要指定到账币种；若未标明，则到账币种仅支持本币，不需要进行指定
     */
    private String destinationCurrency;

    /**
     * 出款附言或备注，允许英文，数字，中划线，空格，点；受渠道约束，该字段可能会进行特殊处理，如超长截断或填充默认值
     */
    private String remark;

    /**
     * 取款码有效天数，当前仅在FawryCash中有效，支持传入1~15整数（1=24Hours），其他值或不传则默认为7
     */
    private String expiryDays;

    /**
     * 收款方通知邮箱，目前只有个别支付方式会发送取款码邮件，比如FAWRY
     */
    private String notifyEmail;

    /**
     * 收款方通知电话
     */
    private String notifyPhone;

    /**
     * 费用承担模式，是否必传参照《[付款申请模板及填写规范](https://docs-v2.payermax.com/doc-center/appendix/disbursement/disbursement-application-template.html)》
     */
    private String chargeOption;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public PayerInfo getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(PayerInfo payerInfo) {
        this.payerInfo = payerInfo;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    protected String getApiName() {
        return "paymentFieldValidation";
    }
    /**
     * 嵌套对象
     */
    public static final class PayerInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 付款方姓名，支持英文、空格、逗号、中划线、点，在不同国家-支付方式下填写规范不同
         */
        private Name name;

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
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
         * 目标机构，参见【[支付方式类型及目标机构说明](https://docs-v2.payermax.com/doc-center/disbursement/introduction.html#_3-%E6%94%AF%E4%BB%98%E6%96%B9%E5%BC%8F%E7%B1%BB%E5%9E%8B%E5%8F%8A%E6%9C%BA%E6%9E%84%E8%AF%B4%E6%98%8E)】
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
         * 支付方式，参见【[支付方式类型及目标机构说明](https://docs-v2.payermax.com/doc-center/disbursement/introduction.html#_3-%E6%94%AF%E4%BB%98%E6%96%B9%E5%BC%8F%E7%B1%BB%E5%9E%8B%E5%8F%8A%E6%9C%BA%E6%9E%84%E8%AF%B4%E6%98%8E)】
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
         * 用于识别特定金融机构下的收款方银行代码，在不同国家下填写规范不同，参见【[付款申请模板及填写规范](https://docs-server-sg.payermax.com/server/../Public/Uploads/2023-09-14/New_API_field_specification.xlsx)】以及【[支持银行范围列表](https://docs-server-sg.payermax.com/Public/Uploads/2023-02-01/%E9%93%B6%E8%A1%8C%E5%88%97%E8%A1%A8%2020230201new.xlsx)】
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
         * 收款方个人身份证明类型，在不同国家下可选类型不同，参见《[付款申请模板及填写规范](https://img-cdn-sg.payermax.com/public/20240402-57418710-d8d2-41ad-a613-6b81922ee119.xlsx)》
         */
        private String documentType;

        /**
         * 收款方个人识别号码生效日期，在不同国家下可选类型不同，yyyy-MM-dd格式
         */
        private String documentIssueDate;

        /**
         * 收款方个人识别号码，在不同国家下可选类型不同，参见《[付款申请模板及填写规范](https://img-cdn-sg.payermax.com/public/20240402-57418710-d8d2-41ad-a613-6b81922ee119.xlsx)》
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

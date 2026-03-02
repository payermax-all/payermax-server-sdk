package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 交易查询 - 响应
 **/
public class OrderQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户支付的国家代码，大写字母	
     */
    private String country;

    /**
     * 费用信息，支付成功且存在费用时才返回。
     */
    private Fees fees;

    /**
     * 渠道订单号
     */
    private String channelNo;

    /**
     * 收银台模式下，在收银台上发起支付的国家。支付成功时返回。
     */
    private String cashierCountry;

    /**
     * 交易状态结果描述
     */
    private String resultCode;

    /**
     * 订单完成时间
     */
    private String completeTime;

    /**
     * 三方单号
     */
    private String thirdChannelNo;

    /**
     * 交易状态结果描述,仅失败时有值	
     */
    private String resultMsg;

    /**
     * 附加数据，商户上送的值	
     */
    private String reference;

    /**
     * 标价金额，金额的单位为元。
     */
    private Long totalAmount;

    /**
     * VA单号
     */
    private String paymentCode;

    /**
     * 订单创建时间
     */
    private String createTime;

    /**
     * 商户订单号	
     */
    private String outTradeNo;

    /**
     * PayerMax交易流水号	
     */
    private String tradeToken;

    /**
     * 标价币种
     */
    private String currency;

    /**
     * 支付信息，只有交易成功会返回支付信息，当交易失败时返回空数组。
     */
    private List<PaymentDetails> paymentDetails;

    /**
     * 订单流转到外部渠道时间点
     */
    private String confirmPayTime;

    /**
     * 交易状态，详见交易状态
     */
    private String status;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getCashierCountry() {
        return cashierCountry;
    }

    public void setCashierCountry(String cashierCountry) {
        this.cashierCountry = cashierCountry;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getThirdChannelNo() {
        return thirdChannelNo;
    }

    public void setThirdChannelNo(String thirdChannelNo) {
        this.thirdChannelNo = thirdChannelNo;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
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

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getConfirmPayTime() {
        return confirmPayTime;
    }

    public void setConfirmPayTime(String confirmPayTime) {
        this.confirmPayTime = confirmPayTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 嵌套对象
     */
    public static final class Fees implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 商户税费
         */
        private MerFee merFee;

        public MerFee getMerFee() {
            return merFee;
        }

        public void setMerFee(MerFee merFee) {
            this.merFee = merFee;
        }

    }
    /**
     * 嵌套对象
     */
    public static final class MerFee implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 费用金额
         */
        private String amount;

        /**
         * 费用币种
         */
        private String currency;

        /**
         * 发票地址，打开地址可预览发票
         */
        private String url;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
    /**
     * 数组元素
     */
    public static final class PaymentDetails implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 目标机构，用户支付所选择的目标机构; paymentMethodType为CARD的时不返回。
         */
        private String targetOrg;

        /**
         * 支付金额
         */
        private Long payAmount;

        /**
         * 卡信息
         */
        private CardInfo cardInfo;

        /**
         * 标价币种转换为支付币种的汇率
         */
        private String exchangeRate;

        /**
         * 支付币种
         */
        private String payCurrency;

        /**
         * 绑卡支付场景下，用于支付的授权ID，默认有效期为卡有效期，可通过removePaymentToken接口置为无效。
         */
        private String paymentTokenID;

        /**
         * 支付方式类型，参见收银台支付-支付方式类型。
         */
        private String paymentMethodType;

        public String getTargetOrg() {
            return targetOrg;
        }

        public void setTargetOrg(String targetOrg) {
            this.targetOrg = targetOrg;
        }

        public Long getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(Long payAmount) {
            this.payAmount = payAmount;
        }

        public CardInfo getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }

        public String getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(String exchangeRate) {
            this.exchangeRate = exchangeRate;
        }

        public String getPayCurrency() {
            return payCurrency;
        }

        public void setPayCurrency(String payCurrency) {
            this.payCurrency = payCurrency;
        }

        public String getPaymentTokenID() {
            return paymentTokenID;
        }

        public void setPaymentTokenID(String paymentTokenID) {
            this.paymentTokenID = paymentTokenID;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public void setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
        }

    }
    /**
     * 嵌套对象
     */
    public static final class CardInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 卡号，当paymentMethodType为CARD时掩码返回
         */
        private String cardIdentifierNo;

        /**
         * avs结果
         */
        private String avsResult;

        /**
         * 持卡人姓名，掩码返回。
         */
        private String cardHolderName;

        /**
         * 卡类型，DEBIT、CREDIT等。
         */
        private String cardType;

        /**
         * 3ds结果
         */
        private ThreeDSResult threeDSResult;

        /**
         * 卡的所有卡组织，双标卡会返回两个。
         */
        private List<String> totalCardOrg;

        /**
         * 发卡国家
         */
        private String country;

        /**
         * 绑卡支付场景下，用于支付的授权ID，默认有效期为卡有效期，可通过removePaymentToken接口置为无效。
         */
        private String paymentTokenID;

        /**
         * 卡信息来源。`CARD`、`APPLEPAY`、`GOOGLEPAY_PAN`、`GOOGLEPAY_CRYPTOGRAM`、`NETWORK_TOKEN`
         */
        private String source;

        /**
         * 卡性质。`PAN`为真实卡；`NETWORK_TOKEN`为虚拟卡，如APPLEPAY。
         */
        private String type;

        /**
         * 卡组织，只有交易成功且用户选择卡组织支付时才返回。
         */
        private String cardOrg;

        /**
         * 卡有效月。
         */
        private String cardExpirationMonth;

        /**
         * 卡有效年。
         */
        private String cardExpirationYear;

        /**
         * 卡姓名，当paymentMethodType为CARD时掩码返回
         */
        private String cardIdentifierName;

        /**
         * 卡号，掩码返回。
         */
        private String cardNumber;

        /**
         * 真实卡号后四位。
         */
        private String cardLast4;

        /**
         * 卡bin号。
         */
        private String cardBinNo;

        public String getCardIdentifierNo() {
            return cardIdentifierNo;
        }

        public void setCardIdentifierNo(String cardIdentifierNo) {
            this.cardIdentifierNo = cardIdentifierNo;
        }

        public String getAvsResult() {
            return avsResult;
        }

        public void setAvsResult(String avsResult) {
            this.avsResult = avsResult;
        }

        public String getCardHolderName() {
            return cardHolderName;
        }

        public void setCardHolderName(String cardHolderName) {
            this.cardHolderName = cardHolderName;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public ThreeDSResult getThreeDSResult() {
            return threeDSResult;
        }

        public void setThreeDSResult(ThreeDSResult threeDSResult) {
            this.threeDSResult = threeDSResult;
        }

        public List<String> getTotalCardOrg() {
            return totalCardOrg;
        }

        public void setTotalCardOrg(List<String> totalCardOrg) {
            this.totalCardOrg = totalCardOrg;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPaymentTokenID() {
            return paymentTokenID;
        }

        public void setPaymentTokenID(String paymentTokenID) {
            this.paymentTokenID = paymentTokenID;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCardOrg() {
            return cardOrg;
        }

        public void setCardOrg(String cardOrg) {
            this.cardOrg = cardOrg;
        }

        public String getCardExpirationMonth() {
            return cardExpirationMonth;
        }

        public void setCardExpirationMonth(String cardExpirationMonth) {
            this.cardExpirationMonth = cardExpirationMonth;
        }

        public String getCardExpirationYear() {
            return cardExpirationYear;
        }

        public void setCardExpirationYear(String cardExpirationYear) {
            this.cardExpirationYear = cardExpirationYear;
        }

        public String getCardIdentifierName() {
            return cardIdentifierName;
        }

        public void setCardIdentifierName(String cardIdentifierName) {
            this.cardIdentifierName = cardIdentifierName;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getCardLast4() {
            return cardLast4;
        }

        public void setCardLast4(String cardLast4) {
            this.cardLast4 = cardLast4;
        }

        public String getCardBinNo() {
            return cardBinNo;
        }

        public void setCardBinNo(String cardBinNo) {
            this.cardBinNo = cardBinNo;
        }

    }
    /**
     * 嵌套对象
     */
    public static final class ThreeDSResult implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * Cardholder Authentication Verification Value (CAVV) Authentication Verification Value (AVV) Universal Cardholder Authentication Field (UCAF)
         */
        private String cavv;

        /**
         * 身份验证结果标识	
         */
        private String xid;

        /**
         * the Directory Server (DS)分配的唯一标识	
         */
        private String dsTransactionId;

        /**
         * Electronic Commerce Indicator (ECI). Possible Values: 02 or 05 - Fully Authenticated Transaction 01 or 06 - Attempted Authentication Transaction 00 or 07 - Non 3-D Secure Transaction Mastercard - 02, 01, 00 Visa - 05, 06, 07
         */
        private String eci;

        /**
         * 3ds版本 1.0.2, 2.1.0, 2.2.0
         */
        private String threeDSVersion;

        /**
         * Status of Authentication eligibility. Y - Yes, Bank is participating in 3-D Secure protocol and will return the ACSUrl N - No, Bank is not participating in 3-D Secure protocol U - Unavailable, The DS or ACS is not available for authentication at the time of the request B - Bypass, Merchant authentication rule is triggered to bypass authentication in this use case. (3DS Flex premium only)
         */
        private String enrolled;

        /**
         * Transactions status result identifier. Y - Successful Authentication N - Failed Authentication U - Unable to Complete Authentication A - Successful Attempts Transaction R - Authentication Rejected (Merchant must not submit for authorisation)
         */
        private String authenticationStatus;

        public String getCavv() {
            return cavv;
        }

        public void setCavv(String cavv) {
            this.cavv = cavv;
        }

        public String getXid() {
            return xid;
        }

        public void setXid(String xid) {
            this.xid = xid;
        }

        public String getDsTransactionId() {
            return dsTransactionId;
        }

        public void setDsTransactionId(String dsTransactionId) {
            this.dsTransactionId = dsTransactionId;
        }

        public String getEci() {
            return eci;
        }

        public void setEci(String eci) {
            this.eci = eci;
        }

        public String getThreeDSVersion() {
            return threeDSVersion;
        }

        public void setThreeDSVersion(String threeDSVersion) {
            this.threeDSVersion = threeDSVersion;
        }

        public String getEnrolled() {
            return enrolled;
        }

        public void setEnrolled(String enrolled) {
            this.enrolled = enrolled;
        }

        public String getAuthenticationStatus() {
            return authenticationStatus;
        }

        public void setAuthenticationStatus(String authenticationStatus) {
            this.authenticationStatus = authenticationStatus;
        }

    }
}

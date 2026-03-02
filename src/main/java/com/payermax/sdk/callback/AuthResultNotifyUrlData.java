package com.payermax.sdk.callback;

import java.io.Serializable;
import java.util.List;

/**
 * 授权结果通知 - Data 数据
 **/
public class AuthResultNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户支付的国家代码，大写字母	
      **/
    private String country;

    /**
     * 费用信息，支付成功且存在费用时才返回
      **/
    private Fees fees;

    /**
     * 渠道订单号
      **/
    private String channelNo;

    /**
     * 完成时间，utc+0时区
      **/
    private String completeTime;

    /**
     * 三方单号
      **/
    private String thirdChannelNo;

    /**
     * 商户自定义附加数据，回调中原样返回	
      **/
    private String reference;

    /**
     * 商户传入的订单金额，金额的单位为元	
      **/
    private Long totalAmount;

    /**
     * VA单号
      **/
    private String paymentCode;

    /**
     * 商户订单号	
      **/
    private String outTradeNo;

    /**
     * 授权类型:FINAL_AUTH
      **/
    private String authorizationType;

    /**
     * PayerMax交易流水号	
      **/
    private String tradeToken;

    /**
     * 标价币种
      **/
    private String currency;

    /**
     * 请款模式：MANUAL
      **/
    private String captureMode;

    /**
     * 支付信息
      **/
    private List<PaymentDetails> paymentDetails;

    /**
     * 交易状态：SUCCESS-支付成功，FAILED -支付失败，CLOSED-关单
      **/
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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(String authorizationType) {
        this.authorizationType = authorizationType;
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

    public String getCaptureMode() {
        return captureMode;
    }

    public void setCaptureMode(String captureMode) {
        this.captureMode = captureMode;
    }

    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 嵌套对象
      **/
    public static final class Fees implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 商户费用
          **/
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
      **/
    public static final class MerFee implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 费用金额
          **/
        private String amount;

        /**
         * 费用币种
          **/
        private String currency;

        /**
         * 发票地址，打开地址可预览发票
          **/
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
      **/
    public static final class PaymentDetails implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 目标机构，用户支付选择的目标机构，只有交易成功才会返回用户支付所选择的目标机构；支付方式为CARD的时候详见卡信息
          **/
        private String targetOrg;

        /**
         * 卡信息
          **/
        private CardInfo cardInfo;

        /**
         * 绑卡支付场景下，用于支付的授权ID，默认有效期为卡有效期，可通过removePaymentToken接口置为无效。
          **/
        private String paymentTokenID;

        /**
         * 支付方式类型，用户支付选择的支付方式，只有交易成功才会返回用户支付所选择的支付方式
          **/
        private String paymentMethodType;

        public String getTargetOrg() {
            return targetOrg;
        }

        public void setTargetOrg(String targetOrg) {
            this.targetOrg = targetOrg;
        }

        public CardInfo getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
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
      **/
    public static final class CardInfo implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 卡组织，当paymentMethod为CARD时返回，只有交易成功且用户选择卡组织支付时才返回
          **/
        private String cardOrg;

        /**
         * 发卡国家
          **/
        private String country;

        /**
         * 卡号，当paymentMethod为CARD时掩码返回
          **/
        private String cardIdentifierNo;

        /**
         * 3ds结果	
          **/
        private ThreeDSResult threeDSResult;

        /**
         * 卡姓名，当paymentMethod为CARD时掩码返回
          **/
        private String cardIdentifierName;

        /**
         * 绑卡支付场景下，用于支付的授权ID，默认有效期为卡有效期，可通过removePaymentToken接口置为无效。
          **/
        private String paymentTokenID;

        public String getCardOrg() {
            return cardOrg;
        }

        public void setCardOrg(String cardOrg) {
            this.cardOrg = cardOrg;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCardIdentifierNo() {
            return cardIdentifierNo;
        }

        public void setCardIdentifierNo(String cardIdentifierNo) {
            this.cardIdentifierNo = cardIdentifierNo;
        }

        public ThreeDSResult getThreeDSResult() {
            return threeDSResult;
        }

        public void setThreeDSResult(ThreeDSResult threeDSResult) {
            this.threeDSResult = threeDSResult;
        }

        public String getCardIdentifierName() {
            return cardIdentifierName;
        }

        public void setCardIdentifierName(String cardIdentifierName) {
            this.cardIdentifierName = cardIdentifierName;
        }

        public String getPaymentTokenID() {
            return paymentTokenID;
        }

        public void setPaymentTokenID(String paymentTokenID) {
            this.paymentTokenID = paymentTokenID;
        }

    }
    /**
     * 嵌套对象
      **/
    public static final class ThreeDSResult implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * Cardholder Authentication Verification Value (CAVV) Authentication Verification Value (AVV) Universal Cardholder Authentication Field (UCAF)
          **/
        private String cavv;

        /**
         * 身份验证结果标识	
          **/
        private String xid;

        /**
         * the Directory Server (DS)分配的唯一标识	
          **/
        private String dsTransactionId;

        /**
         * Electronic Commerce Indicator (ECI). Possible Values: 02 or 05 - Fully Authenticated Transaction 01 or 06 - Attempted Authentication Transaction 00 or 07 - Non 3-D Secure Transaction Mastercard - 02, 01, 00 Visa - 05, 06, 07
          **/
        private String eci;

        /**
         * 3ds版本 1.0.2, 2.1.0, 2.2.0
          **/
        private String threeDSVersion;

        /**
         * Status of Authentication eligibility. Y - Yes, Bank is participating in 3-D Secure protocol and will return the ACSUrl N - No, Bank is not participating in 3-D Secure protocol U - Unavailable, The DS or ACS is not available for authentication at the time of the request B - Bypass, Merchant authentication rule is triggered to bypass authentication in this use case. (3DS Flex premium only)
          **/
        private String enrolled;

        /**
         * Transactions status result identifier. Y - Successful Authentication N - Failed Authentication U - Unable to Complete Authentication A - Successful Attempts Transaction R - Authentication Rejected (Merchant must not submit for authorisation)
          **/
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

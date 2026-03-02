package com.payermax.sdk.callback;

import java.io.Serializable;
import java.util.List;

/**
 * 支付链接更新回调 - Data 数据
 **/
public class PayLinkResultNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ACTIVE、EXPIRED	
      **/
    private String linkStatus;

    /**
     * 商户传入的订单金额，金额的单位为元。 除以下国家外，按照各国币种支持的小数点位上送 注意：巴林、科威特、约旦、阿曼、突尼斯，本币只支持两位小数； 印尼、中国台湾、韩国、越南、智利、巴基斯坦、哥伦比亚、日本、冰岛、巴拉圭，本币不支持带小数金额。
      **/
    private String totalAmount;

    /**
     * 国家代码，大写字母，如果所传的国家代码与币种不匹配，则以货币代码对应的地区展示收银台。如指定了支付方式，则国家必须上送，参见交易支持国家/地区与币种
      **/
    private String country;

    /**
     * 链接单的交易详情结构体，只会返回成功的支付详情。
      **/
    private List<PayByLinkInfo> payByLinkInfo;

    /**
     * PMmax链接唯一单号	
      **/
    private String linkId;

    /**
     * 链接描述，不展示给用户，用于商户备注
      **/
    private String linkDescription;

    /**
     * PayByLink QRcode url	
      **/
    private String qrCodeUrl;

    /**
     * PayByLink url	
      **/
    private String linkUrl;

    /**
     * 币种代码，大写字母，参见交易支持国家/地区与币种
      **/
    private String currency;

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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<PayByLinkInfo> getPayByLinkInfo() {
        return payByLinkInfo;
    }

    public void setPayByLinkInfo(List<PayByLinkInfo> payByLinkInfo) {
        this.payByLinkInfo = payByLinkInfo;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    /**
     * 数组元素
      **/
    public static final class PayByLinkInfo implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 交易成功时间，仅当交易状态为成功时，返回该时间	
          **/
        private String completeAt;

        /**
         * 每笔交易订单的唯一标识，当链接没有被打开时，该字段为空
          **/
        private String outTradeNo;

        /**
         * 支付方式信息，只有交易成功会返回支付方式	
          **/
        private List<PaymentDetails> paymentDetails;

        /**
         * 交易状态：SUCCESS、PENDING、CLOSE	
          **/
        private String status;

        public String getCompleteAt() {
            return completeAt;
        }

        public void setCompleteAt(String completeAt) {
            this.completeAt = completeAt;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
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

    }
    /**
     * 数组元素
      **/
    public static final class PaymentDetails implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 目标机构，用户支付所选择的目标机构，只有交易成功才会返回用户支付所选择的目标机构	
          **/
        private String targetOrg;

        /**
         * 卡信息	
          **/
        private CardInfo cardInfo;

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
         * 发卡国家
          **/
        private String country;

        /**
         * 卡号，当paymentMethodType为CARD时掩码返回	
          **/
        private String cardIdentifierNo;

        /**
         * 持卡人姓名，掩码返回。
          **/
        private String cardHolderName;

        /**
         * 卡类型，DEBIT、CREDIT等。
          **/
        private String cardType;

        /**
         * 卡的所有卡组织，双标卡会返回两个。
          **/
        private List<String> totalCardOrg;

        /**
         * 卡信息来源。CARD、`APPLEPAY`、`GOOGLEPAY_PAN`、`GOOGLEPAY_CRYPTOGRAM`、`NETWORK_TOKEN`
          **/
        private String source;

        /**
         * 卡性质。`PAN`为真实卡；`NETWORK_TOKEN`为虚拟卡，如APPLEPAY。
          **/
        private String type;

        /**
         * 卡组织，当paymentMethodType为CARD时返回，只有交易成功且用户选择卡组织支付时才返回	
          **/
        private String cardOrg;

        /**
         * 卡有效月。
          **/
        private String cardExpirationMonth;

        /**
         * 卡有效年。
          **/
        private String cardExpirationYear;

        /**
         * 卡号，掩码返回。
          **/
        private String cardNumber;

        /**
         * 真实卡号后四位。
          **/
        private String cardLast4;

        /**
         * 卡bin号。
          **/
        private String cardBinNo;

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

        public List<String> getTotalCardOrg() {
            return totalCardOrg;
        }

        public void setTotalCardOrg(List<String> totalCardOrg) {
            this.totalCardOrg = totalCardOrg;
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
}

package com.payermax.sdk.callback;

import java.io.Serializable;

/**
 * 争议异步通知 - Data 数据
 **/
public class ChargeBaclNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 争议原因描述，示例：Late Presentment
      **/
    private String reasonMessage;

    /**
     * 案件冻结手续费，按照各国币种支持的小数点位返回，示例：10.00
      **/
    private String fee;

    /**
     * 渠道订单号，示例：TPC776377168137542977644013024
      **/
    private String channelOrderNo;

    /**
     * 案件批次号，批量调单时生成	，示例：P20210702104937
      **/
    private String batchId;

    /**
     * 用户号，示例：ZNW3e
      **/
    private String outUserId;

    /**
     * 交易创建时间，示例：2022-01-22T10:00:00.500+08:00
      **/
    private String tradeCreateTime;

    /**
     * 案件应冻金额，对应原始交易订单应冻结金额，按照各国币种支持的小数点位返回，示例：15.00
      **/
    private String originTradeAmount;

    /**
     * 案件编号，示例：O20230427121409328170746570
      **/
    private String caseId;

    /**
     * 商户订单号，示例：20181112112606266846
      **/
    private String outTradeNo;

    /**
     * 案件应冻币种，对应原始交易订单应冻结币种，示例：INR
      **/
    private String originTradeCurrency;

    /**
     * 案件实际冻结币种，示例：INR
      **/
    private String currency;

    /**
     * PayerMax交易流水号，示例：T2023081604639602348121
      **/
    private String tradeToken;

    /**
     * 争议原因编码，示例：4842
      **/
    private String reasonCode;

    /**
     * 交易国家，示例：IN
      **/
    private String tradeCountry;

    /**
     * 回复到期日，商户需在到期日前提交举证材料，示例：2022-01-22
      **/
    private String expirationDate;

    /**
     * 案件实际冻结支付金额，按照各国币种支持的小数点位返回，示例：15.00
      **/
    private String amount;

    /**
     * 调单发起日，示例：2022-01-22
      **/
    private String retrievalDate;

    /**
     * 支付完成时间，示例：2022-01-22T10:00:00.500+08:00
      **/
    private String payFinishTime;

    /**
     * 案件结果 商户胜诉：WIN，商户败诉：FAIL，示例：WIN
      **/
    private String caseResult;

    /**
     * 交易币种，示例：INR
      **/
    private String tradeCurrency;

    /**
     * 支付卡组，示例：VISA
      **/
    private String cardOrg;

    /**
     * 消费信息，示例：游戏币充值
      **/
    private String productDesc;

    /**
     * 目标机构，示例：OVO
      **/
    private String targetOrg;

    /**
     * 案件实际冻结总金额，实际冻结金额+实际冻结手续费，按照各国币种支持的小数点位返回，示例：25.00
      **/
    private String totalAmount;

    /**
     * 交易金额，示例：10.00
      **/
    private String tradeAmount;

    /**
     * 支付方式类型，示例：WALLET
      **/
    private String paymentMethodType;

    /**
     * 案件状态，参考选项如下：DISPUTE_INQUIRY：调单待反馈,等待商户反馈并回复举证材料；DISPUTE_RECEIVED：举证材料已接收，仅在回调版本1.5以上返回；DISPUTE_END：调单完成发卡行审核申诉并作出判定；CASE_CLOSED：已结案；CASE_CANCELL：案件已取消，仅在回调版本1.5以上返回。注意：小概率会发生二次拒付，同一个outTradeNo可能会二次回调，请正常接收处理。
      **/
    private String status;

    public String getReasonMessage() {
        return reasonMessage;
    }

    public void setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getOutUserId() {
        return outUserId;
    }

    public void setOutUserId(String outUserId) {
        this.outUserId = outUserId;
    }

    public String getTradeCreateTime() {
        return tradeCreateTime;
    }

    public void setTradeCreateTime(String tradeCreateTime) {
        this.tradeCreateTime = tradeCreateTime;
    }

    public String getOriginTradeAmount() {
        return originTradeAmount;
    }

    public void setOriginTradeAmount(String originTradeAmount) {
        this.originTradeAmount = originTradeAmount;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOriginTradeCurrency() {
        return originTradeCurrency;
    }

    public void setOriginTradeCurrency(String originTradeCurrency) {
        this.originTradeCurrency = originTradeCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getTradeCountry() {
        return tradeCountry;
    }

    public void setTradeCountry(String tradeCountry) {
        this.tradeCountry = tradeCountry;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRetrievalDate() {
        return retrievalDate;
    }

    public void setRetrievalDate(String retrievalDate) {
        this.retrievalDate = retrievalDate;
    }

    public String getPayFinishTime() {
        return payFinishTime;
    }

    public void setPayFinishTime(String payFinishTime) {
        this.payFinishTime = payFinishTime;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public String getCardOrg() {
        return cardOrg;
    }

    public void setCardOrg(String cardOrg) {
        this.cardOrg = cardOrg;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getTargetOrg() {
        return targetOrg;
    }

    public void setTargetOrg(String targetOrg) {
        this.targetOrg = targetOrg;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

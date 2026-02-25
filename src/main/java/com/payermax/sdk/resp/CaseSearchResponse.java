package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 案件查询 - 响应
 **/
public class CaseSearchResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 案件实际冻结支付金额，按照各国币种支持的小数点位返回，示例：15.00
     */
    private String amount;

    /**
     * 商户调单发起日,格式：yyyy-MM-dd，示例：2022-01-22
     */
    private String retrievalDate;

    /**
     * 案件冻结手续费，按照各国币种支持的小数点位返回，示例：10.00
     */
    private String fee;

    /**
     * 案件结果，商户胜诉：WIN，商户败诉：FAIL
     */
    private String caseResult;

    /**
     * 案件批次号，示例：P20210702104937
     */
    private String batchId;

    /**
     * 用户号，示例：ZNW3e
     */
    private String outUserId;

    /**
     * 交易创建时间 格式：yyyy-MM-dd’T’HH:mm:ss.SSSXXX，示例：2022-01-22T10:00:00.500+08:00
     */
    private String tradeCreateTime;

    /**
     * 案件实际冻结总金额，实际冻结金额+实际冻结手续费，按照各国币种支持的小数点位返回，示例：25.00
     */
    private String totalAmount;

    /**
     * 案件应冻金额，对应原始交易订单应冻结金额，按照各国币种支持的小数点位返回，示例：15.00
     */
    private String originTradeAmount;

    /**
     * 案件编号，示例：O20230427054733964285071978
     */
    private String caseId;

    /**
     * 商户交易订单号，示例：20181112112606266846
     */
    private String outTradeNo;

    /**
     * 案件应冻币种，对应原始交易订单应冻结币种，示例：INR
     */
    private String originTradeCurrency;

    /**
     * 案件实际冻结币种，示例：INR
     */
    private String currency;

    /**
     * PayerMax交易流水号，示例：T2023081604639602348121
     */
    private String tradeToken;

    /**
     * [案件状态](https://docs.payermax.com/doc-center/receipt/chargeback/response-code.html)
     */
    private String status;

    /**
     * 回复到期日，商户需在到期日前提交举证材料 格式：yyyy-MM-dd，示例：2022-01-22
     */
    private String expirationDate;

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

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}

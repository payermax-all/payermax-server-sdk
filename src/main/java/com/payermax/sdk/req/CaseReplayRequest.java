package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.CaseReplayResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 案件回复	
 *
 * API 路径: /aggregate-pay/api/gateway/caseReplay
 * 请求方法: POST
 **/
public class CaseReplayRequest extends BaseRequest<CaseReplayResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 案件编号，单笔调单回复时必填，批量调单回复时必须为空，示例：O20211118090801
     */
    private String caseId;

    /**
     * 案件批次号，批量调单回复时必填,单笔调单回复时必须为空，示例：P20210702104937
     */
    private String batchId;

    /**
     * 用户号，示例：ZNW3e
     */
    private String outUserId;

    /**
     * 回复内容信息
     */
    private String responseContent;

    /**
     * 文件列表里的每个文件的文件地址请以`文件名.扩展名`结尾，不包含中文和特殊符号，文件类型支持 PNG、JPG、ZIP、DOC、XLS、PDF，推荐以案件编号作为文件名便于后续追溯管理。完整URL示例：["http://xxx/O20211118090801.ZIP", "http://xxx/O20211118090802.PDF"]。
     */
    private List<String> representmentFile;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
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

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public List<String> getRepresentmentFile() {
        return representmentFile;
    }

    public void setRepresentmentFile(List<String> representmentFile) {
        this.representmentFile = representmentFile;
    }

    @Override
    protected String getApiName() {
        return "caseReplay";
    }
}

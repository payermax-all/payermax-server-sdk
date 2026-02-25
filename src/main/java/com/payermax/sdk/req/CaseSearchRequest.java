package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.CaseSearchResponse;
import java.io.Serializable;

/**
 * 案件查询
 *
 * API 路径: /aggregate-pay/api/gateway/caseSearch
 * 请求方法: POST
 **/
public class CaseSearchRequest extends BaseRequest<CaseSearchResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 案件编号，示例：O20211118090801
     */
    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Override
    protected String getApiName() {
        return "caseSearch";
    }
}

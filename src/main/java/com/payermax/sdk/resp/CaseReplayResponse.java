package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * 案件回复	 - 响应
 **/
public class CaseReplayResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 处理成功案件编号
     */
    private String successCaseIds;

    /**
     * 处理失败案件编号
     */
    private String failCaseIds;

    public String getSuccessCaseIds() {
        return successCaseIds;
    }

    public void setSuccessCaseIds(String successCaseIds) {
        this.successCaseIds = successCaseIds;
    }

    public String getFailCaseIds() {
        return failCaseIds;
    }

    public void setFailCaseIds(String failCaseIds) {
        this.failCaseIds = failCaseIds;
    }

}

package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.QueryAuthorizedAccountResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 账户授权关系查询
 * 查询商户号下的业务产品大类授权的资金账号
 *
 * API 路径: /aggregate-pay/api/gateway/queryAuthorizedAccount
 * 请求方法: POST
 **/
public class QueryAuthorizedAccountRequest extends BaseRequest<QueryAuthorizedAccountResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务产品大类列表
     */
    private List<String> productTypeList;

    public List<String> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<String> productTypeList) {
        this.productTypeList = productTypeList;
    }

    @Override
    protected String getApiName() {
        return "queryAuthorizedAccount";
    }
}

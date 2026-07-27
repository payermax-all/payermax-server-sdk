package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.FundsAccountQueryResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 资金账户信息查询
 * 查询会员下的资金账号详情信息.支持指定账号和不指定账号查询会员下全部两种方式
 *
 * API 路径: /aggregate-pay/api/gateway/fundsAccountQuery
 * 请求方法: POST
 **/
public class FundsAccountQueryRequest extends BaseRequest<FundsAccountQueryResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资金账号列表
     */
    private List<String> fundsAccountNoList;

    public List<String> getFundsAccountNoList() {
        return fundsAccountNoList;
    }

    public void setFundsAccountNoList(List<String> fundsAccountNoList) {
        this.fundsAccountNoList = fundsAccountNoList;
    }

    @Override
    protected String getApiName() {
        return "fundsAccountQuery";
    }
}

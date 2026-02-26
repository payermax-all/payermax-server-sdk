package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.AddOrDelRiskNameListResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 添加或删除风控名单
 *
 * API 路径: /aggregate-pay/api/gateway/addOrDelRiskNameList
 * 请求方法: POST
 **/
public class AddOrDelRiskNameListRequest extends BaseRequest<AddOrDelRiskNameListResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 固定  BLACK 
     */
    private String nameType;

    /**
     * 长度 &lt;=128 唯一标识商户的一笔请求，不能重复
     */
    private String requestId;

    /**
     * ADD：添加  DELETE：删除 （重复添加会覆盖原名单）
     */
    private String operateType;

    /**
     * 长度&lt;=2000
     */
    private List<NameList> nameList;

    /**
     * 长度 &lt;=128
     */
    private String remark;

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public List<NameList> getNameList() {
        return nameList;
    }

    public void setNameList(List<NameList> nameList) {
        this.nameList = nameList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected String getApiName() {
        return "addOrDelRiskNameList";
    }
    /**
     * 数组元素
     */
    public static final class NameList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * DAY：1天 WEEK： 7天 MONTH ：30天 HALFYEAR：180天 YEAR： 365天 FOREVER： 永久
         */
        private String expireType;

        /**
         * 长度&lt;=128 名单类型为NEG0001时 示例：123456-4321  名单类型为NEG0005时，国家代码，大写字母，参见交易支持国家/地区与币种
         */
        private String value;

        /**
         * NEG0001：卡号前6后4掩码 NEG0002：用户号黑名单 NEG0003：IP黑名单  NEG0004：卡BIN黑名单 NEG0005：卡BIN国家黑名单
         */
        private String key;

        public String getExpireType() {
            return expireType;
        }

        public void setExpireType(String expireType) {
            this.expireType = expireType;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

    }

}

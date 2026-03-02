package com.payermax.sdk.callback;

import java.io.Serializable;
import java.util.List;

/**
 * Rfi通知 - Data 数据
 **/
public class RfiNotifyUrlData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * RFI 唯一标识编号
      **/
    private String rfiNo;

    /**
     * 截止时间，符合rfc3339规范，格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX 时间需要在当前时间两分钟内	
      **/
    private String expireTime;

    /**
     * RFI关联材料列表
      **/
    private List<MaterialList> materialList;

    /**
     * RFI备注
      **/
    private String remark;

    /**
     * 业务类型  收单业务：RECEIPT、本地银行收款:VA_PAYMENT、出款业务: PAYMENT 示例：PAYMENT 
      **/
    private String businessType;

    /**
     * RFI关联订单号
      **/
    private List<String> relateOrderId;

    /**
     * RFI状态 PASS: 通过 REJECT:驳回 CLOSE: 拒绝 REVIEW: 待审核
      **/
    private String status;

    public String getRfiNo() {
        return rfiNo;
    }

    public void setRfiNo(String rfiNo) {
        this.rfiNo = rfiNo;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public List<MaterialList> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<MaterialList> materialList) {
        this.materialList = materialList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public List<String> getRelateOrderId() {
        return relateOrderId;
    }

    public void setRelateOrderId(List<String> relateOrderId) {
        this.relateOrderId = relateOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 数组元素
      **/
    public static final class MaterialList implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 补充材料名称 示例：ID
          **/
        private String fieldName;

        /**
         * 材料类型 String：字符串 file：文件（链接地址）
          **/
        private String fieldType;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldType() {
            return fieldType;
        }

        public void setFieldType(String fieldType) {
            this.fieldType = fieldType;
        }

    }
}

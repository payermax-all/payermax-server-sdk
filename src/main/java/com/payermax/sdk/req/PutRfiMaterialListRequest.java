package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.PutRfiMaterialListResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 补充Rfi材料接口
 *
 * API 路径: /aggregate-pay/api/gateway/putRfiMaterialList
 * 请求方法: POST
 **/
public class PutRfiMaterialListRequest extends BaseRequest<PutRfiMaterialListResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Rfi编码
     */
    private String rfiNo;

    /**
     * RFI关联材料信息列表
     */
    private List<MaterialList> materialList;

    public String getRfiNo() {
        return rfiNo;
    }

    public void setRfiNo(String rfiNo) {
        this.rfiNo = rfiNo;
    }

    public List<MaterialList> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<MaterialList> materialList) {
        this.materialList = materialList;
    }

    @Override
    protected String getApiName() {
        return "putRfiMaterialList";
    }
    /**
     * 数组元素
     */
    public static final class MaterialList implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 补充材料名称
         */
        private String fieldName;

        /**
         * 材料类型为文件，描述文件路径类型,不传默认值HTTP
         */
        private String filePathType;

        /**
         * 材料值，HTTP的形式为文件全路径http://xx/xxx.zip；SFTP的形式为文件存储的路径 /risk/rfi/xxx
         */
        private String fieldValue;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFilePathType() {
            return filePathType;
        }

        public void setFilePathType(String filePathType) {
            this.filePathType = filePathType;
        }

        public String getFieldValue() {
            return fieldValue;
        }

        public void setFieldValue(String fieldValue) {
            this.fieldValue = fieldValue;
        }

    }

}

package com.payermax.sdk.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 出款要素校验 - 响应
 **/
public class PaymentFieldValidationResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通过校验的字段集合
     */
    private List<ValidationPassedFields> validationPassedFields;

    /**
     * 忽略校验的字段集合
     */
    private List<IgnoredFields> ignoredFields;

    /**
     * 校验结果码，PASS：没有校验失败的字段，PARAMS_INVALID：存在校验失败的字段
     */
    private String validationCode;

    /**
     * 校验失败的字段集合
     */
    private List<ValidationFailedFields> validationFailedFields;

    public List<ValidationPassedFields> getValidationPassedFields() {
        return validationPassedFields;
    }

    public void setValidationPassedFields(List<ValidationPassedFields> validationPassedFields) {
        this.validationPassedFields = validationPassedFields;
    }

    public List<IgnoredFields> getIgnoredFields() {
        return ignoredFields;
    }

    public void setIgnoredFields(List<IgnoredFields> ignoredFields) {
        this.ignoredFields = ignoredFields;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public List<ValidationFailedFields> getValidationFailedFields() {
        return validationFailedFields;
    }

    public void setValidationFailedFields(List<ValidationFailedFields> validationFailedFields) {
        this.validationFailedFields = validationFailedFields;
    }

    /**
     * 数组元素
     */
    public static final class ValidationPassedFields implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 通过校验的字段路径
         */
        private String field;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

    }
    /**
     * 数组元素
     */
    public static final class IgnoredFields implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 忽略校验的字段路径
         */
        private String field;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

    }
    /**
     * 数组元素
     */
    public static final class ValidationFailedFields implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 校验失败的字段路径
         */
        private String field;

        /**
         * 校验失败原因
         */
        private String errorMsg;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

    }
}

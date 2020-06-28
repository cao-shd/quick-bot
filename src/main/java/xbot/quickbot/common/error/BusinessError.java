package xbot.quickbot.common.error;

/**
 * 业务错误对象
 */
public enum BusinessError implements CommonError {

    SYSTEM_ERROR(100001, "系统错误"),
    ACCESS_DENIED(100002, "权限不足"),
    PARAMETER_VALIDATION_ERROR(20000, "参数类型错误"),
    USER_NOT_EXISTS(20100, "用户不存在");

    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 错误消息
     */
    private String errorMsg;

    BusinessError(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }
}

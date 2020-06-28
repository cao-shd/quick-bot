package xbot.quickbot.common.exception;

import xbot.quickbot.common.error.CommonError;

/**
 * 业务异常对象
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    /**
     * 用于直接接收 BusinessError 构造异常
     *
     * @param commonError
     */
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    /**
     * 用于直接接收自定义 errorMsg 方式构造异常
     *
     * @param commonError
     */
    public BusinessException(CommonError commonError, String errorMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrorMsg(errorMsg);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.commonError.setErrorMsg(errorMsg);
        return this;
    }
}

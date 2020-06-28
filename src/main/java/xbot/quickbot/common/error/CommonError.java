package xbot.quickbot.common.error;

/**
 * 通用错误对象
 */
public interface CommonError {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    int getErrorCode();

    /**
     * 获取错误消息
     *
     * @return 错误消息
     */
    String getErrorMsg();

    /**
     * 自定义错误消息
     *
     * @param errorMsg 错误消息
     * @return 错误对象
     */
    CommonError setErrorMsg(String errorMsg);
}

package xbot.quickbot.common.base;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import xbot.quickbot.common.error.BusinessError;
import xbot.quickbot.common.exception.BusinessException;
import xbot.quickbot.common.response.CommonResult;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    /**
     * 基础异常处理类
     *
     * @param request   request
     * @param exception exception
     * @return 通用的返回类型
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonResult handlerException(HttpServletRequest request, Exception exception) {
        Map<String, Object> errorMap = new HashMap<>();

        if (exception instanceof BusinessException) {
            // 如果发生了业务异常 构造业务异常返回对象
            BusinessException businessException = (BusinessException) exception;
            errorMap.put("errorCode", businessException.getErrorCode());
            errorMap.put("errorMsg", businessException.getErrorMsg());
        } else if (exception instanceof AccessDeniedException) {
            // 权限原因无法访问
            errorMap.put("errorCode", BusinessError.ACCESS_DENIED.getErrorCode());
            errorMap.put("errorMsg", BusinessError.ACCESS_DENIED.getErrorMsg());
        } else if (exception instanceof TypeMismatchException) {
            // 请求参数错误
            errorMap.put("errorCode", BusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode());
            errorMap.put("errorMsg", BusinessError.PARAMETER_VALIDATION_ERROR.getErrorMsg());
        } else {
            // 如果发生了不可预知的异常 构造系统异常返回对象
            errorMap.put("errorCode", BusinessError.SYSTEM_ERROR.getErrorCode());
            errorMap.put("errorMsg", BusinessError.SYSTEM_ERROR.getErrorMsg());
        }

        // 返回通用的返回类型
        return CommonResult.build(errorMap, CommonResult.FAIL);
    }
}

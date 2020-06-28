package xbot.quickbot.common.response;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import xbot.quickbot.common.view.BaseView;

/**
 * 通用返回对象
 */
@Data
public class CommonResult {

    /**
     * 响应状态 成功
     */
    public static String SUCCESS = "success";

    /**
     * 响应状态 失败
     */
    public static String FAIL = "fail";

    /**
     * 响应状态 success: 成功 fail: 失败
     */
    @JsonView(BaseView.class)
    private String status;

    /**
     * 响应数据
     */
    @JsonView(BaseView.class)
    private Object data;

    /**
     * 构建通用返回对象
     *
     * @param data   响应结果对象
     * @param status 响应状态
     * @return 响应结果对象
     */
    public static CommonResult build(Object data, String status) {
        CommonResult commonResult = new CommonResult();
        commonResult.setStatus(status);
        commonResult.setData(data);
        return commonResult;
    }

    /**
     * 构建通用返回对象
     *
     * @param result 响应数据
     * @return 响应结果对象
     */
    public static CommonResult build(Object result) {
        return CommonResult.build(result, SUCCESS);
    }
}

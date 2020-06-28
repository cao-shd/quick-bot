package xbot.quickbot.security.controller;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import xbot.quickbot.common.base.BaseController;
import xbot.quickbot.common.base.PageModel;
import xbot.quickbot.common.response.CommonResult;
import xbot.quickbot.common.view.DeleteView;
import xbot.quickbot.common.view.FormView;
import xbot.quickbot.common.view.TableView;
import xbot.quickbot.common.view.ViewType;
import xbot.quickbot.security.model.UserModel;
import xbot.quickbot.security.service.IUserService;

/**
 * <p>
 * 管理员实体 前端控制器
 * </p>
 *
 * @author cao.shd
 * @since 2020-06-27
 */
@RestController
@RequestMapping("api/v1/public/security")
public class UserController extends BaseController {

    @Autowired
    IUserService userService;

    @GetMapping("/user/{id}")
    @JsonView(TableView.class)
//    @PreAuthorize("hasAuthority('p1')")
    public CommonResult get(@PathVariable("id") Integer id) {
        return CommonResult.build(userService.getById(id));
    }

    @GetMapping("/users")
    @JsonView(TableView.class)
//    @PreAuthorize("hasAuthority('p2')")
    public CommonResult list(@ApiIgnore PageModel<UserModel> page, UserModel userModel) {
        String view = userModel.getView();
        if (ViewType.TABLE_VIEW.equals(view)) {
            return CommonResult.build(userService.page(page, userModel));
        }
        return CommonResult.build(userService.list(userModel));
    }

    @PostMapping("/user")
    @JsonView(FormView.class)
    public CommonResult add(UserModel userModel) {
        userModel.setCreateBy("caoshd");
        userModel.setUpdateBy("caoshd");
        userModel.setPassword(BCrypt.hashpw(userModel.getPassword(),BCrypt.gensalt()));
        return CommonResult.build(userService.save(userModel));
    }

    @DeleteMapping("/user/{id}")
    @JsonView(DeleteView.class)
    public CommonResult delete(@PathVariable("id") Integer id) {
        return CommonResult.build(userService.removeById(id));
    }

    @PutMapping("/user")
    @JsonView(FormView.class)
    public CommonResult update(UserModel userModel) {
        return CommonResult.build(userService.updateById(userModel));
    }

}

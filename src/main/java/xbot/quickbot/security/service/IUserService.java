package xbot.quickbot.security.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import xbot.quickbot.common.base.PageModel;
import xbot.quickbot.security.entity.User;
import xbot.quickbot.security.model.UserModel;

import java.util.List;

/**
 * <p>
 * 管理员实体 服务类
 * </p>
 *
 * @author cao.shd
 * @since 2020-06-27
 */
public interface IUserService extends IService<User> {
    /**
     * 通过用户名取得用户
     *
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     * 用户条件查询
     *
     * @param userModel 查询条件
     * @return 用户列表
     */
    List<User> list(UserModel userModel);

    PageModel page(PageModel page, UserModel userModel);
}

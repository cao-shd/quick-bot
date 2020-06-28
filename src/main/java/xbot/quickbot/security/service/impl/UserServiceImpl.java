package xbot.quickbot.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xbot.quickbot.common.base.PageModel;
import xbot.quickbot.security.entity.User;
import xbot.quickbot.security.mapper.UserMapper;
import xbot.quickbot.security.model.UserModel;
import xbot.quickbot.security.service.IUserService;

import java.util.List;

/**
 * 管理员实体 服务实现类
 *
 * @author cao.shd
 * @since 2020-06-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getByUsername(String username) {
        return getOne(new QueryWrapper<>(new User().setUsername(username)));
    }

    @Override
    public List<User> list(UserModel userModel) {
        return list(buildQueryWrapper(userModel));
    }

    @Override
    public PageModel page(PageModel page, UserModel userModel) {
        return page(page, buildQueryWrapper(userModel));
    }

    private QueryWrapper<User> buildQueryWrapper(UserModel userModel) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(userModel);

        if (userModel != null) {
            if (userModel.getUsername() != null) {
                queryWrapper.like("username", userModel.getUsername());
                userModel.setUsername(null);
            }
            if (userModel.getPhone() != null) {
                queryWrapper.like("phone", userModel.getPhone());
                userModel.setPhone(null);
            }
            if (userModel.getEmail() != null) {
                queryWrapper.like("email", userModel.getEmail());
                userModel.setEmail(null);
            }
        }

        return queryWrapper;
    }


}

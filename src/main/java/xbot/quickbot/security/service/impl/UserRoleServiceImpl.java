package xbot.quickbot.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xbot.quickbot.security.entity.UserRole;
import xbot.quickbot.security.mapper.UserRoleMapper;
import xbot.quickbot.security.service.IUserRoleService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cao.shd
 * @since 2020-06-27
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public List<UserRole> listByUserId(Integer userId) {
        if (userId == null) {
            return new ArrayList<>();
        }
        return list(new QueryWrapper<>(new UserRole().setUserId(userId)));
    }

    @Override
    public List<Integer> listRoleIdsByUserId(Integer userId) {
        List<Integer> roleIds = new ArrayList<>();

        if (userId == null) {
            return roleIds;
        }

        listByUserId(userId).forEach(ur -> roleIds.add(ur.getRoleId()));
        return roleIds;
    }
}

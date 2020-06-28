package xbot.quickbot.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xbot.quickbot.security.entity.RolePermission;
import xbot.quickbot.security.mapper.RolePermissionMapper;
import xbot.quickbot.security.service.IRolePermissionService;

import java.util.ArrayList;
import java.util.Collection;
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
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

    @Override
    public List<RolePermission> listByRoleId(Integer roleId) {
        if (roleId == null) {
            return new ArrayList<>();
        }
        return list(new QueryWrapper<>(new RolePermission().setRoleId(roleId)));
    }

    @Override
    public List<Integer> listPermissionIdsByRoleId(Integer roleId) {
        List<Integer> permissionIds = new ArrayList<>();

        if (roleId == null) {
            return permissionIds;
        }

        listByRoleId(roleId).forEach(rp -> permissionIds.add(rp.getPermissionId()));
        return permissionIds;
    }

    @Override
    public List<Integer> listPermissionIdsByRoleIds(Collection<Integer> roleIds) {

        List<Integer> permissionIds = new ArrayList<>();

        if (roleIds == null || roleIds.isEmpty()) {
            return permissionIds;
        }

        roleIds.forEach(rid -> permissionIds.addAll(listPermissionIdsByRoleId(rid)));
        return permissionIds;
    }

}

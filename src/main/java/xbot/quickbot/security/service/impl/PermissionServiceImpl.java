package xbot.quickbot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xbot.quickbot.security.entity.Permission;
import xbot.quickbot.security.mapper.PermissionMapper;
import xbot.quickbot.security.service.IPermissionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 权限实体 服务实现类
 * </p>
 *
 * @author cao.shd
 * @since 2020-06-27
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public List<String> listPermissionCodesByRoleIds(Collection<Integer> permissionIds) {
        List<String> permissionCodes = new ArrayList<>();
        if (permissionIds == null || permissionIds.isEmpty()) {
            return permissionCodes;
        }
        Collection<Permission> permissions = listByIds(permissionIds);

        if (permissions == null || permissions.isEmpty()) {
            return permissionCodes;
        }

        permissions.forEach(p -> permissionCodes.add(p.getCode()));
        return permissionCodes;
    }

}

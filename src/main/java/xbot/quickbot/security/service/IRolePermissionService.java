package xbot.quickbot.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xbot.quickbot.security.entity.RolePermission;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cao.shd
 * @since 2020-06-27
 */
public interface IRolePermissionService extends IService<RolePermission> {
    /**
     * 通过角色Id取得角色权限
     *
     * @param roleId
     * @return
     */
    List<RolePermission> listByRoleId(Integer roleId);

    /**
     * 通过用户Id取得用户角色Id集合
     *
     * @param roleId
     * @return
     */
    List<Integer> listPermissionIdsByRoleId(Integer roleId);

    /**
     * 通过用户Id取得用户角色Id集合
     *
     * @param roleIds
     * @return
     */
    List<Integer> listPermissionIdsByRoleIds(Collection<Integer> roleIds);

}

package xbot.quickbot.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xbot.quickbot.security.entity.Permission;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 权限实体 服务类
 * </p>
 *
 * @author cao.shd
 * @since 2020-06-27
 */
public interface IPermissionService extends IService<Permission> {
    /**
     * 通过权限Id集合取得权限码集合
     *
     * @param permissionIds
     * @return
     */
    List<String> listPermissionCodesByRoleIds(Collection<Integer> permissionIds);
}

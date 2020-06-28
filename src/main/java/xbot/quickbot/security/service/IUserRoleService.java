package xbot.quickbot.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xbot.quickbot.security.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cao.shd
 * @since 2020-06-27
 */
public interface IUserRoleService extends IService<UserRole> {
    /**
     * 通过用户Id取得用户角色权限
     *
     * @param userId
     * @return
     */
    List<UserRole> listByUserId(Integer userId);

    /**
     * 通过用户Id取得用户角色Id集合
     *
     * @param userId
     * @return
     */
    List<Integer> listRoleIdsByUserId(Integer userId);
}

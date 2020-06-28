package xbot.quickbot.security.service;

import java.util.List;

public interface ISecurityService {
    /**
     * 通过用户Id查询用户权限
     *
     * @param userId 用户Id
     * @return 用户权限
     */
    List<String> listPermissionCodesByUserId(int userId);
}

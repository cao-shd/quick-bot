package xbot.quickbot.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xbot.quickbot.security.entity.User;
import xbot.quickbot.security.service.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityServiceImpl implements ISecurityService, UserDetailsService {

    @Autowired
    IUserService userService;

    @Autowired
    IPermissionService permissionService;

    @Autowired
    IUserRoleService userRoleService;

    @Autowired
    IRolePermissionService rolePermissionService;


    @Override
    public List<String> listPermissionCodesByUserId(int userId) {

        List<Integer> roleIds = userRoleService.listRoleIdsByUserId(userId);

        if (roleIds == null || roleIds.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> permissions = rolePermissionService.listPermissionIdsByRoleIds(roleIds);

        if (permissions == null || permissions.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> permissionCodes = permissionService.listPermissionCodesByRoleIds(permissions);
        return permissionCodes;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<String> permissionCodes = listPermissionCodesByUserId(user.getId());
        String[] authorities = new String[permissionCodes.size()];
        permissionCodes.toArray(authorities);

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();

        return userDetails;
    }
}

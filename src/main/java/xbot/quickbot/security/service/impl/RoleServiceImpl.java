package xbot.quickbot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xbot.quickbot.security.entity.Role;
import xbot.quickbot.security.mapper.RoleMapper;
import xbot.quickbot.security.service.IRoleService;

/**
 * <p>
 * 角色实体 服务实现类
 * </p>
 *
 * @author cao.shd
 * @since 2020-06-27
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}

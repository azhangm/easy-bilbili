package nuc.zm.server.service.impl;

import nuc.zm.server.domain.auth.AuthRoleElementOption;
import nuc.zm.server.dto.AuthRoleUserDto;
import nuc.zm.server.dto.UserAuthorities;
import nuc.zm.server.service.AuthElementOptionService;
import nuc.zm.server.service.AuthRoleService;
import nuc.zm.server.service.UserAuthService;
import nuc.zm.server.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserAuthServiceImpl implements UserAuthService {

private static final Logger LOG = LoggerFactory.getLogger(UserAuthServiceImpl.class);
    // 用户绑定了哪些角色
    @Resource
    private UserRoleService userRoleService;

    // 角色有哪些权限
    @Resource
    private AuthElementOptionService authElementOptionService;

    @Override
    public UserAuthorities getUserAuthorities(Long currentUserId) {
        List<AuthRoleUserDto> userRoleList = userRoleService.getRolesByUserId(currentUserId);
        // 获取角色 Id
        Set<Long> roleIdSet = userRoleList.stream().map(AuthRoleUserDto::getRoleId).collect(Collectors.toSet());
        // 使用角色查询相关权限
        List<AuthRoleElementOption> authRoleElementOptions = authElementOptionService.UserElementAuthorities(roleIdSet);
        UserAuthorities userAuthorities = new UserAuthorities();
        userAuthorities.setRoleElementOptions(authRoleElementOptions);
        LOG.info("authRoleElementOptions{}",authRoleElementOptions);
        return userAuthorities;
    }
}

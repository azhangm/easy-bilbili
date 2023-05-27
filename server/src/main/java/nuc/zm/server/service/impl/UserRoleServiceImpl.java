package nuc.zm.server.service.impl;

import nuc.zm.server.domain.auth.AuthRole;
import nuc.zm.server.domain.auth.AuthRoleExample;
import nuc.zm.server.domain.auth.AuthRoleUser;
import nuc.zm.server.domain.auth.AuthRoleUserExample;
import nuc.zm.server.dto.AuthRoleUserDto;
import nuc.zm.server.mapper.AuthRoleMapper;
import nuc.zm.server.mapper.AuthRoleUserMapper;
import nuc.zm.server.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private static final Logger LOG = LoggerFactory.getLogger(UserRoleServiceImpl.class);
    @Resource
    private AuthRoleUserMapper authRoleUserMapper;

    @Resource
    private AuthRoleMapper authRoleMapper;


    @Override
    public List<AuthRoleUserDto> getRolesByUserId(Long currentUserId) {
        List<AuthRoleUserDto> rolesByUserId = authRoleUserMapper.getRolesByUserId(currentUserId);
        LOG.info("roleByUserId {}" , rolesByUserId);
        return rolesByUserId;
    }

    @Override
    public AuthRole getRoleByCode(String userLv0) {
        AuthRoleExample authRoleExample = new AuthRoleExample();
        AuthRoleExample.Criteria criteria = authRoleExample.createCriteria();
        criteria.andCodeEqualTo(userLv0);
        List<AuthRole> authRoles = authRoleMapper.selectByExample(authRoleExample);
        return authRoles.get(0);
    }

    @Override
    public void addUserRole(AuthRoleUser authRoleUser) {
        authRoleUser.setCreateTime(new Date());
        authRoleUserMapper.insert(authRoleUser);
    }
}

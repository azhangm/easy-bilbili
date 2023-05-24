package nuc.zm.server.service.impl;

import nuc.zm.server.domain.auth.AuthRoleUser;
import nuc.zm.server.domain.auth.AuthRoleUserExample;
import nuc.zm.server.dto.AuthRoleUserDto;
import nuc.zm.server.mapper.AuthRoleUserMapper;
import nuc.zm.server.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private static final Logger LOG = LoggerFactory.getLogger(UserRoleServiceImpl.class);
    @Resource
    private AuthRoleUserMapper authRoleUserMapper;



    @Override
    public List<AuthRoleUserDto> getRolesByUserId(Long currentUserId) {
        List<AuthRoleUserDto> rolesByUserId = authRoleUserMapper.getRolesByUserId(currentUserId);
        LOG.info("roleByUserId {}" , rolesByUserId);
        return rolesByUserId;
    }
}

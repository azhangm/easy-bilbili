package nuc.zm.server.service.impl;

import nuc.zm.server.domain.auth.AuthRoleElementOption;
import nuc.zm.server.mapper.AuthElementOptionMapper;
import nuc.zm.server.mapper.AuthRoleElementOptionMapper;
import nuc.zm.server.service.AuthElementOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * impl auth元素选择服务
 * 获取角色相关的元素操作权限
 * @author zm
 * @date 2023/05/24
 */
@Service
public class AuthElementOptionServiceImpl implements AuthElementOptionService {

    private static final Logger LOG = LoggerFactory.getLogger(AuthElementOptionServiceImpl.class);

    @Resource
    private AuthRoleElementOptionMapper mapper;
    @Override
    public List<AuthRoleElementOption> UserElementAuthorities(Set<Long> roleIdSet){
        List<AuthRoleElementOption> userElementAuthorities = mapper.getUserElementAuthorities(roleIdSet);
        LOG.info("authRoleElementOption{}" , userElementAuthorities);
        LOG.info("auth-type{}",AuthRoleElementOption.class);
        LOG.info("roleIdSet{}",roleIdSet);
        return userElementAuthorities;
    }

}

package nuc.zm.server.commons.aspect;


import nuc.zm.server.commons.annotation.ApiLimited;
import nuc.zm.server.commons.support.UserSupport;
import nuc.zm.server.dto.AuthRoleUserDto;
import nuc.zm.server.exception.ConditionException;
import nuc.zm.server.exception.ExceptionEnum;
import nuc.zm.server.service.UserRoleService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Aspect
@Component
public class ControllerLimited {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerLimited.class);
    // 获取用户对象
    @Resource
    private UserSupport userSupport;

    @Resource
    private UserRoleService userRoleService;
    // 定义切点
    @Pointcut("@annotation(nuc.zm.server.commons.annotation.ApiLimited)")
    public void check(){}

    // 定义通知 进入 API 时，先进行权限验证
    @Before("check() && @annotation(api)")
    public void before(JoinPoint joinPoint, ApiLimited api){
        // 获取当前用户id
        Long currentUserId = userSupport.getCurrentUserId();
        // 获取当前 用户对应的角色对象
        List<AuthRoleUserDto> roleList = userRoleService.getRolesByUserId(currentUserId);
        String[] userRoleCodes = api.userRoleCode();
        Set<String> annotationRoleSet = Arrays.stream(userRoleCodes).collect(Collectors.toSet());
        Set<String> userRoleSet = roleList.stream().map(AuthRoleUserDto::getRoleName).collect(Collectors.toSet());
        // 若包含 限制访问的角色 即 集合大小 > 0 则 限制该用户访问
        userRoleSet.retainAll(annotationRoleSet);
        if (userRoleSet.size() > 0) throw new ConditionException(ExceptionEnum.AUTH_LACK);
    }
}

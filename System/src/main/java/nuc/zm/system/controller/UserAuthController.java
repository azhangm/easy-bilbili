package nuc.zm.system.controller;

import nuc.zm.server.dto.UserAuthorities;
import nuc.zm.server.service.UserAuthService;
import nuc.zm.server.vo.ResponseVo;
import nuc.zm.system.controller.support.UserSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Resource
    private UserSupport userSupport;

    @Resource
    private UserAuthService userAuthService;

    /**
     * 获取用户权限列表
     *
     * @return {@link ResponseVo}<{@link UserAuthorities}>
     */
    @GetMapping("/user-authorities")
    public ResponseVo<UserAuthorities> getUserAuthorities() {
        Long currentUserId = userSupport.getCurrentUserId();
        UserAuthorities userAuthorities = userAuthService.getUserAuthorities(currentUserId);
        return ResponseVo.ok(userAuthorities);
    }
}

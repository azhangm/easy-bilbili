package nuc.zm.system.controller;


 import nuc.zm.server.commons.ApiLimited;
 import nuc.zm.server.commons.LimitedConstant;
 import nuc.zm.server.domain.UserInfo;
 import nuc.zm.server.dto.LoginDto;
 import nuc.zm.server.dto.UserDto;
 import nuc.zm.server.dto.UserInfoDto;
 import nuc.zm.server.service.UserService;
 import nuc.zm.server.vo.ResponseVo;
 import nuc.zm.system.controller.support.UserSupport;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.web.multipart.MultipartFile;

 import javax.annotation.Resource;
 import java.security.NoSuchAlgorithmException;
 import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserSupport userSupport;

    @Resource
    private UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public ResponseVo<String> register(@RequestBody UserDto user){
        LOG.info("user:{}" , user);
        userService.register(user);
        return ResponseVo.ok();
    }


    @PostMapping("/login")
    public ResponseVo<String> login(@RequestBody LoginDto loginDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String token = userService.login(loginDto);
        return new ResponseVo<>(token);
    }

    @PostMapping("/ger-user-info")
    @ApiLimited(userRoleCode = LimitedConstant.USER_LV0)
    public ResponseVo<UserInfoDto> getUserInfo(){
        Long currentUserId = userSupport.getCurrentUserId();
        UserInfoDto userInfo = userService.getUserInfo(currentUserId);
        return ResponseVo.ok(userInfo);
    }

    @PutMapping("/update-user-info")
    public ResponseVo<String> updateUserInfo(@RequestBody UserInfoDto userInfo){
        Long currentUserId = userSupport.getCurrentUserId();
        userService.updateUserInfo(currentUserId,userInfo);
        return ResponseVo.ok();
    }
}

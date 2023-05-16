package nuc.zm.system.controller;


 import nuc.zm.server.dto.LoginDto;
 import nuc.zm.server.dto.UserDto;
 import nuc.zm.server.dto.UserInfoDto;
 import nuc.zm.server.service.UserService;
 import nuc.zm.server.vo.ResponseVo;
 import nuc.zm.system.controller.support.UserSupport;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

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
    public ResponseVo<UserInfoDto> getUserInfo(){
        Long currentUserId = userSupport.getCurrentUserId();
        UserInfoDto userInfo = userService.getUserInfo(currentUserId);
        return ResponseVo.ok(userInfo);
    }

}

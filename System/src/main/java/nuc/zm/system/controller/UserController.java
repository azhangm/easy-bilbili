package nuc.zm.system.controller;


 import nuc.zm.server.dto.LoginDto;
 import nuc.zm.server.dto.UserDto;
 import nuc.zm.server.service.UserService;
 import nuc.zm.server.vo.ResponseVo;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public ResponseVo<String> register(@RequestBody UserDto user){
        userService.register(user);
        return ResponseVo.ok();
    }


    @PostMapping("/login")
    public ResponseVo<String> login(@RequestBody LoginDto loginDto){
        String token = userService.login(loginDto);
        return new ResponseVo<>(token);
    }

}

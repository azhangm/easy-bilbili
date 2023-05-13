package nuc.zm.system.controller;

import nuc.zm.server.exception.ConditionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        if (true)
        throw new ConditionException(1,"测试全局异常");
        return "test_success";
    }
}

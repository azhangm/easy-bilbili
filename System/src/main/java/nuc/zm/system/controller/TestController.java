package nuc.zm.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/system")
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test_success";
    }
}

package nuc.zm.system;

import nuc.zm.server.domain.User;
import nuc.zm.server.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestUserMapper {
    @Resource
    private UserMapper mapper;

    @Test
    public void test(){
        User user = mapper.selectById(1658289406517317632L);
        System.out.println(user);
    }
}

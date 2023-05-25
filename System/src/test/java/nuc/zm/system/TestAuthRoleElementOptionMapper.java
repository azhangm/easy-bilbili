package nuc.zm.system;

import nuc.zm.server.domain.auth.AuthRoleElementOption;
import nuc.zm.server.mapper.AuthRoleElementOptionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
public class TestAuthRoleElementOptionMapper {

    @Resource
    private AuthRoleElementOptionMapper authRoleElementOptionMapper;


    @Test
    void test(){
        HashSet<Long> ids = new HashSet<>();
        ids.add(1L);
        List<AuthRoleElementOption> userElementAuthorities = authRoleElementOptionMapper.getUserElementAuthorities(ids);
        System.out.println(userElementAuthorities);
    }
}

package nuc.zm.system.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TestMapperTest {

    @Resource
    private TestMapper mapper;

    @Test
    void testInsert() {
        mapper.insert();
    }

    @Test
    void testSelectOne(){
        System.out.println(mapper.selectOne());
    }
}
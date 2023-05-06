package nuc.zm.server.mapper;

import nuc.zm.server.domain.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
    @Insert("insert into `test` values (1,'zm') ")
    void  insert();
    @Select("SELECT * from `test` where `id` = 1")
    Test selectOne();
}

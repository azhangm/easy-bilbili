package nuc.zm.server.mapper;


import nuc.zm.server.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPhone(String phone);

    User selectByUserName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
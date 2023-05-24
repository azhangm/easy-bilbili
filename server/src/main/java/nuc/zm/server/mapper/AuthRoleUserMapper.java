package nuc.zm.server.mapper;

import nuc.zm.server.domain.auth.AuthRoleUser;
import nuc.zm.server.domain.auth.AuthRoleUserExample;
import nuc.zm.server.dto.AuthRoleUserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthRoleUserMapper {
    long countByExample(AuthRoleUserExample example);

    int deleteByExample(AuthRoleUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthRoleUser record);

    int insertSelective(AuthRoleUser record);

    List<AuthRoleUser> selectByExample(AuthRoleUserExample example);

    AuthRoleUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthRoleUser record, @Param("example") AuthRoleUserExample example);

    int updateByExample(@Param("record") AuthRoleUser record, @Param("example") AuthRoleUserExample example);

    int updateByPrimaryKeySelective(AuthRoleUser record);

    int updateByPrimaryKey(AuthRoleUser record);

    List<AuthRoleUserDto> getRolesByUserId(Long currentUserId);
}
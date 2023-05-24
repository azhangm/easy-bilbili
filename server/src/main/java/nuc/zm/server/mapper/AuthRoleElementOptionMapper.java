package nuc.zm.server.mapper;

import nuc.zm.server.domain.auth.AuthRoleElementOption;
import nuc.zm.server.domain.auth.AuthRoleElementOptionExample;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Set;

public interface AuthRoleElementOptionMapper {
    long countByExample(AuthRoleElementOptionExample example);

    int deleteByExample(AuthRoleElementOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthRoleElementOption record);

    int insertSelective(AuthRoleElementOption record);

    List<AuthRoleElementOption> selectByExample(AuthRoleElementOptionExample example);

    AuthRoleElementOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthRoleElementOption record, @Param("example") AuthRoleElementOptionExample example);

    int updateByExample(@Param("record") AuthRoleElementOption record, @Param("example") AuthRoleElementOptionExample example);

    int updateByPrimaryKeySelective(AuthRoleElementOption record);

    int updateByPrimaryKey(AuthRoleElementOption record);

    List<AuthRoleElementOption> getUserElementAuthorities(Set<Long> roleIdSet);

}
package nuc.zm.server.mapper;

import nuc.zm.server.domain.auth.AuthElementOption;
import nuc.zm.server.domain.auth.AuthElementOptionExample;
import nuc.zm.server.domain.auth.AuthRoleElementOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface AuthElementOptionMapper {
    long countByExample(AuthElementOptionExample example);

    int deleteByExample(AuthElementOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthElementOption record);

    int insertSelective(AuthElementOption record);

    List<AuthElementOption> selectByExample(AuthElementOptionExample example);

    AuthElementOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthElementOption record, @Param("example") AuthElementOptionExample example);

    int updateByExample(@Param("record") AuthElementOption record, @Param("example") AuthElementOptionExample example);

    int updateByPrimaryKeySelective(AuthElementOption record);

    int updateByPrimaryKey(AuthElementOption record);

}
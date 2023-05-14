package nuc.zm.server.service.impl;

import com.mysql.cj.util.StringUtils;
import nuc.zm.server.commons.UserConstant;
import nuc.zm.server.domain.User;
import nuc.zm.server.domain.UserInfo;
import nuc.zm.server.dto.LoginDto;
import nuc.zm.server.dto.UserDto;
import nuc.zm.server.exception.ConditionException;
import nuc.zm.server.exception.ExceptionEnum;
import nuc.zm.server.mapper.UserMapper;
import nuc.zm.server.service.UserService;
import nuc.zm.server.util.JWTUtil;
import nuc.zm.server.util.MD5Util;
import nuc.zm.server.util.SnowFlackIdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    /**
     * 注册 使用手机号注册
     *
     * @param user 用户
     */
    @Override
    public void register(UserDto user){
        String username = user.getUsername();
        if (StringUtils.isNullOrEmpty(username)) {
            throw new ConditionException(ExceptionEnum.EMPTY_USERNAME);
        }
        if (userMapper.selectByUserName(username) != null)
            throw new ConditionException(ExceptionEnum.USERNAME_EXIST);
        String phone = user.getPhone();
        if (StringUtils.isNullOrEmpty(phone)){
            throw new ConditionException(ExceptionEnum.EMPTY_PHONE);
        }
        if (userMapper.selectByPhone(phone) != null)
            throw new ConditionException(ExceptionEnum.USED_PHONE);
        // 时间戳加密
        Date now = new Date();
        String salt = String.valueOf(now.getTime());
        user.setSalt(salt);
        String password = user.getPassword();
        String sign = MD5Util.sign(password, salt, "UTF-8");
        user.setPassword(sign);
        user.setCreateTime(now);
        user.setUpdateTime(now);
        User dbUser = new User();
        BeanUtils.copyProperties(user,dbUser.getClass());
        long id = SnowFlackIdUtils.getSnowFlackId();
        dbUser.setId(id);
        int insert = userMapper.insert(dbUser);
        if (insert == 0) throw new ConditionException(ExceptionEnum.REGISTER_FAILED);
        LOG.info("user{}",dbUser);
        LOG.info("ID{}",id);


        // 预设基本信息
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setUerid(id);
        userInfo.setNick(UserConstant.DEFAULT_NAME);
        userInfo.setGender(UserConstant.GENDER_MAN);
        userInfo.setSign(UserConstant.DEFAULT_SIGN);
    }


    /**
     * 登录
     * 支持 手机号、用户名
     * @param loginDto 登录dto
     * @return {@link String}
     */
    @Override
    public String login(LoginDto loginDto) {
        String username = loginDto.getUsername();
        if (StringUtils.isNullOrEmpty(username) )
            throw new ConditionException(ExceptionEnum.EMPTY_USERNAME);
        User user = userMapper.selectByUserName(username);
        if (user == null) throw new ConditionException(ExceptionEnum.NEED_REGISTER);
        String password = loginDto.getPassword();
        String salt = user.getSalt();
        String sign = MD5Util.sign(password, salt, "UTF-8");
        boolean verity = MD5Util.verity(password, salt, sign, "UTF-8");
        if (!verity) throw new ConditionException(ExceptionEnum.ERROR_PASSWORD);
        return JWTUtil.generatorToken(user.getId());
    }

}

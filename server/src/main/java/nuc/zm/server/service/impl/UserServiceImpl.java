package nuc.zm.server.service.impl;

import com.mysql.cj.util.StringUtils;
import nuc.zm.server.commons.UserConstant;
import nuc.zm.server.domain.User;
import nuc.zm.server.domain.UserInfo;
import nuc.zm.server.domain.UserInfoExample;
import nuc.zm.server.dto.LoginDto;
import nuc.zm.server.dto.UserDto;
import nuc.zm.server.dto.UserInfoDto;
import nuc.zm.server.exception.ConditionException;
import nuc.zm.server.exception.ExceptionEnum;
import nuc.zm.server.mapper.UserInfoMapper;
import nuc.zm.server.mapper.UserMapper;
import nuc.zm.server.service.UserAuthService;
import nuc.zm.server.service.UserService;
import nuc.zm.server.util.JWTUtil;
import nuc.zm.server.util.MD5Util;
import nuc.zm.server.util.SnowFlackIdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserAuthService userAuthService;
    /**
     * 注册 使用手机号注册
     * 必须包汉 用户名 手机号、
     * @param user 用户
     */
    @Override
    @Transactional
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
        String password = user.getPassword();
        if (StringUtils.isNullOrEmpty(password)) {
            throw new ConditionException(ExceptionEnum.EMPTY_PASSWD);
        }
        // 时间戳加密
        Date now = new Date();
        String salt = String.valueOf(now.getTime());
        user.setSalt(salt);
        String sign = MD5Util.sign(password, salt, "UTF-8");
        user.setPassword(sign);
        user.setCreateTime(now);
        user.setUpdateTime(now);
        User dbUser = new User();
        BeanUtils.copyProperties(user,dbUser);
        long id = SnowFlackIdUtils.getSnowFlackId();
        dbUser.setId(id);
        LOG.info("userDto:{}",user);
        LOG.info("DBUser:{}",dbUser);
        int insert = userMapper.insert(dbUser);
        if (insert == 0) throw new ConditionException(ExceptionEnum.REGISTER_FAILED);
        LOG.info("user{}",dbUser);
        LOG.info("ID{}",id);

        // 预设基本信息
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setUerid(id);
        userInfo.setNick(UserConstant.DEFAULT_NAME + UUID.randomUUID());
        userInfo.setGender(UserConstant.GENDER_MAN);
        userInfo.setSign(UserConstant.DEFAULT_SIGN);
        userInfo.setCreateTime(now);
        userInfo.setUpdateTime(now);
        LOG.info("预设信息:{}" , userInfo);
        userInfoMapper.insert(userInfo);

        userAuthService.addDefaultRole(id);
    }


    /**
     * 登录
     * 仅支持 用户名 登录
     * @param loginDto 登录dto
     * @return {@link String}
     */
    @Override
    public String login(LoginDto loginDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String username = loginDto.getUsername();
        if (StringUtils.isNullOrEmpty(username) )
            throw new ConditionException(ExceptionEnum.EMPTY_USERNAME);
        User user = userMapper.selectByUserName(username);
        if (user == null) throw new ConditionException(ExceptionEnum.NEED_REGISTER);
        String password = loginDto.getPassword();
        String salt = user.getSalt();
        String sign = user.getPassword();
        boolean verity = MD5Util.verity(password, salt, sign, "UTF-8");
        if (!verity) throw new ConditionException(ExceptionEnum.ERROR_PASSWORD);
        return JWTUtil.generatorToken(user.getId());
    }

    @Override
    public UserInfoDto getUserInfo(Long currentUserId) {
        User user = userMapper.selectById(currentUserId);
        Long id = user.getId();
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUeridEqualTo(id);
        UserInfo userInfo = userInfoMapper.selectByExample(userInfoExample).get(0);
        UserInfoDto userInfoDto = new UserInfoDto();
        BeanUtils.copyProperties(user,userInfoDto);
        BeanUtils.copyProperties(userInfo,userInfoDto);
        LOG.info("userInfoDto:{}",userInfoDto);
        LOG.info("userInfo:{}",userInfo);
        LOG.info("user:{}",user);
        return userInfoDto;
    }

    @Override
    public void updateUserInfo(Long currentUserId, UserInfoDto userInfo) {
        Date now = new Date();
        userInfo.setUpdateTime(now);
        String nick = userInfo.getNick();
        if (StringUtils.isNullOrEmpty(nick)) throw new ConditionException(ExceptionEnum.EMPTY_NICK);
        String gender = userInfo.getGender();
        if (StringUtils.isNullOrEmpty(gender)) throw new ConditionException(ExceptionEnum.EMPTY_GENDER);
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUeridEqualTo(currentUserId);
        UserInfo userInfo1 = userInfoMapper.selectByExample(userInfoExample).get(0);
        BeanUtils.copyProperties(userInfo,userInfo1);
        LOG.info("userInfo{}",userInfo1);
        userInfoMapper.updateByPrimaryKeySelective(userInfo1);
    }

}

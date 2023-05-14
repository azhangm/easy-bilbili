package nuc.zm.server.service;

import nuc.zm.server.dto.LoginDto;
import nuc.zm.server.dto.UserDto;
import nuc.zm.server.vo.ResponseVo;

public interface UserService {

    void register(UserDto user);

    String login(LoginDto loginDto);
}

package nuc.zm.server.service;

import nuc.zm.server.domain.auth.AuthRoleUser;
import nuc.zm.server.dto.AuthRoleUserDto;

import java.util.List;

public interface UserRoleService {
    List<AuthRoleUserDto> getRolesByUserId(Long currentUserId);
}

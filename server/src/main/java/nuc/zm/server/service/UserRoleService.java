package nuc.zm.server.service;

import nuc.zm.server.domain.auth.AuthRole;
import nuc.zm.server.domain.auth.AuthRoleUser;
import nuc.zm.server.dto.AuthRoleUserDto;

import java.util.List;

public interface UserRoleService {
    List<AuthRoleUserDto> getRolesByUserId(Long currentUserId);

    AuthRole getRoleByCode(String userLv0);

    void addUserRole(AuthRoleUser authRoleUser);
}

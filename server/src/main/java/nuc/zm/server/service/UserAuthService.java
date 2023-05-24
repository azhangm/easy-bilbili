package nuc.zm.server.service;

import nuc.zm.server.dto.UserAuthorities;

public interface UserAuthService {
    UserAuthorities getUserAuthorities(Long currentUserId);
}

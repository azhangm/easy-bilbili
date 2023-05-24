package nuc.zm.server.service;

import nuc.zm.server.domain.auth.AuthRoleElementOption;

import java.util.List;
import java.util.Set;

public interface AuthElementOptionService {
    List<AuthRoleElementOption> UserElementAuthorities(Set<Long> roleIdSet);
}

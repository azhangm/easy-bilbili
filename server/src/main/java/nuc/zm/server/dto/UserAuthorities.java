package nuc.zm.server.dto;

import nuc.zm.server.domain.auth.AuthRoleElementOption;

import java.util.List;

/**
 * 用户权限列表
 *
 * @author zm
 * @date 2023/05/21
 */
public class UserAuthorities {

    // 对页面元素进行控制的列表
    private List<AuthRoleElementOption> roleElementOptions;

    public List<AuthRoleElementOption> getRoleElementOptions() {
        return roleElementOptions;
    }

    public void setRoleElementOptions(List<AuthRoleElementOption> roleElementOptions) {
        this.roleElementOptions = roleElementOptions;
    }
}

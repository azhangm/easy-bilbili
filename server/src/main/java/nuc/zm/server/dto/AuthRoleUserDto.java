package nuc.zm.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AuthRoleUserDto {
    /**
     * 主键|id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 创建时间
     */

    private String roleName;

    private String roleCode;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public AuthRoleUserDto() {
    }

    public AuthRoleUserDto(Long id, Long userId, Long roleId, String roleName, String roleCode, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleCode = roleCode;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

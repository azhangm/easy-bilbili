package nuc.zm.server.domain.auth;


import java.io.Serializable;

/**
 * auth_role_element_option
 * @author 
 */
public class AuthRoleElementOption implements Serializable {
    /**
     * 主键|id
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
    进行联表操作
     */

    private AuthElementOption authElementOption;

    /**
     * 元素操作id
     */
    private Long elementId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public AuthElementOption getAuthElementOption() {
        return authElementOption;
    }

    public void setAuthElementOption(AuthElementOption authElementOption) {
        this.authElementOption = authElementOption;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AuthRoleElementOption other = (AuthRoleElementOption) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getElementId() == null ? other.getElementId() == null : this.getElementId().equals(other.getElementId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getElementId() == null) ? 0 : getElementId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", elementId=").append(elementId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", authElementOption=").append(authElementOption);
        sb.append("]");
        return sb.toString();
    }
}
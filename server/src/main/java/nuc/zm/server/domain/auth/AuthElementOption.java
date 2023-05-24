package nuc.zm.server.domain.auth;

import java.io.Serializable;
import java.util.Date;

/**
 * auth_element_option
 * @author 
 */
public class AuthElementOption implements Serializable {
    /**
     * 主键|id
     */
    private Long id;

    /**
     * 页面元素名称
     */
    private String elementName;

    /**
     * 标识名称的code,方便交互唯一标码
     */
    private String elementCode;

    /**
     * true 可点击、false 仅可见
     */
    private Boolean optType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public AuthElementOption() {
    }

    public AuthElementOption(Long id, String elementName, String elementCode, Boolean optType, Date createTime, Date updateTime) {
        this.id = id;
        this.elementName = elementName;
        this.elementCode = elementCode;
        this.optType = optType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    public Boolean getOptType() {
        return optType;
    }

    public void setOptType(Boolean optType) {
        this.optType = optType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        AuthElementOption other = (AuthElementOption) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getElementName() == null ? other.getElementName() == null : this.getElementName().equals(other.getElementName()))
            && (this.getElementCode() == null ? other.getElementCode() == null : this.getElementCode().equals(other.getElementCode()))
            && (this.getOptType() == null ? other.getOptType() == null : this.getOptType().equals(other.getOptType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getElementName() == null) ? 0 : getElementName().hashCode());
        result = prime * result + ((getElementCode() == null) ? 0 : getElementCode().hashCode());
        result = prime * result + ((getOptType() == null) ? 0 : getOptType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", elementName=").append(elementName);
        sb.append(", elementCode=").append(elementCode);
        sb.append(", optType=").append(optType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
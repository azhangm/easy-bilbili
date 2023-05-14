package nuc.zm.server.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 用户账号信息
 * @author 
 */
public class UserDto {
     /**
     * 主键|id
     */
    private Long id;
     /**
     * 用户名
     */
    private String username;
     /**
     * 手机号
     */
    private String phone;
     /**
     * 邮箱
     */
    private String email;
     /**
     * 用户密码
     */
    private String password;
     /**
     * 盐值
     */
    private String salt;
     /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
     /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getSalt() {
        return salt;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
}
package nuc.zm.server.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 用户账号信息
 */
public class UserInfoDto {
     /**
     * 昵称
     */
    private String nick;

     /**
     * 签名
     */
    private String sign;
     /**
     * 性别:男 1 女 0 未知 2
     */
    private String gender;
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

    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getNick() {
        return nick;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getSign() {
        return sign;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
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

    @Override
    public String toString() {
        return "UserInfoDto{" +
                " nick='" + nick + '\'' +
                ", sign='" + sign + '\'' +
                ", gender='" + gender + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
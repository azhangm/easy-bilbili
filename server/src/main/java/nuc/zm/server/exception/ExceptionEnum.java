package nuc.zm.server.exception;

/**
 * 全局异常枚举类
 * @description : 收集常见异常
 * @author zm
 * @date 2023/05/13
 */
public  enum ExceptionEnum {
    SYSTEM_FAIL(500,"系统异常")
    // 用户相关 1000x
    ,EXPIRE_TOKEN(10001,"token过期！")
    ,ILLEGAL_TOKEN(10002,"token非法！"),
    EMPTY_USERNAME(10003,"用户名不能为空")
    , EMPTY_PHONE(10004, "手机号不能为空")
    , USERNAME_EXIST(10005,"用户名已存在")
    , USED_PHONE(10006, "手机号已存在")
    , REGISTER_FAILED(10007,"注册失败，请稍后重试" )
    , NEED_REGISTER(10008,"请先注册在登陆！" )
    , ERROR_PASSWORD(10009,"密码错误")
    , EMPTY_PASSWD(10010,"密码不能为空！")
    , EMPTY_NICK(100011,"昵称不能为空")
    , EMPTY_GENDER(10012, "请告诉我性别~ 男 女 未知");
    private Integer  code;
    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

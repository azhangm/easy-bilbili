package nuc.zm.server.vo;

import nuc.zm.server.exception.ConditionException;
import nuc.zm.server.exception.ExceptionEnum;

/**
 * 统一返回对象
 *
 * @author zm
 * @date 2023/05/13
 */
public class ResponseVo <T>{

    private Integer code;

    private String msg;

    private T data;


    public ResponseVo(Integer code , String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseVo(T data) {
        this.data = data;
        msg = "success";
        code = 200;
    }

    public static ResponseVo<String> ok(){
        return new ResponseVo<>(null);
    }

    public static <T> ResponseVo<T> ok(T data){
        return new ResponseVo<>(data);
    }

    // 普通错误返回
    public static ResponseVo<String> fail(){
        return new ResponseVo<>(10001,"failed");
    }
    // 业务特定错误返回
    public static ResponseVo<String> fail(Integer code , String msg) {
        return new ResponseVo<>(code,msg);
    }

    public static ResponseVo<String> fail(ExceptionEnum e) {
        return new ResponseVo<>(e.getCode(),e.getMessage());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

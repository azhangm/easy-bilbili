package nuc.zm.server.exception;

/**
 * 条件异常
 * @description : 用于主动抛出异常返回给前端
 * @author zm
 * @date 2023/05/13
 */
public class ConditionException extends RuntimeException{

    private Integer code;

    public ConditionException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public ConditionException(ExceptionEnum e) {
        super(e.getMessage());
        this.code = e.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

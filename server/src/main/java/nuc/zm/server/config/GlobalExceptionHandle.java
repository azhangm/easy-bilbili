package nuc.zm.server.config;

import nuc.zm.server.exception.ConditionException;
import nuc.zm.server.exception.ExceptionEnum;
import nuc.zm.server.vo.ResponseVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author zm
 * @date 2023/05/13
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseVo<String> exceptionHandler(RuntimeException e){
        if (e instanceof ConditionException) {
            return ResponseVo.fail(((ConditionException) e).getCode(),e.getMessage());
        }
        // 系统异常
        return ResponseVo.fail(ExceptionEnum.SYSTEM_FAIL);
    }
}

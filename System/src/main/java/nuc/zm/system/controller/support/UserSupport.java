package nuc.zm.system.controller.support;

import nuc.zm.server.util.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户支持
 * @description ： 支撑 controller 运行的模块
 * @author zm
 * @date 2023/05/16
 */
@Component
public class UserSupport {

    public  Long getCurrentUserId() {
        // 拿到请求信息
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // 前端在请求的时候从 local storage 中拿到token 放到请求头中
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("token");
        return JWTUtil.verityToken(token);
    }
}

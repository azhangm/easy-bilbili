package nuc.zm.server.commons.support;

import nuc.zm.server.util.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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

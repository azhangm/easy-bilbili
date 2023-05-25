package nuc.zm.server.commons;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.TYPE})
// 在方法上的权限
@Target(ElementType.METHOD)
@Documented
@Component
public @interface ApiLimited {
     String[] userRoleCode() default {};


}



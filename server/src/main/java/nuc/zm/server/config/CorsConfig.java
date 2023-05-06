package nuc.zm.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 支持跨域
 *  当allowCredentials为真时，allowedOrigins不能包含特殊值 "*"，因为这不能在 "Access-Control-Allow-Origin "响应头中设置。
 *  要允许一组来源的凭证，请明确列出它们，或者考虑使用 "allowedOriginPatterns "来代替。
 * @author zm
 * @date 2023/05/06
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("allowedOriginPatterns")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}

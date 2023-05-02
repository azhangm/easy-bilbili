package nuc.zm.erueka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    private static final Logger LOG = LoggerFactory.getLogger(EurekaApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(EurekaApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        LOG.info("启动成功");
        LOG.info("eureka 地址 : \t http://127.0.0.1:{}",environment.getProperty("server.port"));

    }

}

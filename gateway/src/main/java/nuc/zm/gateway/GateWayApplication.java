package nuc.zm.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication {
    private static final Logger LOG = LoggerFactory.getLogger(GateWayApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GateWayApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        LOG.info("启动成功");
        LOG.info("gateway 地址 : \t http://127.0.0.1:{}",environment.getProperty("server.port"));
    }
}

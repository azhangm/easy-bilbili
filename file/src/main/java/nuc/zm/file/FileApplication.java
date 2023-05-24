package nuc.zm.file;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("nuc.zm.server.mapper")
@ComponentScan("nuc.zm")
public class  FileApplication {
    private static final Logger LOG = LoggerFactory.getLogger(FileApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FileApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        LOG.info("启动成功");
        LOG.info("file 地址 : \t http://127.0.0.1:{}",environment.getProperty("server.port"));

    }
}

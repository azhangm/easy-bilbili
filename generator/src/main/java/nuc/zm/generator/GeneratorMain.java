package nuc.zm.generator;

import freemarker.template.TemplateException;
import nuc.zm.generator.util.FreemarkerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GeneratorMain {
    private static final String  toServicePath = "server/src/main/java/nuc/zm/server/service/";
    private static final String  toServiceImplPath = "server/src/main/java/nuc/zm/server/service/impl/";

    public static void main(String[] args) throws IOException, TemplateException {
        Map<String,String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String Domain = sc.next();
        String domain = sc.next();
        map.put("Domain",Domain);
        map.put("domain",domain);
        // 接口生成器
        FreemarkerUtils.initConfig("service.ftl");
        FreemarkerUtils.generator(toServicePath + Domain +  "Service.java" , map);
        FreemarkerUtils.initConfig("service_impl.ftl");
        // 实现类生成器
        FreemarkerUtils.generator(toServiceImplPath + Domain + "ServiceImpl.java",map);
    }
}

package nuc.zm.generator.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestUtil {
    private static String ftlPath = "generator/src/main/java/nuc/zm/generator/test";
    // 注意 这里一定要由 / 结尾 要不然生成的 文件名 为 testTest.java 噶
    private static String toPath = "generator/src/main/java/nuc/zm/generator/test/";

    public static void main(String[] args) throws IOException, TemplateException {
        // 读模板 这四步都读模板是固定写法
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 设置模板引擎的模板文件在的目录。
        configuration.setDirectoryForTemplateLoading(new File(ftlPath));
        // 设置对象包装器
        configuration.setObjectWrapper(Configuration.getDefaultObjectWrapper(Configuration.VERSION_2_3_32));
        // 读模板路径下的具体文件
        Template template = configuration.getTemplate("test.ftl");

        // 生成 Java文件
        FileWriter fileWriter = new FileWriter(toPath + "Test.java");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        template.process(null,writer);
        writer.flush();
        writer.close();
    }
}

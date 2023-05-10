package nuc.zm.generator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 代码生成器工具类
 * 模板引擎 free marker
 * @author zm
 * @date 2023/05/10
 */
public class FreemarkerUtils {
    private static final String ftlPath = "generator/src/main/java/nuc/zm/generator/ftl/";
    static Template template ;

    /**
     * 初始化配置
     *
     * @param ftlName ftl名字
     * @throws IOException ioexception
     */
    public static void initConfig(String ftlName) throws IOException {
        // 读模板 这四步都读模板是固定写法
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 设置模板引擎的模板文件在的目录。
        configuration.setDirectoryForTemplateLoading(new File(ftlPath));
        // 设置对象包装器
        configuration.setObjectWrapper(Configuration.getDefaultObjectWrapper(Configuration.VERSION_2_3_32));
        // 读模板路径下的具体文件
        template = configuration.getTemplate(ftlName);
    }

    /**
     * 发电机
     *
     * @param fileName 包含路径的文件名称
     * @throws IOException       IoException
     * @throws TemplateException 模板异常
     */
    public static void generator(String fileName) throws IOException, TemplateException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        template.process(null,writer);
        writer.flush();
        writer.close();
    }
}

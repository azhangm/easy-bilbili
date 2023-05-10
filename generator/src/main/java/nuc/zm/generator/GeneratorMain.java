package nuc.zm.generator;

import freemarker.template.TemplateException;
import nuc.zm.generator.util.FreemarkerUtils;

import java.io.IOException;

public class GeneratorMain {
    private static String toPath = "generator/src/main/java/nuc/zm/generator/test/";
    public static void main(String[] args) throws IOException, TemplateException {
        FreemarkerUtils.initConfig("test.ftl");
        FreemarkerUtils.generator(toPath +  "Test.java");
    }
}

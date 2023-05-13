package nuc.zm.generator;

import freemarker.template.TemplateException;
import nuc.zm.generator.util.DbField;
import nuc.zm.generator.util.DbUtils;
import nuc.zm.generator.util.FreemarkerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * @description : 支持表名于service 同名的 如有需要 可自行修改哦
 *
 * @author zm
 * @date 2023/05/13
 */
public class GeneratorMain {
    private static final String  toServicePath = "server/src/main/java/nuc/zm/server/service/";
    private static final String  toServiceImplPath = "server/src/main/java/nuc/zm/server/service/impl/";
    private static final String  TODTOPATH = "server/src/main/java/nuc/zm/server/dto/";

    public static void main(String[] args) throws IOException, TemplateException, SQLException, ClassNotFoundException {
        System.out.println("没有前缀表名的代码生成器");
        System.out.println("=========执行区=========");
        Map<String,Object> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入表名，开头大写");
        System.out.print("请输入: ");
        String Domain = sc.next();
        System.out.println("输入表名，开头小写");
        System.out.print("请输入: ");
        String domain = sc.next();
        map.put("Domain",Domain);
        map.put("domain",domain);
        List<DbField> fieldList = DbUtils.getAllFieldInfo(domain);
        String tableComment = DbUtils.getTableComment(domain);
        System.out.println("执行前" + fieldList);
        Set<String> set = getJavaTypes(fieldList);
        System.out.println("执行后" + fieldList);
        map.put("fieldList",fieldList);
        map.put("typeSet",set);
        map.put("tableComment",tableComment);
        // 接口生成器
        FreemarkerUtils.initConfig("service.ftl");
        FreemarkerUtils.generator(toServicePath + Domain +  "Service.java" , map);
        FreemarkerUtils.initConfig("service_impl.ftl");
        // 实现类生成器
        FreemarkerUtils.generator(toServiceImplPath + Domain + "ServiceImpl.java",map);

        FreemarkerUtils.initConfig("dto.ftl");
        FreemarkerUtils.generator(TODTOPATH + Domain + "Dto.java",map);
    }

    /**
     * 映射数据库类型为java类型,
     *
     * @param fieldList 字段列表
     * @return {@link Set}<{@link String}>
     */
    private static Set<String> getJavaTypes(List<DbField> fieldList) {
        Set<String> set = new HashSet<>();
        for (DbField dbField : fieldList) {
            if (dbField.getDbType().toUpperCase().contains("VARCHAR") || dbField.getDbType().toUpperCase().contains("CHAR") || dbField.getDbType().toUpperCase().contains("TEXT")) {
                dbField.setJavaType("String");
                set.add("String");
            }
            else if (dbField.getDbType().toUpperCase().contains("DATETIME")) {
                dbField.setJavaType("Date"); // 修复bug
                set.add("Date");
            }
            else if (dbField.getDbType().toUpperCase().contains("BIGINT")) {
                dbField.setJavaType("Long");
                set.add("Long");
            }
            else if (dbField.getDbType().toUpperCase().contains("DECIMAL")) {
                dbField.setJavaType("BigDecimal");
                set.add("BigDecimal");
            }
            else if (dbField.getDbType().contains("tinyint")) {
                dbField.setJavaType("boolean");
                set.add("boolean");
            }
            else if (dbField.getDbType().toUpperCase().contains("INT")) {
                dbField.setJavaType("Integer");
                set.add("Integer");
            }
            else {
                dbField.setJavaType("String");
                set.add("String");
            }
        }
        return set;
    }
}

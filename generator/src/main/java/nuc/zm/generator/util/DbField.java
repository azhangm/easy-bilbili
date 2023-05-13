package nuc.zm.generator.util;

/**
 * 数据库字段映射类
 *
 * @author zm
 * @date 2023/05/11
 */
public class DbField {
    private String name; // 数据库字段名
    private String nameHump; // 转为小驼峰
    private String nameBigHump; // 转为大驼峰
    private String nameCn; // 中文名 非中文 搁置即可
    private String dbType; // 数据库字段类型 ru bigint
    private String javaType; // java类型
    private String comment; // 字段备注

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameHump() {
        return nameHump;
    }

    public void setNameHump(String nameHump) {
        this.nameHump = nameHump;
    }

    public String getNameBigHump() {
        return nameBigHump;
    }

    public void setNameBigHump(String nameBigHump) {
        this.nameBigHump = nameBigHump;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "DbField{" +
                "name='" + name + '\'' +
                ", nameHump='" + nameHump + '\'' +
                ", nameBigHump='" + nameBigHump + '\'' +
                ", nameCn='" + nameCn + '\'' +
                ", dbType='" + dbType + '\'' +
                ", javaType='" + javaType + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}

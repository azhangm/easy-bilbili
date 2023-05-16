package nuc.zm.generator.util;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 数据库工具类
 * 获取数据库所有字段名 映射 为 java 类型
 *
 * @author zm
 * @date 2023/05/11
 */
public class DbUtils {

    public static final String jdbcProPath = "generator/src/main/resources/jdbc.properties";


    private static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(jdbcProPath));
        Properties properties = new Properties();
        properties.load(bufferedInputStream);
        String driver = (String) properties.get("jdbc.driver");
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String passwd = properties.getProperty("jdbc.passwd");
        Class.forName(driver);
        return DriverManager.getConnection(url, username, passwd);
    }

    /**
     * 得到表名 注释为表名
     *
     * @param tableName 表名
     * @return {@link String}
     * @throws SQLException           sqlexception异常
     * @throws IOException            ioexception
     * @throws ClassNotFoundException 类没有发现异常
     */
    public static String getTableComment(String tableName) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select table_comment from information_schema.TABLES where TABLE_NAME = '" + tableName + "'");
        if (rs != null) {
           while (rs.next()){
               String tableNameCn = rs.getString("table_comment");
               System.out.println("表的中文名称" + tableNameCn);
               close(connection,statement,rs);
               return tableNameCn;
           }
        }
        return null;
    }

    public static List<DbField> getAllFieldInfo(String tableName) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ArrayList<DbField> ans = new ArrayList<>();
        ResultSet rs = statement.executeQuery("show full columns from " + tableName );
        if (rs != null) {
            while (rs.next()) {
                String fieldName = rs.getString("field");
                String dBType = rs.getString("type");
                String comment = rs.getString("comment");
                DbField dbField = new DbField();
                dbField.setName(fieldName);
                dbField.setDbType(dBType);
                dbField.setComment(comment);
                if (comment.contains("|")) {
                    dbField.setNameCn(comment.substring(0,comment.indexOf("|")));
                }
                dbField.setNameHump(toNameHump(fieldName));
                dbField.setNameBigHump(toBigNameHump(fieldName));
                ans.add(dbField);
            }
        }
        return ans;
    }

    /**
     * 大名字驼峰
     * 规定列名 为 xx_xx
     * @param fieldName 字段名
     * @return {@link String}
     */
    private static String toBigNameHump(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            return "";
        }
        // 开头是否大写
        boolean toUpper = true;
        return connectStr(fieldName,toUpper);

    }

    private static String toNameHump(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            return "";
        }
        // 开头是否大写
        boolean toUpper = false;
        return connectStr(fieldName,toUpper);
    }

    private static void close(Connection con, Statement st, ResultSet rs) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String connectStr(String fieldName , boolean toUpper) {
        StringBuilder sb = new StringBuilder(fieldName.length());
        for (char ch : fieldName.toCharArray()) {
            if (ch == '_') {
                toUpper = true;
                continue;
            }
            sb.append(toUpper ? Character.toUpperCase(ch) : ch);
            toUpper = false;
        }
        return sb.toString();
    }

}

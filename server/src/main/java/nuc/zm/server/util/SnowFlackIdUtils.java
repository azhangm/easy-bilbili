package nuc.zm.server.util;


import cn.hutool.core.util.IdUtil;


/**
 * 雪花算法 工具类 封装 hutool 雪花算法
 *
 * @author zm
 * @date 2023/05/07
 */
public class SnowFlackIdUtils {

    private static long dataCenterID = 1L; // 数据中心
    private static long workId = 1L;

    public static long getSnowFlackId() {
        return IdUtil.getSnowflake(workId, dataCenterID).nextId();
    }

    public static String getSnowFlackIdStr() {
        return IdUtil.getSnowflake(workId, dataCenterID).nextIdStr();
    }


    public static void main(String[] args) {
        System.out.println(getSnowFlackId());
        System.out.println(getSnowFlackIdStr());
    }
}


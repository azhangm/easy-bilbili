package nuc.zm.server.util;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;

/**
 * md5 信息摘要算法加密工具类
 *
 * @author zm
 * @date 2023/05/14
 */
public class MD5Util {

    public static String sign(String text,String salt,String charset) {
        return DigestUtil.md5Hex(text + salt, charset);
    }

    public static boolean verity(String text,String salt,String sign,String charset){
        return DigestUtil.md5Hex(text + salt, charset).equals(sign);
    }

    public static void main(String[] args) {
        String sign = sign("12345", "213123", "UTF-8");
        System.out.println(verity("12345", "213123", sign, "UTF-8"));
    }
}
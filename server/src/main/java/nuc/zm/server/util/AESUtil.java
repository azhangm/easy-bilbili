package nuc.zm.server.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.nio.charset.Charset;

/**
 * 对称加密算法
 *
 * @author zm
 * @date 2023/05/14
 */
public class AESUtil {
    private static final byte[] key = {-90,-124,-23,-116,-27,-63,-100,48,126,117,91,-72,104,55,-11,-60};
    // 构建 对称加密对象 参数算法类型、key密钥
    private static final SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,key);

    /**
     * 加密
     *
     * @param text 文本
     * @return {@link String}
     */
    public static String encrypt(String text) {
        return aes.encryptBase64(text);
    }

    public static String decrypt(String text) {
        return aes.decryptStr(text);
    }
    public static void main(String[] args) {
// 生成随机密钥解开即可
//        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
//        // 生成密钥 使用这个密钥作为加密密钥
//        for (int i = 0; i < key.length; i++) {
//            System.out.print(key[i] + ",");
//        }
        System.out.println(encrypt("123"));
        System.out.println(decrypt(encrypt("123")));
    }
}

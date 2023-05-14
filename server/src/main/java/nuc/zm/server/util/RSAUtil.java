package nuc.zm.server.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.AsymmetricCrypto;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

/**
 * rsautil
 * 提供 公钥加密、私钥解密
 * @author zm
 * @date 2023/05/14
 */
public class RSAUtil {
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYrIYcov1RuABOgxbfo+uGdzdG137bsJRxbNMiNhrHy3U+xj05tb3gMTrMH030rFmPgXhgfefi2oShNHLSzxaK2bymCC94zaX27xu0USkpzj8QrsCVbN1rLXJYEEReyu3uEEf+CP1fR6kbyw3L+iMN1fYvaQgPp+6OQ0BnMEF/QwIDAQAB";
    public static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJishhyi/VG4AE6DFt+j64Z3N0bXftuwlHFs0yI2GsfLdT7GPTm1veAxOswfTfSsWY+BeGB95+LahKE0ctLPForZvKYIL3jNpfbvG7RRKSnOPxCuwJVs3WstclgQRF7K7e4QR/4I/V9HqRvLDcv6Iw3V9i9pCA+n7o5DQGcwQX9DAgMBAAECgYBpNNHB4AsiCeKkN69GcyW05mf/+DWh29+e/bfMZm4z6Z8kn+TG5NcwK5xx1syYYz/gJP63t2tYpu4oTAUoAa5s7Vu1NyoWnBtKg99NeI6kBZVPdEeGLkZZWgr2D95PccsZLV/vQg51tgeZZ84pEPSedch+xwe4LOQRBGjxJyoPSQJBAP07i5Pym/SBev6k82KgGs9aGK0whOK4A8fZLRtZXMKAkt4gVOFmJdCVTIzk2HPITOggSpxfB9zcI4uKQ8Yohr8CQQCaV6a2kHy91Ov0q8gRwPnib6U36dpNtFQghkj6hx6f8iwAiAMdkfoGZSEBKCiMXuUgYfwLHq5lVghUn9uGSUx9AkBVYsiToFB5x1cDmfb/IGEp3YVIkH2ePNH5hv8wo5cldlkPUPON9PV3OYBQWbGqiLV1572AsIJkNE4/9OUZYfzdAkBGh/migkLPCUdOx1Wlb1eCN9z7wT1Gtzqepl8hRbAkDao4D+/EipoEZCCCA9UL2K3Cb6SbfEjb/EXQTkEmi8aNAkEAuxMg9NXoVBeUopW7cCUC0q3fQ9ZLIbcsLkv2OPxw7lfT2SET3azH21wkUszccJpOwnjQuZuPDORZKkUYfvFguQ==";
    //     public RSA(String privateKeyStr, String publicKeyStr)

    public static final AsymmetricCrypto rsa = new AsymmetricCrypto(AsymmetricAlgorithm.RSA,PRIVATE_KEY,PUBLIC_KEY);
    // 公钥加密
    public static String encrypt(String text) {
        return rsa.encryptBase64(text, KeyType.PublicKey);
    }

    public static String decrypt(String text) {
        return rsa.decryptStr(text, KeyType.PrivateKey);
    }


    public static void main(String[] args) {
//         自助公钥 私钥
//        KeyPair pair = SecureUtil.generateKeyPair("RSA");
//        String encode = Base64.encode(pair.getPublic().getEncoded());
//        System.out.println(encode);
//        System.out.println(Base64.encode(pair.getPrivate().getEncoded()));

        // test
        System.out.println(encrypt("123456"));
        System.out.println(decrypt(encrypt("123456")));

    }
}

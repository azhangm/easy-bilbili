package nuc.zm.server.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.minio.credentials.Jwt;
import nuc.zm.server.exception.ConditionException;
import nuc.zm.server.exception.ExceptionEnum;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import java.util.Date;

/**
 * jwtutil
 * jwt token 工具类
 * @author zm
 * @date 2023/05/14
 */
public class JWTUtil {


    private static final String ISSUER = "nuc_zm";
    /**
     * 生成令牌
     * @param userId 用户id
     * @return {@link String}
     */

    public static String generatorToken(Long userId) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 选择 算法 这里选择 RSA 算法
        Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(),RSAUtil.getPrivateKey());
        // 为了设置过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // 设置过期时间 1 周
        calendar.add(Calendar.DAY_OF_WEEK,1);

        return JWT.create().withKeyId(String.valueOf(userId)) // 关联的id 可以理解为给谁法
                           .withIssuer(ISSUER)  // 由谁签发这个令牌
                           .withExpiresAt(calendar.getTime()) // 过期时间
                           .sign(algorithm); // 签名完成
    }


    /**
     * 验证令牌
     * @ 能够返回 userId 支持用户系统的使用
     * @param token 令牌
     * @return {@link Long}
     */
    public static Long verityToken(String token)  {
        try {
            Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(),RSAUtil.getPrivateKey());
            // 验证者
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT verify = verifier.verify(token);
            String keyId = verify.getKeyId();
            return Long.valueOf(keyId);
        }catch (TokenExpiredException e) {
            throw new ConditionException(ExceptionEnum.EXPIRE_TOKEN);
        }
        catch (Exception e) {
            throw new ConditionException(ExceptionEnum.ILLEGAL_TOKEN);
        }
    }


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InterruptedException {
        String s = generatorToken(4L);
        String token = generatorToken(4L);
        System.out.println(verityToken(token));
        Thread.sleep(1050);
        System.out.println(verityToken(s));
    }
}
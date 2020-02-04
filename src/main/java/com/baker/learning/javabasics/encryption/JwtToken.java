package com.baker.learning.javabasics.encryption;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.time.DateUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtToken {
    private static final SignatureAlgorithm SA = SignatureAlgorithm.HS256;//使用hs256算法
    private static final String KEY_SECRET = "baker";

    public static void main(String[] args) {
        //获取token
        Map<String, Object> map = new HashMap<>();
        map.put("uid", "100");
        //设置过期时间 当前时间的基础上加上30s
        map.put("exp", DateUtils.addSeconds(new Date(), 10).getTime() / 1000);
        String token = JwtToken.generatorToken(map);

        System.out.println(JwtToken.phaseToken(token).get("uid"));
        System.out.println(JwtToken.phaseToken(token).get("exp"));
    }

    /**
     * 将传过来的信息按照 Header，Payload，Signature 的方式组装一个字符串
     *
     * @param payLoad iss: jwt签发者
     *                sub: jwt所面向的用户
     *                aud: 接收jwt的一方
     *                exp: jwt的过期时间，这个过期时间必须要大于签发时间
     *                nbf: 定义在什么时间之前，该jwt都是不可用的.
     *                iat: jwt的签发时间
     *                jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
     *                ..... 自定义的一些参数
     * @return
     */
    public static String generatorToken(Map<String, Object> payLoad) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Jwts.builder().setPayload(objectMapper.writeValueAsString(payLoad)).signWith(SA, generatorKey()).compact();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将token解析，得到Payload内容
     *
     * @param token
     * @return
     */
    public static Claims phaseToken(String token) {
        //将token解析成claims
        Jws<Claims> jws = Jwts.parser().setSigningKey(generatorKey()).parseClaimsJws(token);
        //        jws.getHeader();    Header
        //        jws.getBody();      Payload
        //        jws.getSignature();  Signature
        return jws.getBody();
    }

    //获取key
    private static Key generatorKey() {
        byte[] bin = DatatypeConverter.parseBase64Binary(KEY_SECRET);
        return new SecretKeySpec(bin, SA.getJcaName());
    }
}




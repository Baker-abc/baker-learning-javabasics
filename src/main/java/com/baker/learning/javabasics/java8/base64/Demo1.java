package com.baker.learning.javabasics.java8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * link  https://www.kancloud.cn/wizardforcel/java8-new-features/148353
 * link https://juejin.im/post/5c99b2976fb9a070e76376cc
 *
 * @description
 * @date 2019/12/30 20:14
 */
public class Demo1 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String base64Str = Base64.getEncoder().encodeToString("base64".getBytes("utf-8"));
        System.out.println(base64Str);
        String str = new String(Base64.getDecoder().decode(base64Str), "UTF-8");
        System.out.println(str);


        /**
         * URL和文件名安全的Base64变体。此变体使用RFC 4648的表2中提供的Base64字母表进行编码和解码。字母表与前面显示的字母相同，
         * 只是-替换+和_替换/。不输出行分隔符。解码器拒绝包含Base64字母表之外的字符的编码。Base64编码在冗长的二进制数据和HTTP GET请求的上下文中很有用。
         * 我们的想法是对这些数据进行编码，然后将其附加到HTTP GET URL。如果使用Basic或MIME变体，
         * 则编码数据中的任何+或/字符必须被URL编码为十六进制序列（+变为%2B和/变为%2F）。生成的URL字符串会稍长一些。通过更换+同-和/同_，
         * URL和文件名安全消除了对URL编码器/解码器（和它们的编码值的长度影响）的需要。此外，当编码数据用于文件名时，此变体很有用，
         * 因为Unix和Windows文件名不能包含/。
         */
        String base64StrUrl = Base64.getUrlEncoder().encodeToString("base64//www".getBytes("utf-8"));
        System.out.println(base64StrUrl);
        String strUrl = new String(Base64.getUrlDecoder().decode(base64StrUrl), "UTF-8");
        System.out.println(strUrl);

        /**
         * 的Base64变体。此变体使用RFC 2045的表1中提供的Base64字母表进行编码和解码。
         * 编码的输出流被组织成不超过76个字符的行; 每行（最后一行除外）通过行分隔符与下一行分隔。
         * 解码期间将忽略Base64字母表中未找到的所有行分隔符或其他字符。
         */
        String base64StrMime = Base64.getMimeEncoder().encodeToString("base64213dasdasdasdasdasdazxxcsdasdasdzxZxbase64213dasdasdasdasdasdazxxcsdasdasdzxZxbase64213dasdasdasdasdasdazxxcsdasdasdzxZxbase64213dasdasdasdasdasdazxxcsdasdasdzxZx".getBytes("utf-8"));
        System.out.println(base64StrMime);
        String strMime = new String(Base64.getMimeDecoder().decode(base64StrMime), "UTF-8");
        System.out.println(strMime);

    }
}

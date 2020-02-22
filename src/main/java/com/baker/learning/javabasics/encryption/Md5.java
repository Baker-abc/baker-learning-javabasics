package com.baker.learning.javabasics.encryption;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 摘要算法
 */
public class Md5 {

    public static void main(String[] args) {
        System.out.println(DigestUtils.sha1Hex("AAAAAAAAAAAAA"));
        System.out.println(DigestUtils.sha1Hex("AAAAAAAAAAAAA").length());
        System.out.println(DigestUtils.md5Hex("AAAAAAAAAAAAA"));
        System.out.println(DigestUtils.md5Hex("AAAAAAAAAAAAA").length());
    }
}

package com.baker.learning.javabasics.cache.localcache.google;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

/**
 * @author ylp
 * @Description
 * @date 2020/7/30 10:08 下午
 * @see
 */
public class Test {

    private static LoadingCache<String, String> cache = InitCache.initLocalCache(5, 100, 5, Test::getStr);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<String> strings = Lists.newArrayList("1", "2");
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(2);
            String s = cache.get(strings.get(i % 2));
            System.out.println(s);
        }
    }

    public static String getStr(String key) {
        System.out.println("getStr");
        return key + "_______" + UUID.randomUUID().toString();
    }
}

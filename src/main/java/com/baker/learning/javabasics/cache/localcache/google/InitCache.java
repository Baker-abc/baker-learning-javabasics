package com.baker.learning.javabasics.cache.localcache.google;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author ylp
 * @Description
 * @date 2020/7/29 9:12 下午
 * @see
 */
public class InitCache {

    /**
     *
     * @param initialCapacity 初始化大小
     * @param size 大小
     * @param durationMinutes 多久不用就过期
     * @param taskRun 缓存没有时的填充方法
     * @param <F> 方法函数
     * @param <R> 返回值
     * @return
     */
    public static <F, R> LoadingCache<F, R> initLocalCache(int initialCapacity, long size,
        long durationMinutes,
        TaskRun<F, R> taskRun) {

        return CacheBuilder.newBuilder().initialCapacity(initialCapacity).maximumSize(size)
            .expireAfterAccess(durationMinutes, TimeUnit.SECONDS).build(new CacheLoader<F, R>() {
                @Override
                public R load(F f) throws Exception {
                    return taskRun.invoke(f);
                }
            });
    }
}

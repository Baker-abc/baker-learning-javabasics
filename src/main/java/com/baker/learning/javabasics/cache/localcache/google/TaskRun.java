package com.baker.learning.javabasics.cache.localcache.google;

/**
 * @author ylp
 * @Description
 * @date 2020/7/29 8:49 下午
 * @see
 */
public interface TaskRun<F, R> {
    /**
     * R : 返回值
     * @param f 函数
     * @return
     */
    public R invoke(F f);
}

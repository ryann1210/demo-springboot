package com.ruanyangyang.demo.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 本地缓存
 */
@Component
public class LocalCache {
    /**
     * 验证码cache 写入60秒后过期
     */
    private static Cache<String, String> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(60L, TimeUnit.SECONDS)
            .maximumSize(50000L)
            .build();

    public String getCache(String key) {
        return cache.getIfPresent(key);
    }

    public Cache<String, String> getCache() {
        return cache;
    }

    public void setCache(String key, String obj) { cache.put(key, obj); }

    public void removeCache(String key) {
        cache.invalidate(key);
    }

    public void removeAll() {
        cache.invalidateAll();
    }

    public long getSize() {
        return cache.size();
    }

    /**
     * 重复校验cache 写入60秒后过期
     */
    private static Cache<String, String> repeatCache = CacheBuilder.newBuilder()
            .expireAfterWrite(60L, TimeUnit.SECONDS)
            .maximumSize(50000L)
            .build();

    public void setRepeatCache(String key, String obj) { repeatCache.put(key, obj); }

    public String getRepeatCache(String key) {
        return repeatCache.getIfPresent(key);
    }
}

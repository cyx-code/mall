package com.cyx.mall.service;

/**
 * @description: redis操作service
 * @author: cyx
 * @create: 2020/07/31
 */
public interface IRedisService {

    void set(String key, String value);

    String get(String key);

    boolean expire(String key, long expire);

    void remove(String key);

    Long increment(String key, long delta);

}

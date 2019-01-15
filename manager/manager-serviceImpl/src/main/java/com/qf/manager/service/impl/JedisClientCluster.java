package com.qf.manager.service.impl;


import com.qf.manager.service.JedisClient;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;


@Service
public class JedisClientCluster implements JedisClient {
    private JedisCluster jedisCluster;

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public String get(String key) {
        return null;
    }

    public String set(String key, String value) {
        return null;
    }

    public Boolean exists(String key) {
        return null;
    }

    public Long expire(String key, int seconds) {
        return null;
    }

    public Long ttl(String key) {
        return null;
    }

    public Long incr(String key) {
        return null;
    }

    public Long del(String key) {
        return null;
    }

    public String hget(String key, String field) {
        return jedisCluster.hget(key,field);
    }

    public Long hset(String key, String field, String value) {
        return jedisCluster.hset(key, field, value);
    }

    public String hdel(String key, String... field) {
        return null;
    }

    public Boolean hexists(String key, String field) {
        return null;
    }

    public List<String> values(String key) {
        return null;
    }

    public Long lpush(String key, String... Strings) {
        return null;
    }

    public List<String> lrange(String key, long start, long end) {
        return null;
    }
}

package cn.wscq.spring.domain.service.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author shuai
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void saveString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void saveString(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    @Override
    public void saveObject(String key, Object obj) {
        String value = JSON.toJSONString(obj);
        this.saveString(key, value);
    }

    @Override
    public void saveObject(String key, Object obj, long timeout) {
        String value = JSON.toJSONString(obj);
        this.saveString(key, value, timeout);
    }

    @Override
    public String getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public <T> T getObject(String key, Class<T> clazz) {
        String value = this.getString(key);
        return JSON.parseObject(value, clazz);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}

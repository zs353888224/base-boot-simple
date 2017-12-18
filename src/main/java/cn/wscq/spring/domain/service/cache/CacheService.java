package cn.wscq.spring.domain.service.cache;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/8 14:50
 */
public interface CacheService {
    void saveString(String key, String value);

    /**
     * save String
     *
     * @param key
     * @param value
     * @param timeout valid time，unit is second
     * @return
     */
    void saveString(String key, String value, long timeout);

    void saveObject(String key, Object obj);

    void saveObject(String key, Object obj, long timeout);

    String getString(String key);

    <T> T getObject(String key, Class<T> clazz);

    void delete(String key);
}

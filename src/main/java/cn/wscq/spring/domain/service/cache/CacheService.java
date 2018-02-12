package cn.wscq.spring.domain.service.cache;

/**
 * @author shuai
 */
public interface CacheService {
    void saveString(String key, String value);

    /**
     * save String
     *
     * @param key key
     * @param value value
     * @param timeout valid time，unit is second
     */
    void saveString(String key, String value, long timeout);

    void saveObject(String key, Object obj);

    void saveObject(String key, Object obj, long timeout);

    String getString(String key);

    <T> T getObject(String key, Class<T> clazz);

    void delete(String key);
}

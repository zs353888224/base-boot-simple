package cn.wscq.spring.domain.service;

import java.io.Serializable;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/8 10:21
 */
public interface BaseService<T, ID extends Serializable> {

    T createSelective(T resource);

    T create(T resource);

    T update(T resource);

    T updateSelective(T resource);

    void delete(ID id);

    T findOne(ID id);
}

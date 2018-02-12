package cn.wscq.spring.domain.service;

import java.io.Serializable;

/**
 * @author shuai
 */
public interface BaseService<T, ID extends Serializable> {

    T createSelective(T resource);

    T create(T resource);

    int update(T resource);

    int updateSelective(T resource);

    int delete(ID id);

    T findOne(ID id);
}

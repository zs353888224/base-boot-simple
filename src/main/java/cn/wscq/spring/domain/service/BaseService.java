package cn.wscq.spring.domain.service;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.Serializable;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/8 10:21
 */
// TODO （aop注解）测试该注解是否会被继承
@EnableAspectJAutoProxy
public interface BaseService<T, ID extends Serializable> {

    T createSelective(T resource);

    T create(T resource);

    T update(T resource);

    T updateSelective(T resource);

    void delete(ID id);

    T findOne(ID id);
}

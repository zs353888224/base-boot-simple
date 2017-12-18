package cn.wscq.spring.domain.dao;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/8 10:23
 */
// TODO （aop注解）测试该注解是否会被继承
@EnableAspectJAutoProxy
public interface BaseMapper<T, ID> {

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}

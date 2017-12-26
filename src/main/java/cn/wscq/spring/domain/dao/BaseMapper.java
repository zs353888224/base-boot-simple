package cn.wscq.spring.domain.dao;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/8 10:23
 */
public interface BaseMapper<T, ID> {

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}

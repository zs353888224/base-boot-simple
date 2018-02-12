package cn.wscq.spring.domain.dao;

/**
 * @author shuai
 */
public interface BaseMapper<T, ID> {

    int deleteByPrimaryKey(ID id);

    void insert(T record);

    void insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}

package cn.wscq.spring.domain.service;

import cn.wscq.spring.domain.dao.BaseMapper;

import java.io.Serializable;

/**
 * @author shuai
 */
public abstract class BaseServiceImpl<T, ID extends Serializable, R extends BaseMapper<T, ID>> implements BaseService<T, ID> {

    protected R repository;

    protected abstract void setRepository(R repository);

    @Override
    public T createSelective(T resource) {
        repository.insertSelective(resource);
        return resource;
    }

    @Override
    public T create(T resource) {
        repository.insert(resource);
        return resource;
    }

    @Override
    public int update(T resource) {
        return repository.updateByPrimaryKey(resource);
    }

    @Override
    public int updateSelective(T resource) {
        return repository.updateByPrimaryKeySelective(resource);
    }

    @Override
    public int delete(ID id) {
        return repository.deleteByPrimaryKey(id);
    }

    @Override
    public T findOne(ID id) {
        return repository.selectByPrimaryKey(id);
    }
}

package cn.wscq.spring.domain.service;

import cn.wscq.spring.domain.dao.BaseMapper;

import java.io.Serializable;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/8 10:21
 */
public abstract class BaseServiceImpl<T, ID extends Serializable, R extends BaseMapper<T, ID>> implements BaseService<T, ID> {

    protected R repository;

    public abstract void setRepository(R repository);

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
    public T update(T resource) {
        repository.updateByPrimaryKey(resource);
        return resource;
    }

    @Override
    public T updateSelective(T resource) {
        repository.updateByPrimaryKeySelective(resource);
        return resource;
    }

    @Override
    public void delete(ID id) {
        repository.deleteByPrimaryKey(id);
    }

    @Override
    public T findOne(ID id) {
        return repository.selectByPrimaryKey(id);
    }
}

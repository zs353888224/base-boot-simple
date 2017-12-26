package cn.wscq.spring.domain.service.User;

import cn.wscq.spring.domain.dao.mybatis.TUserMapper;
import cn.wscq.spring.domain.model.mybatis.TUser;
import cn.wscq.spring.domain.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fc
 * @version 1.0
 * @description
 * @date 2017/12/26 10:51
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<TUser, Long, TUserMapper> implements UserService {
    @Override
    @Autowired
    public void setRepository(TUserMapper repository) {
        super.repository = repository;
    }

    @Override
    public TUser login(TUser tuser) {
        return super.repository.login(tuser);
    }
}

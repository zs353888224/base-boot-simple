package cn.wscq.spring.domain.service.user;

import cn.wscq.spring.domain.dao.mybatis.TUserMapper;
import cn.wscq.spring.domain.model.Account;
import cn.wscq.spring.domain.model.mybatis.TUser;
import cn.wscq.spring.domain.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuai
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<TUser, Long, TUserMapper> implements UserService {

    @Autowired
    @Override
    public void setRepository(TUserMapper repository) {
        super.repository = repository;
    }

    @Override
    public Account findAccountByUserName(String userName) {
        return null;
    }
}

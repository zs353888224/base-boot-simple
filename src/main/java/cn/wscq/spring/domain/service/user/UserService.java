package cn.wscq.spring.domain.service.user;

import cn.wscq.spring.domain.model.Account;
import cn.wscq.spring.domain.model.mybatis.TUser;
import cn.wscq.spring.domain.service.BaseService;

/**
 * @author shuai
 */
public interface UserService extends BaseService<TUser, Long> {

    Account findAccountByUserName(String userName);
}

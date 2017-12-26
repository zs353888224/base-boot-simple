package cn.wscq.spring.domain.service.User;

import cn.wscq.spring.domain.model.mybatis.TUser;
import cn.wscq.spring.domain.service.BaseService;

/**
 * @author fc
 * @version 1.0
 * @description
 * @date 2017/12/26 10:49
 */
public interface UserService extends BaseService<TUser, Long> {

     TUser login(TUser tUser);

}

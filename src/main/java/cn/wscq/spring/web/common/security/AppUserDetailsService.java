package cn.wscq.spring.web.common.security;

import cn.wscq.spring.domain.model.Account;
import cn.wscq.spring.domain.model.AppUserDetails;
import cn.wscq.spring.domain.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author shuai
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = userService.findAccountByUserName(userName);
        if (account == null) {
            throw new UsernameNotFoundException("user name not found");
        }
        return new AppUserDetails(account);
    }
}

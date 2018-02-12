package cn.wscq.spring.domain.model;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * @author shuai
 */
public class AppUserDetails extends User {

    private Account account;

    public AppUserDetails(Account account) {
        super(account.getEmail(), account.getPassword(), AuthorityUtils.createAuthorityList(account.getRole().name()));
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}

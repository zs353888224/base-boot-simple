package cn.wscq.spring.domain.model;

import cn.wscq.spring.domain.model.enums.Role;

import java.io.Serializable;

/**
 * @author shuai
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String email;

    private String password;

    private Role role;

    private Long userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

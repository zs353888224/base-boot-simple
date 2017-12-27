package cn.wscq.spring.domain.model.form;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author fc
 * @version 1.0
 * @description
 * @date 2017/12/27 11:18
 */
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    @NotNull
    private String userName;
    @NotNull
    private String passWord;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

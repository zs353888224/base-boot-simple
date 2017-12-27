package cn.wscq.spring.web.controller;

import cn.wscq.spring.domain.model.dto.APIResult;
import cn.wscq.spring.domain.model.form.UserForm;
import cn.wscq.spring.domain.model.mybatis.TUser;
import cn.wscq.spring.domain.service.User.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author fc
 * @version 1.0
 * @description
 * @date 2017/12/26 10:36
 */
@RestController
@RequestMapping("/user")
public class UserController {
    // 获取输出日志
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public APIResult login(@ModelAttribute @Valid UserForm userForm) {
        //日志输出传来的tUser数据
        logger.info("传来的user数据", userForm);
        TUser loginUser = userService.findByName(userForm.getUserName());
        logger.info("查询到的user对象", loginUser);
        if (loginUser != null) {
            if (!loginUser.getPassword().equals(userForm.getPassWord())) {
                return APIResult.failure().setMessage("密码错误，登录失败");
            } else {
                return APIResult.success().setMessage("登录成功").setData(loginUser);
            }
        } else {
            return APIResult.failure().setMessage("用户名错误，登录失败");
        }

    }

}

package cn.wscq.spring.web.controller;

import cn.wscq.spring.domain.model.dto.APIResult;
import cn.wscq.spring.domain.model.mybatis.TUser;
import cn.wscq.spring.domain.service.User.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public APIResult login(@RequestBody TUser tUser) {
        //日志输出传来的tUser数据
        logger.info("传来的user数据", tUser);
        TUser loginuser = userService.login(tUser);
        //日志输出查询后的loginuser数据
        logger.info("query Tuser by tuser: {}", loginuser);
        //如果不为空表示查询到了对象，可以登录。
        if (loginuser != null) {
            return APIResult.success().setMessage("登录成功").setData(loginuser);
        } else {
            return APIResult.failure().setMessage("用户名或者密码错误，登录失败").setData(loginuser);
        }

    }

}

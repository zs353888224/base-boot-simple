package cn.wscq.spring.config.system;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/14 16:25
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}

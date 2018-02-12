package cn.wscq.spring.config.system;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author shuai
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}

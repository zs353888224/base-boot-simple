package cn.wscq.spring.config.system;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/25 15:35
 */
@Component
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String URL = "URL : ";

    private final static String HTTP_METHOD = "HTTP_METHOD : ";

    private final static String CLASS_METHOD = "CLASS_METHOD : ";

    private final static String METHOD = "#";

    private final static String ARGS = "ARGS : ";

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void executeRestController() {

    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void executeService() {

    }

    @Pointcut("@within(org.apache.ibatis.annotations.Mapper)")
    public void executeMapper() {

    }

    @Pointcut("executeService() || executeMapper()")
    public void executeAll() {

    }

    @Before("executeRestController()")
    public void doBeforeAdviceController(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info(URL + request.getRequestURL().toString());

        logger.info(HTTP_METHOD + request.getMethod());

        logger.info(CLASS_METHOD + joinPoint.getSignature().getDeclaringTypeName() + METHOD + joinPoint.getSignature
                ().getName());

        logger.info(ARGS + Arrays.toString(joinPoint.getArgs()));

        //获取所有参数方法一：

        Enumeration<String> enu = request.getParameterNames();
        Map<String, String[]> params = request.getParameterMap();
        String sss = request.getCharacterEncoding();

        while (enu.hasMoreElements()) {

            String paraName = enu.nextElement();

            logger.info(paraName + ": " + request.getParameter(paraName));

        }
        this.doBeforeAdvice(joinPoint);
    }

    @Before("executeAll()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        logger.debug("test debug");
        logger.error("test error");
        logger.info("test info");

        logger.info(joinPoint.getKind());
    }

    @After("executeAll()")
    public void doEndAdvice(JoinPoint joinPoint) {

    }
}

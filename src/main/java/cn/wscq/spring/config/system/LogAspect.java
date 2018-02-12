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

/**
 * @author shuai
 */
@Component
@Aspect
public class LogAspect {

    private final static String URL = "URL          : {}";
    private final static String HTTP_METHOD = "HTTP_METHOD  : {}";
    private final static String REQUEST_PARAM = "REQUEST_PARAM: {}:{}";
    private final static String CLASS_METHOD = "METHOD_BEGIN : {}#{}";
    private final static String ARGS = "METHOD_ARGS  : {}";
    private final static String METHOD_END = "METHOD_END   : {}";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void executeRestController() {

    }

    @Pointcut("execution(* cn.wscq.spring.domain.service.*.*(..))")
    public void executeService() {

    }

    @Pointcut("execution(* cn.wscq.spring.domain.dao.*.*(..))")
    public void executeMapper() {

    }

    @Before("executeRestController()")
    public void doBeforeAdviceController(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // TODO 拿到用户信息，以用户信息标注日志
        logger.info(URL, request.getRequestURL().toString());
        logger.info(HTTP_METHOD, request.getMethod());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            logger.info(REQUEST_PARAM, paraName, request.getParameter(paraName));
        }
        this.doBeforeAdvice(joinPoint);
    }

    @Before("executeService() || executeMapper()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        logger.info(CLASS_METHOD, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info(ARGS, Arrays.toString(joinPoint.getArgs()));
    }

    @After("executeService() || executeMapper() || executeRestController()")
    public void doEndAdvice(JoinPoint joinPoint) {
        logger.info(METHOD_END, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }
}

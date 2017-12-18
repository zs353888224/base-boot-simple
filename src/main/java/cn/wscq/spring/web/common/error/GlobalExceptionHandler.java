package cn.wscq.spring.web.common.error;

import cn.wscq.spring.domain.model.dto.APIResult;
import cn.wscq.spring.web.common.error.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/15 13:26
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    /**
     * 捕捉业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public APIResult handleBusinessException(BusinessException e) {
        String message = messageSource.getMessage(e.getCode(), e.getArgs(), LocaleContextHolder.getLocale());
        logger.info("BusinessException: {}", message);
        return APIResult.failure().setMessage(message).setData(e.getData());
    }

    /**
     * 捕捉全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APIResult handleGlobalException(Exception e) {
        logger.error(e.getMessage());
        logger.error("error:", e);
        return APIResult.failure().setMessage(e.getMessage());
    }

    /**
     * 处理绑定数据异常
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("BindException: {}", ex.getMessage());
        return new ResponseEntity<>(APIResult.failure().setData(ex.getBindingResult().getAllErrors()), HttpStatus.BAD_REQUEST);
    }
}

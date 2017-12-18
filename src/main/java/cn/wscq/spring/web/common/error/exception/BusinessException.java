package cn.wscq.spring.web.common.error.exception;

/**
 * @author shuai
 * @version 1.0
 * @description 业务异常
 * @date 2017/12/15 13:28
 */
public class BusinessException extends RuntimeException {

    /**
     * 异常信息代码
     */
    private String code;
    /**
     * 异常信息参数
     */
    private Object[] args;
    /**
     * 自定义携带信息
     */
    private Object data;

    public BusinessException(String code) {
        super();
        this.code = code;
    }

    public BusinessException(String code, Object[] args) {
        super();
        this.code = code;
        this.args = args;
    }

    public BusinessException(String code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public BusinessException(String code, Object[] args, Object data) {
        super();
        this.code = code;
        this.data = data;
        this.args = args;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public Object getData() {
        return data;
    }
}
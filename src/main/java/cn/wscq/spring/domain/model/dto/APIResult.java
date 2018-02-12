package cn.wscq.spring.domain.model.dto;

import java.io.Serializable;

/**
 * @author shuai
 */
public class APIResult implements Serializable {

    // TODO 在前后端分离的情况下，这个类并没有太好的表现，考虑干掉

    private static final long serialVersionUID = 1L;

    private final static int SUCCESS = 0;
    private final static int FAILURE = 1;

    private int status;
    private String message;
    private Object data;

    public static APIResult success() {
        return new APIResult().setStatus(SUCCESS);
    }

    public static APIResult failure() {
        return new APIResult().setStatus(FAILURE);
    }

    public int getStatus() {
        return status;
    }

    private APIResult setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public APIResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public APIResult setData(Object data) {
        this.data = data;
        return this;
    }
}

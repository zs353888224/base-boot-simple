package cn.wscq.spring.domain.model.form;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/14 16:38
 */
public class DemoForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long demoId;

    @NotNull
    private String name;

    @NotNull
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getDemoId() {
        return demoId;
    }

    public void setDemoId(Long demoId) {
        this.demoId = demoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

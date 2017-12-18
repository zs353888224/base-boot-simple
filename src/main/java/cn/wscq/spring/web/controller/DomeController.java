package cn.wscq.spring.web.controller;

import cn.wscq.spring.domain.model.dto.APIResult;
import cn.wscq.spring.domain.model.form.DemoForm;
import cn.wscq.spring.domain.model.mybatis.TDemo;
import cn.wscq.spring.domain.service.demo.DemoService;
import cn.wscq.spring.web.common.error.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/6 16:33
 */
@RestController
@RequestMapping("/demo")
public class DomeController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/{demoId}")
    public APIResult testGet(@PathVariable Long demoId) {
        TDemo demo = demoService.findOne(demoId);
        return APIResult.success().setMessage("get test success").setData(demo);
    }

    @PostMapping
    public APIResult testPost(@ModelAttribute @Valid DemoForm form) {
        TDemo demo = new TDemo();
        demo.setTestName(form.getName());
        demoService.create(demo);
        if (form.getCount() == 1) {
            // 需要返回业务信息时
            throw new BusinessException("test", new String[]{"123", "456"});
        } else if (form.getCount() == 2) {
            int p = 1 / 0;
        }
        return APIResult.success().setMessage("post test success").setData(demo);
    }

    @DeleteMapping("/{demoId}")
    public APIResult testDelete(@PathVariable Long demoId) {
        TDemo demo = new TDemo();
        demo.setTestId(demoId);
        demo.setTestName("delete");
        // 采用逻辑删除的方式
        demoService.updateSelective(demo);
        return APIResult.success().setMessage("delete test success");
    }

    @PutMapping
    public APIResult testPut(@RequestBody @Valid DemoForm form, BindingResult bindingResult) throws BindException {
        if (bindingResult.getErrorCount() > 0) {
            throw new BindException(bindingResult);
        }
        TDemo demo = new TDemo();
        demo.setTestId(form.getDemoId());
        demo.setTestName(form.getName());
        demoService.updateSelective(demo);
        return APIResult.success().setMessage("put test success");
    }
}
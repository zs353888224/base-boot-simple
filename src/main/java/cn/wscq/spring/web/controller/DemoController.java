package cn.wscq.spring.web.controller;

import cn.wscq.spring.domain.model.dto.APIResult;
import cn.wscq.spring.domain.model.form.DemoForm;
import cn.wscq.spring.domain.model.mybatis.TDemo;
import cn.wscq.spring.domain.service.demo.DemoService;
import cn.wscq.spring.web.common.error.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author shuai
 * @version 1.0
 * @description demo
 * @date 2017/12/6 16:33
 */
// 统一采用@RestController注解
@RestController
// 根据业务划分命名Controller和url
@RequestMapping("/demo")
public class DemoController {

    // 获取输出日志
    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    // 注入service
    @Autowired
    private DemoService demoService;

    @GetMapping("/{demoId}")
    // 方法名统一动作在前，名词在后
    public APIResult getDemo(@PathVariable Long demoId) {
        TDemo demo = demoService.findOne(demoId);
        // 日志自定义输出
        logger.info("query Demo by demoId: {}", demoId);
        return APIResult.success().setMessage("get demo success").setData(demo);
    }

    @PostMapping
    // @ModelAttribute 接收注入来自form表单的数据
    // @Valid 在注入前进行参数验证，如果验证失败会返回固定格式的API
    public APIResult postDemo(@ModelAttribute @Valid DemoForm form, HttpSession session) {

        String str = (String) session.getAttribute("test");
        logger.info(str);
        if (str == null) {
            session.setAttribute("test", "test");
        }
        TDemo demo = new TDemo();
        demo.setTestId(form.getDemoId());
        demo.setTestName(form.getName());
        if (form.getCount() == 1) {
            // 业务上不能通过，可抛出BusinessException异常。异常处理会根据i18n/messages.properties中配置信息返回API
            // 信息模版：demo=这是测试{0}，这是测试{1}这是测试
            // 生成的API信息：这是测试123，这是测试456这是测试
            // BusinessException中最后一个参数为非必填，可以传递更多自定义信息
            throw new BusinessException("demo", new String[]{"123", "456"}, demo);
        } else if (form.getCount() == 2) {
            // 当系统报错时，会返回固定格式的错误信息API
            int p = 1 / 0;
        }
        demoService.updateSelective(demo);
        return APIResult.success().setMessage("post demo success").setData(demo);
    }

    @DeleteMapping("/{demoId}")
    public void deleteDemo(@PathVariable Long demoId) {
        TDemo demo = new TDemo();
        demo.setTestId(demoId);
        demo.setTestName("delete");
        // 有逻辑删除的表均采用逻辑删除的方式
        demoService.updateSelective(demo);
    }

    @PutMapping
    // @RequestBody 接收和注入json格式的数据
    // @Valid 在注入前进行参数验证，如果验证失败会返回固定格式的API
    public void putDemo(@RequestBody @Valid DemoForm form) {
        TDemo demo = new TDemo();
        demo.setTestName(form.getName());
        demoService.create(demo);
    }
}
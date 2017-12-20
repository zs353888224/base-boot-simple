package cn.wscq.spring.web.controller;

import cn.wscq.spring.MyTestsConfiguration;
import cn.wscq.spring.domain.model.dto.APIResult;
import cn.wscq.spring.domain.model.form.DemoForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Import;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/15 11:31
 */
@RunWith(SpringRunner.class)
// 测试API的测试环境采用RANDOM_PORT
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(MyTestsConfiguration.class)
public class DemoControllerTest {

    // 注入测试用模板
    @Autowired
    private TestRestTemplate testRestTemplate;

    // 注入信息提取工具
    @Autowired
    private MessageSource messageSource;

    @Before
    public void beforeTest() {
        // 启动前真被测试数据
    }

    @Test
    public void testGet() {
        // 进行get请求
        APIResult rs = testRestTemplate.getForObject("/demo/1", APIResult.class);
        // 断言请求结果
        Assert.assertEquals(0, rs.getStatus());
    }

    @Test
    public void testPost() {
        // 为form表单写入数据
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("count", "1");
        map.add("name", "tested");
        APIResult rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
        Assert.assertEquals(1, rs.getStatus());
        // 使用消息管理器提取主动抛出来的异常信息
        String msg = messageSource.getMessage("demo", new String[]{"123", "456"}, LocaleContextHolder.getLocale());
        Assert.assertEquals(msg, rs.getMessage());

        map.clear();
        map.set("name", "tested");
        rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
        Assert.assertEquals(1, rs.getStatus());
        Assert.assertEquals(null, rs.getMessage());

        map.clear();
        map.set("name", "tested");
        map.set("count", "2");
        rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
        Assert.assertEquals(1, rs.getStatus());
        Assert.assertEquals("/ by zero", rs.getMessage());

        map.clear();
        map.set("name", "tested");
        map.set("count", "3");
        rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
        Map rsMap = (Map) rs.getData();
        Assert.assertEquals(0, rs.getStatus());
        Assert.assertEquals("tested", rsMap.get("testName"));
    }

    @Test
    public void testDelete() {
        // delete请求在成功的情况下是没有返回值的，但是在出错的情况下会返回API
        ResponseEntity<APIResult> rs = testRestTemplate.exchange("/demo/1", HttpMethod.DELETE,
                new HttpEntity<>(""), APIResult.class);
        Assert.assertEquals(null, rs.getBody());
    }

    @Test
    public void testPut() {
        DemoForm form = new DemoForm();
        form.setDemoId(1L);
        form.setName("dasasda");
        form.setCount(3);
        // put请求在处理成功的情况下没有返回值，但是在出错的情况下会返回API
        ResponseEntity<APIResult> rs = testRestTemplate.exchange("/demo", HttpMethod.PUT,
                new HttpEntity<>(form), APIResult.class);
        Assert.assertEquals(null, rs.getBody());
    }
}
package cn.wscq.spring.web.controller;

import cn.wscq.spring.MyTestsConfiguration;
import cn.wscq.spring.domain.model.dto.APIResult;
import cn.wscq.spring.domain.model.form.DemoForm;
import com.alibaba.fastjson.JSON;
import org.apache.http.entity.StringEntity;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(MyTestsConfiguration.class)
public class DomeControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MessageSource messageSource;

    @Before
    public void beforeTest() {

    }

    @Test
    public void testGet() {
        APIResult rs = testRestTemplate.getForObject("/demo/1", APIResult.class);
        Assert.assertEquals(0, rs.getStatus());
    }

    @Test
    public void testPost() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("count", "1");
        map.add("name", "tested");
        APIResult rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
        Assert.assertEquals(1, rs.getStatus());
        String msg = messageSource.getMessage("test", new String[]{"123", "456"}, LocaleContextHolder.getLocale());
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
        ResponseEntity<APIResult> rs = testRestTemplate.exchange("/demo/1", HttpMethod.DELETE, new HttpEntity<>(""), APIResult.class);
        Assert.assertEquals(0, rs.getBody().getStatus());
    }

    @Test
    public void testPut() {
        DemoForm form = new DemoForm();
        form.setDemoId(1L);
        form.setName("dasasda");
        form.setCount(3);
        ResponseEntity<APIResult> rs = testRestTemplate.exchange("/demo", HttpMethod.PUT, new HttpEntity<>(form), APIResult.class);
        Assert.assertEquals(0, rs.getBody().getStatus());
    }
}
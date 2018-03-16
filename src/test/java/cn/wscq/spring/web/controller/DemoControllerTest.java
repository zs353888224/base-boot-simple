package cn.wscq.spring.web.controller;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/15 11:31
 */
@RunWith(SpringRunner.class)
// 测试API的测试环境采用RANDOM_PORT
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestDocs
public class DemoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RequestSpecification documentationSpec;

    @Test
    public void testGet() throws Exception {
//        // 进行get请求
//        APIResult rs = testRestTemplate.getForObject("/demo/1", APIResult.class);
//        // 断言请求结果
//        Assert.assertEquals(0, rs.getStatus());
        RestAssured.given(this.documentationSpec).filter(document("demo-detail")).when()
                .port(this.port).get("/demo/1").then().assertThat().statusCode(is(200));
    }
//
//    @Test
//    public void testPost() {
//        // 为form表单写入数据
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("count", "1");
//        map.add("name", "tested");
//        APIResult rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
//        Assert.assertEquals(1, rs.getStatus());
//        // 使用消息管理器提取主动抛出来的异常信息
//        String msg = messageSource.getMessage("demo", new String[]{"123", "456"}, LocaleContextHolder.getLocale());
//        Assert.assertEquals(msg, rs.getMessage());
//
//        map.clear();
//        map.set("name", "tested");
//        rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
//        Assert.assertEquals(1, rs.getStatus());
//        Assert.assertEquals(null, rs.getMessage());
//
//        map.clear();
//        map.set("name", "tested");
//        map.set("count", "2");
//        rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
//        Assert.assertEquals(1, rs.getStatus());
//        Assert.assertEquals("/ by zero", rs.getMessage());
//
//        map.clear();
//        map.set("name", "tested");
//        map.set("count", "3");
//        rs = testRestTemplate.postForObject("/demo", map, APIResult.class);
//        Map rsMap = (Map) rs.getData();
//        Assert.assertEquals(0, rs.getStatus());
//        Assert.assertEquals("tested", rsMap.get("testName"));
//
//    }
//
//    @Test
//    public void testDelete() {
//        // delete请求在成功的情况下是没有返回值的，但是在出错的情况下会返回API
//        ResponseEntity<APIResult> rs = testRestTemplate.exchange("/demo/1", HttpMethod.DELETE,
//                new HttpEntity<>(""), APIResult.class);
//        Assert.assertEquals(null, rs.getBody());
//    }
//
//    @Test
//    public void testPut() {
//        DemoForm form = new DemoForm();
//        form.setDemoId(1L);
//        form.setName("dasasda");
//        form.setCount(3);
//        // put请求在处理成功的情况下没有返回值，但是在出错的情况下会返回API
//        ResponseEntity<APIResult> rs = testRestTemplate.exchange("/demo", HttpMethod.PUT,
//                new HttpEntity<>(form), APIResult.class);
//        Assert.assertEquals(null, rs.getBody());
//    }
}
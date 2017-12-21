package cn.wscq.spring.domain.service.cache;

import cn.wscq.spring.MyTestsConfiguration;
import cn.wscq.spring.domain.model.form.DemoForm;
import cn.wscq.spring.domain.model.mybatis.TDemo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/14 16:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(MyTestsConfiguration.class)
public class CacheServiceTest {

    @Autowired
    private CacheService cacheService;

    @Test
    public void saveString() {
        //存贮一般的字符串
        cacheService.saveString("stringone", "zhansang");
        Assert.assertEquals("zhansang",cacheService.getString("stringone"));

    }

    @Test
    public void saveString1() {
        try {
            //存贮字符串并且设置超时
            cacheService.saveString("stringtwo","lisi",10);
            Thread.sleep(11000);
            Assert.assertEquals(null,cacheService.getString("stringtwo"));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Test
    public void saveObject() {

        TDemo demo = new TDemo();
        demo.setTestId(2L);
        demo.setTestName("hahah");
        cacheService.saveObject("objectone",demo);
        //获取到demo对象
        TDemo demo2 = cacheService.getObject("objectone",TDemo.class);
        Assert.assertEquals(demo,demo2);

    }

    @Test
    public void saveObject1() {
        TDemo demo = new TDemo();
        demo.setTestId(1L);
        demo.setTestName("haha");
        try {
            //存贮对象并且设置超时
            cacheService.saveObject("objecttwo",demo,10);
            Thread.sleep(11000);
            Assert.assertEquals(null,cacheService.getObject("objecttwo",TDemo.class));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void getString() {
        String value = cacheService.getString("stringone");
        Assert.assertEquals("zhansan",value);

    }

    @Test
    public void getObject() {
        TDemo demo2 = new TDemo();
        demo2.setTestId(2L);
        demo2.setTestName("hahah");
        //获取到demo对象
        TDemo demo3 = cacheService.getObject("objectone",TDemo.class);
        Assert.assertEquals(demo2,demo3);

    }

    @Test
    public void delete() {
        cacheService.delete("stringone");
        Assert.assertEquals(null,cacheService.getString("stringone"));
    }


}
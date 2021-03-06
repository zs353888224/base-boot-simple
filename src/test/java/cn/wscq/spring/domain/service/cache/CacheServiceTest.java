package cn.wscq.spring.domain.service.cache;

import cn.wscq.spring.MyTestsConfiguration;
import cn.wscq.spring.domain.model.mybatis.TDemo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Before
    public void beforeTest() {

        cacheService.saveString("stringone", "zhansan");
        TDemo demo = new TDemo();
        demo.setTestId(2L);
        demo.setTestName("hahah");
        cacheService.saveObject("objectone", demo);
    }

    @After
    public void afterTest() {
        cacheService.delete("stringone");
        cacheService.delete("objectone");
    }

    @Test
    public void saveString() {
        //存贮一般的字符串
        cacheService.saveString("stringone", "zhansan");
        Assert.assertEquals("zhansan", cacheService.getString("stringone"));
    }

    @Test
    public void getString() {
        String value = cacheService.getString("stringone");
        Assert.assertEquals("zhansan", value);
    }

    @Test
    public void saveString1() {
        try {
            //存贮字符串并且设置超时
            cacheService.saveString("stringtwo", "lisi", 10);
            Thread.sleep(11000);
            Assert.assertEquals(null, cacheService.getString("stringtwo"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void saveObject() {

        TDemo demo = new TDemo();
        demo.setTestId(2L);
        demo.setTestName("hahah");
        //把demo对象存入redis中
        cacheService.saveObject("objectone", demo);
        //获取到demo对象
        TDemo demo2 = cacheService.getObject("objectone", TDemo.class);
        //分别取出对象里面的字段进行Assert
        Assert.assertEquals(new Long(2L), demo2.getTestId());
        Assert.assertEquals("hahah", demo2.getTestName());

    }

    @Test
    public void saveObject1() {
        TDemo demo = new TDemo();
        demo.setTestId(1L);
        demo.setTestName("haha");
        try {
            //存贮对象并且设置超时
            cacheService.saveObject("objecttwo", demo, 10);
            Thread.sleep(11000);
            Assert.assertEquals(null, cacheService.getObject("objecttwo", TDemo.class));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getObject() {
        //获取到demo对象
        TDemo demo = cacheService.getObject("objectone", TDemo.class);
        //分别取出对象里面的字段进行Assert
        Assert.assertEquals(new Long(2L), demo.getTestId());
        Assert.assertEquals("hahah", demo.getTestName());
    }

    @Test
    public void delete() {
        cacheService.delete("stringone");
        Assert.assertEquals(null, cacheService.getString("stringone"));
    }

}
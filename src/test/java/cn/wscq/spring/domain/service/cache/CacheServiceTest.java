package cn.wscq.spring.domain.service.cache;

import cn.wscq.spring.MyTestsConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/14 16:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import(MyTestsConfiguration.class)
public class CacheServiceTest {

    @Test
    public void saveString() {
    }

    @Test
    public void saveString1() {
    }

    @Test
    public void saveObject() {
    }

    @Test
    public void saveObject1() {
    }

    @Test
    public void getString() {
    }

    @Test
    public void getObject() {
    }

    @Test
    public void delete() {
    }
}
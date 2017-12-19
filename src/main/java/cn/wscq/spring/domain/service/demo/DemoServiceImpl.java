package cn.wscq.spring.domain.service.demo;

import cn.wscq.spring.domain.dao.mybatis.TDemoMapper;
import cn.wscq.spring.domain.model.mybatis.TDemo;
import cn.wscq.spring.domain.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/14 16:35
 */
@Service
public class DemoServiceImpl extends BaseServiceImpl<TDemo, Long, TDemoMapper> implements DemoService {
    @Override
    @Autowired
    public void setRepository(TDemoMapper repository) {
        super.repository = repository;
    }

    // 实现自定义接口
}

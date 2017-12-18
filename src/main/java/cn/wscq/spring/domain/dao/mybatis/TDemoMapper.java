package cn.wscq.spring.domain.dao.mybatis;

import cn.wscq.spring.domain.dao.BaseMapper;
import cn.wscq.spring.domain.model.mybatis.TDemo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shuai
 * @version 1.0
 * @description
 * @date 2017/12/14 16:33
 */
@Mapper
public interface TDemoMapper extends BaseMapper<TDemo, Long> {
}

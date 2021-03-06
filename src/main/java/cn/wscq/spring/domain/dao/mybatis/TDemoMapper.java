package cn.wscq.spring.domain.dao.mybatis;

import cn.wscq.spring.domain.dao.BaseMapper;
import cn.wscq.spring.domain.model.mybatis.TDemo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shuai
 */
@Mapper
public interface TDemoMapper extends BaseMapper<TDemo, Long> {
}

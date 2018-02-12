package cn.wscq.spring.domain.dao.mybatis;

import cn.wscq.spring.domain.dao.BaseMapper;
import cn.wscq.spring.domain.model.mybatis.TUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shuai
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser, Long> {
}

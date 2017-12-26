package cn.wscq.spring.domain.dao.mybatis;

import cn.wscq.spring.domain.dao.BaseMapper;
import cn.wscq.spring.domain.model.mybatis.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author fc
 * @version 1.0
 * @description
 * @date 2017/12/26 10:54
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser, Long> {
    //通过传入对象查询

    TUser login(@Param("tUser") TUser tUser);
}

package cn.wscq.spring.domain.util;

import cn.wscq.spring.domain.model.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shuai
 * @version 1.0
 * @description 类型转换工具
 * @date 2017/12/8 10:18
 */
public class R2EHandler extends BaseTypeHandler<BaseEnum> {

    private Class<BaseEnum> javaType;

    public R2EHandler(Class<BaseEnum> javaType) {
        this.javaType = javaType;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter.getEnumValue());
    }

    @Override
    public BaseEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return r2e(rs.getInt(columnName));
    }

    @Override
    public BaseEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return r2e(rs.getInt(columnIndex));
    }

    @Override
    public BaseEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return r2e(cs.getInt(columnIndex));
    }

    private BaseEnum r2e(int result) {
        BaseEnum[] enums = javaType.getEnumConstants();
        for (BaseEnum baseEnum : enums) {
            if (baseEnum.getEnumValue() == result) {
                return baseEnum;
            }
        }
        return null;
    }
}
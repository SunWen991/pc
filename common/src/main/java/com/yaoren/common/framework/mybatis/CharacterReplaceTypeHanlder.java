package com.yaoren.common.framework.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @ClassName: CharacterReplaceTypeHanlder
 * @Description: 去除英文单引号
 * @author zxh
 * @date 2015-8-6
 * 
 */
public class CharacterReplaceTypeHanlder implements TypeHandler<String>
{

    
    public String getResult(ResultSet rs, String columnLabel) throws SQLException
    {
        return rs.getString(columnLabel);
    }

    
    public String getResult(ResultSet rs, int columnIndex) throws SQLException
    {
        return rs.getString(columnIndex);
    }

    
    public String getResult(CallableStatement cs, int parameterIndex) throws SQLException
    {
        return cs.getString(parameterIndex);
    }

    
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException
    {
        parameter = parameter.replace("'", "");
        ps.setString(i, parameter);
    }

}

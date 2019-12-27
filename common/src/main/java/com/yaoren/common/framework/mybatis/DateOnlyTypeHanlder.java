package com.yaoren.common.framework.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 
 * @ClassName: DateOnlyTypeHanlderCallback
 * @Description: 转换成日期类型
 * @author zxh
 * @date 2015-8-6
 * 
 */
public class DateOnlyTypeHanlder implements TypeHandler<Object>
{

    
    public Object getResult(ResultSet rs, String columnLabel) throws SQLException
    {
        return rs.getObject(columnLabel);
    }

    
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException
    {
        return rs.getObject(columnIndex);
    }

    
    public Object getResult(CallableStatement cs, int parameterIndex) throws SQLException
    {
        return cs.getObject(parameterIndex);
    }

    
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
            throws SQLException
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ps.setString(i, df.format(parameter));
    }

}

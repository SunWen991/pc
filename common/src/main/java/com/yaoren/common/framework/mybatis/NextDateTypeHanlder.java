package com.yaoren.common.framework.mybatis;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName: NextDateTypeHanlder
 * @Description: 计算出后一天
 * @author zxh
 * @date 2015-8-6
 *
 */
public class NextDateTypeHanlder implements TypeHandler<Object>
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
        Date date = DateUtils.addDays((Date) parameter, 1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ps.setString(i, df.format(date));
    }

}
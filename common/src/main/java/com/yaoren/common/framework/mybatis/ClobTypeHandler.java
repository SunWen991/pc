/**
 * @Title: ClobTypeHandler.java
 * @Package: com.eptison.common.framework.mybatis
 * @ClassName: ClobTypeHandler
 * @Description: TODO(大文本类型处理)
 * @author zxh
 * @date 2016-6-23
 * @version: V1.0
 */
package com.yaoren.common.framework.mybatis;


import oracle.sql.CLOB;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: ClobTypeHandler
 * @Description: 大文本类型处理
 * @author zxh
 * @date 2016-6-23
 * 
 */
public class ClobTypeHandler implements TypeHandler<Object>
{

    
    public Object getResult(ResultSet rs, String columnName) throws SQLException
    {
        CLOB clob = (CLOB) rs.getClob(columnName);
        return (clob == null || clob.length() == 0) ? null : clob.getSubString((long) 1, (int) clob
                .length());

    }

    
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("deprecation")
    public void setParameter(PreparedStatement arg0, int arg1, Object arg2, JdbcType arg3)
            throws SQLException
    {
        CLOB clob = CLOB.empty_lob();
        clob.setString(1, (String) arg2);
        arg0.setClob(arg1, clob);
    }

}
package com.yaoren.common.framework.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: MultiDataSource
 * @Description: 多数据源路由
 * @author zxh
 * @date 2015-5-27
 * 
 */
public class MultiDataSource extends AbstractRoutingDataSource
{

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource)
    {
        dataSourceKey.set(dataSource);
    }

    public static void clearDataSourceKey()
    {
        dataSourceKey.remove();
    }

    @Override
    protected Object determineCurrentLookupKey()
    {
        return dataSourceKey.get();
    }
}

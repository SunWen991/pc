package com.yaoren.common.base.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * @ClassName: BaseSearchInfo
 * @Description: 基础查询信息类
 * @author zxh
 * @date 2014-8-6
 * 
 */
public class BaseSearchInfo implements Serializable
{
    /**
     * @Fields serialVersionUID : 序列号
     */
    private static final long serialVersionUID = 8734980094290448804L;

    /**
     * 降序
     */
    public static final String DIR_DESC = "DESC";

    /**
     * 升序
     */
    public static final String DIR_ASC = "ASC";

    /**
     * in传入参数
     */
    private String[] codes;

    /**
     * 模糊查询字段
     */
    private String search;

    /**
     * 排序
     */
    private String sort;

    /**
     * 排序
     */
    private String dir;

    /**
     *页码
     */
    private int page;

    /**
     * 行数
     */
    private int rows = 10;

    /**
     * 开始
     */
    private int start;

    /**
     * 结束
     */
    private int end;

    /**
     * 总数量
     */
    private int total;

    /**
     * 其他参数查询条件map
     */
    private Map<Object, Object> paramMap;

    /**
     * @return codes
     */
    public String[] getCodes()
    {
        return codes;
    }

    /**
     * @param codes 要设置的 codes
     */
    public void setCodes(String[] codes)
    {
        this.codes = codes;
    }

    /**
     * @return search
     */
    public String getSearch()
    {
        return search;
    }

    /**
     * @param search 要设置的 search
     */
    public void setSearch(String search)
    {
        this.search = search;
    }

    /**
     * @return sort
     */
    public String getSort()
    {
        return sort;
    }

    /**
     * @param sort 要设置的 sort
     */
    public void setSort(String sort)
    {
        this.sort = sort;
    }

    /**
     * @return dir
     */
    public String getDir()
    {
        return dir;
    }

    /**
     * @param dir 要设置的 dir
     */
    public void setDir(String dir)
    {
        this.dir = dir;
    }

    /**
     * @return page
     */
    public int getPage()
    {
        return page;
    }

    /**
     * @param page 要设置的 page
     */
    public void setPage(int page)
    {
        this.page = page;
    }

    /**
     * @return rows
     */
    public int getRows()
    {
        return rows;
    }

    /**
     * @param rows 要设置的 rows
     */
    public void setRows(int rows)
    {
        this.rows = rows;
    }

    /**
     * @return start
     */
    public int getStart()
    {
        return start;
    }

    /**
     * @param start 要设置的 start
     */
    public void setStart(int start)
    {
        this.start = start;
    }

    /**
     * @return end
     */
    public int getEnd()
    {
        return end;
    }

    /**
     * @param end 要设置的 end
     */
    public void setEnd(int end)
    {
        this.end = end;
    }

    /**
     * @return total
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * @param total 要设置的 total
     */
    public void setTotal(int total)
    {
        this.total = total;
    }

    /**
     * @return paramMap
     */
    public Map<Object, Object> getParamMap()
    {
        return paramMap;
    }

    /**
     * @param paramMap 要设置的 paramMap
     */
    public void setParamMap(Map<Object, Object> paramMap)
    {
        this.paramMap = paramMap;
    }

}

package com.yaoren.common.framework.listener;

/**
 * 
 * @ClassName: OnlineCounter
 * @Description: 在线人数统计
 * @author zxh
 * @date 2014-8-6
 *
 */
public class OnlineCounter
{

    /**
     * 在线人数
     */
    private static long online = 0;

    /**
     * 
     * @Title: getOnline
     * @Description: 获取在线人数
     * @param @return
     * @return long
     * @throws
     */
    public static long getOnline()
    {
        return online;
    }

    /**
     * 
     * @Title: raise
     * @Description: 在线人数增加一位
     * @param 
     * @return void
     * @throws
     */
    public static void raise()
    {
        online++;
    }

    /**
     * 
     * @Title: reduce
     * @Description: 在线人数减少一位
     * @param 
     * @return void
     * @throws
     */
    public static void reduce()
    {
        online--;
    }

}

package com.yaoren.common.framework.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * @ClassName: CountListener
 * @Description: 在线人数统计监听器
 * @author zxh
 * @date 2015-8-6
 * 
 */
public class CountListener implements HttpSessionListener
{

    public final void sessionCreated(final HttpSessionEvent arg0)
    {
        OnlineCounter.raise();
    }

    public final void sessionDestroyed(final HttpSessionEvent arg0)
    {
        if (OnlineCounter.getOnline() > 0)
        {
            OnlineCounter.reduce();
        }
    }

}
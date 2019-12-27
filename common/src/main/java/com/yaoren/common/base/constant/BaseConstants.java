/**
 * @Title: BaseConstant.java
 * @ClassName: BaseConstants
 * @Description: 基础常量
 * @author zxh
 * @date 2016-7-7
 * @version: V1.0
 */
package com.yaoren.common.base.constant;

/**
 * @ClassName: BaseConstants
 * @Description: 基础常量
 * @author zxh
 * @date 2016-7-7
 * 
 */
public interface BaseConstants
{
    /**
     * 用户在session中的名称
     */
    String USER_SESSION = "com.eptison.user";

    /**
     * mac在session中的名称
     */
    String MAC_SESSION = "mac_session";

    /**
     * 根资源节点在session中的名称
     */
    String ROOT_RESOURCE = "root_resource";

    /**
     * 有权限的按钮资源列表在session中的名称
     */
    String BTN_RESOURCE_LIST = "btn_resource_list";

    /**
     * 当前系统在session中的名称
     */
    String CURRENT_SYS = "current_login_system";

    /**
     * 登录错误信息
     */
    String LOGIN_ERRMSG_NOUSER = "用户名或密码错误";

    /**
     * 登录错误信息
     */
    String LOGIN_ERRMSG_NOSTAFF = "账户尚未初始化";

    /**
     * 登录错误信息
     */
    String LOGIN_ERRMSG_NORESOURCE = "账户无权限";
    
    /**
     * 登录错误信息
     */
    String LOGIN_ERRMSG_ISENABLE = "账户暂未启用";
    
    /**
     * 登录错误信息
     */
    String LOGIN_ERRMSG_ISNOTEXIT = "账户不存在";

    /**
     * 管理员账户
     */
    String USER_ADMIN = "admin";
}

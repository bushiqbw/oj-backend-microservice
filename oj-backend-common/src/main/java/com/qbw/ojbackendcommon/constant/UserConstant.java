package com.qbw.ojbackendcommon.constant;

/**
 * 用户常量
 *
 * @author <a href="https://github.com/liqbw">qbw</a>
  
 */
public interface UserConstant {

    /**
     * 用户登录态键
     */
    String USER_LOGIN_STATE = "user_login";

    //  region 权限

    /**
     * 默认角色
     */
    String DEFAULT_ROLE = "user";

    /**
     * 管理员角色
     */
    String ADMIN_ROLE = "admin";

    /**
     * 被封号
     */
    String BAN_ROLE = "ban";
    /**
     * COS 访问地址：默认头像.jpg
     * todo 需替换配置
     */
    String DEFAULT_AVATAR = "";

    String DEFAULT_USERNAME = "做题家-"+String.valueOf(System.currentTimeMillis()).substring(0,5);

    // endregion
}

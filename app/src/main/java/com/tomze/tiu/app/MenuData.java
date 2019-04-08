package com.tomze.tiu.app;

import com.tomze.tiu.R;

/**
 * @author Tomze
 * @time 2019年04月07日 0:04
 * @desc 菜单Item项
 */
public class MenuData {
    /**
     * 个人界面菜单
     */
    public static Object[][] SELF_MENU = {
            {0,      "",                 0,                "",    0},
            {101, "个人", R.drawable.ic_user_info,        "",     0},
            {102, "通知", R.drawable.ic_user_nofication,  "",     0},
            {103, "反馈", R.drawable.ic_user_feedback,    "",     0},
            {104, "关于", R.drawable.ic_user_about,       "",     0},
    };

    /**
     *  用户个人信息Item
     */
    public static Object[][] USER_INFO = {
            {0, "个人信息", 0,  "",     0},
            {201, "学号", 0,  "",     0},
            {202, "姓名", 0,  "",     0},
            {203, "班级", 0,  "",     0},
            {204, "宿舍", 0,  "",     0},
            {205, "性别", 0,  "",     0},
            {206, "生日", 0,  "",     0},
            {207, "手机", 0,  "",     0},
            {208, "密码", 0,  "",     0},
    };
}

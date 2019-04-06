package com.tomze.t11.app;


import android.text.TextUtils;

import com.tomze.t11.R;
import com.tomze.t11.bean.Menu;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Tomze
 * @time 2019年04月03日 21:46
 * @desc 设置参数
 */
public class ConfigManager {
    // 默认开屏显示跳转时间
    public static int DEFAULT_JUMP_TIME = 0;

    public static Object[][] SELF_MENU = {
            {101, "个人", R.drawable.ic_user_info, "", 0},
            {102, "通知", R.drawable.ic_user_nofication, "", 0},
            {103, "反馈", R.drawable.ic_user_feedback, "", 0},
            {104, "关于", R.drawable.ic_user_about, "", 0},
    };

    /**
     * 获取个人界面菜单
     * @return
     */
    public static List<Menu> getSelfMenu() {
        List<Menu> menuList = new ArrayList<>();
        for (int i = 0; i < SELF_MENU.length; i++) {
            Menu menu = parseMenu(SELF_MENU[i]);
            if (menu == null) {
                continue;
            }
            menuList.add(menu);
        }
        return menuList;
    }

    /**
     * 解析菜单
     * @param objects
     * @return
     */
    private static Menu parseMenu(Object[] objects) {
        if (objects.length < 5) {
            return null;
        }
        Menu menu = new Menu();
        menu.menuId = (int) objects[0];
        menu.menuName = (String) objects[1];
        menu.menuDrawable = (int) objects[2];
        menu.menuRight = (String) objects[3];
        menu.menuRightPic = (int) objects[4];
        return menu;
    }
}

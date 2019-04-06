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

    /**
     * 获取菜单
     * @return
     */
    public static List<Menu> getMenu(Object[][] menus) {
        List<Menu> menuList = new ArrayList<>();
        for (int i = 0; i < menus.length; i++) {
            Menu menu = parseMenu(menus[i]);
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

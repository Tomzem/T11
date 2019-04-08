package com.tomze.t11.ui.pre;

import com.tomze.t11.base.mvp.BasePresenter;
import com.tomze.t11.bean.User;
import com.tomze.t11.ui.activity.SelfInfoActivity;
import com.tomze.t11.util.T11SharePre;

/**
 * @author Tomze
 * @time 2019年04月07日 10:24
 * @desc
 */
public class SelfInfoPresenter extends BasePresenter<SelfInfoActivity>{

    public SelfInfoPresenter(SelfInfoActivity view) {
        super(view);
    }

    public User getUserInfo(User user) {
        if (user != null) {
            return user;
        }
        return user;
    }

    /**
     *  退出登录，清空当前用户留存信息
     */
    public void outLogin(User user) {
        if (user == null) {
            return;
        }
        T11SharePre.remove("userPassword");
        T11SharePre.remove("userToken");
    }

}

package com.tomze.t11.ui.pre;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.widget.Toast;

import com.tomze.t11.base.mvp.BasePresenter;
import com.tomze.t11.bean.User;
import com.tomze.t11.ui.activity.LoginActivity;
import com.tomze.t11.util.T11SharePre;
import com.tomze.t11.util.T11Toast;

/**
 * @author Tomze
 * @time 2019年04月06日 11:32
 * @desc 登录P层
 */
public class LoginPresenter extends BasePresenter<LoginActivity> {

    public LoginPresenter(LoginActivity view) {
        super(view);
    }

    public void login(String userName, String userPassword) {
        if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(userPassword)) {
            T11Toast.error(getView().getContext(), "用户名或密码为空").show();
            return;
        }
        if (userName.equals("111111")&& userPassword.equals("111111")) {
            User user = new User();
            user.userName = userName;
            user.userPassword = userPassword;
            user.userRealName = "张三";
            saveUserInfo(user);
            getView().toJump();
            T11Toast.error(getView().getContext(), "登录成功").show();
        } else {
            T11Toast.error(getView().getContext(), "登录失败").show();
        }
    }

    /**
     *  获取本地存储的用户名，并且是否进行删除
     * @param isDelete
     * @return
     */
    public String getLocalUserName(boolean isDelete) {
        String userName = T11SharePre.getData("userName", "");
        if (isDelete) {
            T11SharePre.remove("userName");
        }
        return userName;
    }

    /**
     * 获取本地用户的真实姓名
     * @param userName
     * @return
     */
    public String getUserRealName(String userName) {
        if (TextUtils.isEmpty(userName)) {
            return "";
        }
        return T11SharePre.getData(userName, "");
    }

    /**
     * 保存登录成功的用户信息 私有方法，不提供给activity
     * @param user
     */
    private void saveUserInfo(User user) {
        if (user == null) {
            return;
        }
        T11SharePre.saveData("userName", user.userName);
        T11SharePre.saveData("userPassword", user.userPassword);
        T11SharePre.saveData("userToken", user.Token);
        T11SharePre.saveData(user.userName, user.userRealName);
    }
}

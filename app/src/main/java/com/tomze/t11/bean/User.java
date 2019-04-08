package com.tomze.t11.bean;

/**
 * @author Tomze
 * @time 2019年04月06日 11:59
 * @desc  用户bean类
 */
public class User {
    public String userName;
    public String userPassword;
    public String Token;

    public String userRealName;
    public int userSex;
    public String userDepartment;

    public User() {
    }

    public User(String userName, String userRealName, int userSex, String userDepartment) {
        this.userName = userName;
        this.userRealName = userRealName;
        this.userSex = userSex;
        this.userDepartment = userDepartment;
    }
}

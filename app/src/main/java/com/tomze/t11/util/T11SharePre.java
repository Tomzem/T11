package com.tomze.t11.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.tomze.t11.app.T11Application;

import java.util.Map;

/**
 * @author Tomze
 * @time 2019年04月04日 0:27
 * @desc SharedPreferences工具类
 */
public class T11SharePre {
    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "T11_SP_Data";
    private static Context mContext;
    private static SharedPreferences sp;

    static{
        mContext = T11Application.getContext();
        sp = mContext.getSharedPreferences(FILE_NAME, mContext.MODE_PRIVATE);
    }

    //String的保存及获取
    public static void saveData(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    public static String getData(String key, String defaluevalue) {
        return sp.getString(key, defaluevalue);
    }

    //Boolean的保存及获取
    public static void saveData(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getData(String key, boolean defaluevalue) {
        return sp.getBoolean(key, defaluevalue);
    }

    //FLOAT的保存及获取
    public static void saveData(String key, float value) {
        sp.edit().putFloat(key, value).apply();
    }

    public static float getData(String key, float defaluevalue) {
        return sp.getFloat(key, defaluevalue);
    }

    //int的保存及获取
    public static void saveData(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    public static int getData(String key, int defaluevalue) {
        return sp.getInt(key, defaluevalue);
    }

    public static Map<String,?> getAll(String configName){
        return sp.getAll();
    }

    public static void remove(String account){
        sp.edit().remove(account).apply();
    }
}

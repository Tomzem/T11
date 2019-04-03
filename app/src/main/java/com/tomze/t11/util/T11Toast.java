package com.tomze.t11.util;

import android.annotation.SuppressLint;
import android.widget.Toast;

import com.tomze.t11.app.T11Application;

/**
 * @author Tomze
 * @time 2019年04月03日 23:22
 * @desc toast 工具类
 */
@SuppressLint("ShowToast")
public class T11Toast {

    public static Toast mToast;

    public static void show(final String message){
        if (mToast == null){
            mToast = Toast.makeText(T11Application.getContext(), message, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void show(final int messageResId){
        if (mToast == null){
            mToast = Toast.makeText(T11Application.getContext(), messageResId, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(messageResId);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showL(final String message){
        if (mToast == null){
            mToast = Toast.makeText(T11Application.getContext(), message, Toast.LENGTH_LONG);
        }else{
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    public static void showL(final int messageResId){
        if (mToast == null){
            mToast = Toast.makeText(T11Application.getContext(), messageResId, Toast.LENGTH_LONG);
        }else{
            mToast.setText(messageResId);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }
}

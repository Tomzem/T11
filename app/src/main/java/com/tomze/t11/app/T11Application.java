package com.tomze.t11.app;

import android.app.Application;
import android.content.Context;

/**
 * @author Tomze
 * @time 2019年04月03日 20:56
 * @desc application
 */
public class T11Application extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    public static Context getContext() {
        return appContext != null ? appContext : getContext();
    }
}

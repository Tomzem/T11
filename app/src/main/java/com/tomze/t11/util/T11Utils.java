package com.tomze.t11.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;

import com.tomze.t11.R;

/**
 * author:Tomze
 * date:2019/4/4 15:08
 * description: 闲杂工具类集合
 */
public final class T11Utils {
    static long[] mClicks = new long[2];

    private T11Utils() {}

    public static void jump2ActivityFinish(Activity thisActivity, Class<?> cls) {
        jump2Activity(thisActivity, cls, true);
    }

    public static  void jump2ActivityNoFinish(Activity thisActivity, Class<?> cls) {
        jump2Activity(thisActivity, cls, false);
    }

    /**
     *  跳转Activity
     * @param activity
     * @param cls
     * @param isFinish
     */
    private static void jump2Activity(Activity activity, Class<?> cls, boolean isFinish) {
        if (cls != null && activity != null) {
            Intent intent = new Intent(activity, cls);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
            if (isFinish) {
                activity.finish();
            }
        }
    }

    /**
     * 判断是否双击，快速的重复请求
     * @return
     */
    public static boolean isDoubleClick() {
        System.arraycopy(mClicks, 1, mClicks, 0, mClicks.length-1);
        mClicks[mClicks.length-1] = SystemClock.uptimeMillis();
        return mClicks[0] > (SystemClock.uptimeMillis() - 500);
    }

    static Drawable tintIcon(Drawable drawable, @ColorInt int tintColor) {
        drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    static Drawable tint9PatchDrawableFrame(Context context, @ColorInt int tintColor) {
        final NinePatchDrawable toastDrawable = (NinePatchDrawable) getDrawable(context, R.drawable.toast_frame);
        return tintIcon(toastDrawable, tintColor);
    }

    static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            view.setBackground(drawable);
        else
            view.setBackgroundDrawable(drawable);
    }

    static Drawable getDrawable(Context context, @DrawableRes int id) {
        return AppCompatResources.getDrawable(context, id);
    }

    static int getColor(Context context, @ColorRes int color){
        return ContextCompat.getColor(context, color);
    }
}

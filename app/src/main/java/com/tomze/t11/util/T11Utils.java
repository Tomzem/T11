package com.tomze.t11.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;

import com.tomze.t11.R;

/**
 * author:Tomze
 * date:2019/4/4 15:08
 * description: 闲杂工具类集合
 */
public final class T11Utils {

    private T11Utils() {}

    public static Drawable tintIcon(Drawable drawable, @ColorInt int tintColor) {
        drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static Drawable tint9PatchDrawableFrame(Context context, @ColorInt int tintColor) {
        final NinePatchDrawable toastDrawable = (NinePatchDrawable) getDrawable(context, R.drawable.toast_frame);
        return tintIcon(toastDrawable, tintColor);
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            view.setBackground(drawable);
        else
            view.setBackgroundDrawable(drawable);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int id) {
        return AppCompatResources.getDrawable(context, id);
    }

    public static int getColor(Context context, @ColorRes int color){
        return ContextCompat.getColor(context, color);
    }
}

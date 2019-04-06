package com.tomze.t11.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;

import com.tomze.t11.R;

/**
 * @author Tomze
 * @time 2019年04月06日 14:53
 * @desc 圆形的TextView
 */
public class CircleTextView extends android.support.v7.widget.AppCompatTextView {

    private boolean isMan = true; // 默认男性

    public CircleTextView(Context context) {
        this(context, null);
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.setTextColor(getResources().getColor(R.color.colorWhite));
        this.setGravity(Gravity.CENTER);
        this.setTextSize(getResources().getDimension(R.dimen.font_size_7));
    }

    public void setName(String name, boolean isMan) {
        if (!TextUtils.isEmpty(name)) {
            if (name.length() < 3) {
                this.setText(name);
            } else {
                this.setText(name.substring(name.length() - 2, name.length()));
            }
        }
        this.isMan = isMan;
        this.setBackground(null);
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(getResources().getDrawable(isMan ? R.drawable.shape_circle_icon_men : R.drawable.shape_circle_icon_women));
    }
}

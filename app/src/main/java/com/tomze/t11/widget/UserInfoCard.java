package com.tomze.t11.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.tomze.t11.R;

/**
 * @author Tomze
 * @time 2019年04月06日 15:24
 * @desc
 */
public class UserInfoCard extends RelativeLayout {
    public UserInfoCard(Context context) {
        super(context, null);
    }

    public UserInfoCard(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public UserInfoCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_user_info_card, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        CircleTextView circleTextView = this.findViewById(R.id.ctv_user_name);
        circleTextView.setName("好长江", true);
    }
}

package com.tomze.tiu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tomze.tiu.R;
import com.tomze.tiu.bean.User;

/**
 * @author Tomze
 * @time 2019年04月06日 15:24
 * @desc 个人信息卡片
 */
public class UserInfoCard extends RelativeLayout {

    private CircleTextView mCtvUserRealName;
    private TextView mTvUserRealName;
    private TextView mTvUserName;
    private TextView mTvUserDepartment;

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
        mCtvUserRealName = this.findViewById(R.id.ctv_user_name);
        mTvUserRealName = this.findViewById(R.id.tv_user_real_name);
        mTvUserName = this.findViewById(R.id.tv_user_name);
        mTvUserDepartment = this.findViewById(R.id.tv_user_department);
    }

    public void setUserInfo(User userInfo) {
        mCtvUserRealName.setName(userInfo.userRealName, userInfo.userSex);
        mTvUserRealName.setText(userInfo.userRealName);
        mTvUserName.setText(userInfo.userName);
        mTvUserDepartment.setText(userInfo.userDepartment);
    }
}

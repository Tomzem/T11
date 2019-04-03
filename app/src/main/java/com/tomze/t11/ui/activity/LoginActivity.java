package com.tomze.t11.ui.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tomze.t11.R;
import com.tomze.t11.base.BaseActivity;
import com.tomze.t11.util.StatusBarUtil;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements View.OnClickListener,TextWatcher{

    @BindView(R.id.img_login_background)
    ImageView mImgLoginBackground;

    @BindView(R.id.btn_login_system)
    Button mBtLoginSystem;

    @BindView(R.id.tv_login_welcome)
    TextView mTvLoginWelcome;

    @BindView(R.id.tv_forget_password)
    TextView mTvForgetPassword;

    @BindView(R.id.et_user_name)
    EditText mEtUserName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initBefore() {
        //用来设置整体下移，状态栏沉浸
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
    }

    @Override
    protected void initView() {
        mEtUserName.addTextChangedListener(this);
        mBtLoginSystem.setOnClickListener(this);
        mTvForgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_system:
                break;
            case R.id.tv_forget_password:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String inputText = s.toString();
        if (s.toString().length() > 0) {
            String welcomeText = String.format(getResources().getString(R.string.login_welcome_username), inputText);
            mTvLoginWelcome.setText(welcomeText);
        } else {
            mTvLoginWelcome.setText(getResources().getString(R.string.login_welcome));
        }
    }
}

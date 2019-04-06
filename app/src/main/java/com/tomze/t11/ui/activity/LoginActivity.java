package com.tomze.t11.ui.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tomze.t11.R;
import com.tomze.t11.base.mvp.BasePresenterActivity;
import com.tomze.t11.ui.pre.LoginPresenter;
import com.tomze.t11.util.StatusBarUtil;
import com.tomze.t11.util.T11Toast;
import com.tomze.t11.util.T11Utils;

import butterknife.BindView;

/**
 * @author Tomze
 * @time 2019年04月03日 21:03
 * @desc Activity登录
 */
public class LoginActivity extends BasePresenterActivity<LoginPresenter> implements View.OnClickListener,TextWatcher{

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

    @BindView(R.id.et_user_password)
    EditText mEtUserPassword;

    // 登录按钮默认不能点击
    private boolean isLoginBtnClick = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initBefore() {
        super.initBefore();
        //用来设置整体下移，状态栏沉浸
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        //获取本地存储的当前登陆过的用户信息
        String localName = mPresenter.getLocalUserName(true);
        if (!TextUtils.isEmpty(localName)) {
            // 设置在用户名上，并将该信息删除
            mEtUserName.setText(localName);
            String userRealName = mPresenter.getUserRealName(localName);
            setUserRealName(userRealName);
        }
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initView() {
        mEtUserName.addTextChangedListener(this);
        mEtUserPassword.addTextChangedListener(this);
        mBtLoginSystem.setOnClickListener(this);
        mTvForgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_system:
                if (!isLoginBtnClick) {
                    return;
                }
                mPresenter.login(mEtUserName.getText().toString(), mEtUserPassword.getText().toString());
                break;
            case R.id.tv_forget_password:
                break;
        }
    }

    public void toJump() {
        T11Utils.jump2ActivityFinish(this, MainActivity.class);
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
        String inputUserName = mEtUserName.getText().toString().trim();
        String inputUserPassword = mEtUserPassword.getText().toString().trim();
        if (inputUserPassword.length() < 6) {
            isLoginBtnClick = false;
            mBtLoginSystem.setBackgroundResource(R.drawable.login_button_dis_enable);
        }
        if (TextUtils.isEmpty(inputText)) {
            isLoginBtnClick = false;
        } else if (inputText.equals(inputUserName)) {
            // 输入用户名
            setUserRealName(mPresenter.getUserRealName(inputUserName));
        }
        //输入密码
        if (inputUserPassword.length() > 5 && inputUserName.length() > 5) {
            isLoginBtnClick = true;
            mBtLoginSystem.setBackgroundResource(R.drawable.login_button_selector);
        }
    }

    private void setUserRealName(String userRealName) {
        if (TextUtils.isEmpty(userRealName)) {
            mTvLoginWelcome.setText(getResources().getString(R.string.login_welcome));
        } else {
            String welcomeText = String.format(getResources().getString(R.string.login_welcome_username), userRealName);
            mTvLoginWelcome.setText(welcomeText);
        }
    }
}

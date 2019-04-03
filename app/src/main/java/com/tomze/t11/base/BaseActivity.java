package com.tomze.t11.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tomze.t11.util.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Tomze
 * @time 2019年04月03日 21:03
 * @desc
 */
public abstract class BaseActivity extends Activity {

    private Unbinder unbinder;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //ButterKnife
        unbinder = ButterKnife.bind(this);
        mContext = this;

        //沉浸式代码配置
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this, true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this, 0x55000000);
        }
        //初始化
        initBefore();
        initToolbar();
        initView();
        initData();
    }

    /**
     * 初始化toolbar
     */
    protected void initToolbar() {
    }

    /**
     * 初始化data
     */
    protected void initData() {
    }

    /**
     * 初始化view
     */
    protected void initView() {
    }

    /**
     * 最新初始化
     */
    protected void initBefore() {
    }

    /**
     * 获取布局的id
     */
    protected abstract int getLayoutId();

    /**
     * 准备销毁
     */
    protected void readyDestroy(){}

    @Override
    protected void onDestroy() {
        readyDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}

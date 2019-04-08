package com.tomze.tiu.base.mvp;


import android.content.Context;

import com.tomze.tiu.app.T11Application;
import com.tomze.tiu.base.BaseActivity;

/**
 * @author Tomze
 * @time 2019年04月06日 11:30
 * @desc Activity P
 */
public abstract class BasePresenterActivity<T extends BasePre> extends BaseActivity implements BaseView<T> {
    protected T mPresenter;

    @Override
    protected void initBefore() {
        super.initBefore();
        this.mPresenter = initPresenter();
    }

    /**
     * 初始化和View相关联的P层
     */
    protected abstract T initPresenter();

    /**
     * 设置P层
     */
    @Override
    public void setPresenter(T presenter) {
        this.mPresenter = presenter;
    }

    public Context getContext() {
        if (mContext != null){
            return mContext;
        } else {
            return T11Application.getContext();
        }
    }
}

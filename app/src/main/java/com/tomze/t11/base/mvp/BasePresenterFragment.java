package com.tomze.t11.base.mvp;

import android.content.Context;

import com.tomze.t11.base.BaseFragment;


/**
 * @author Tomze
 * @time 2019年04月06日 11:30
 * @desc Fragment P
 */
public abstract class BasePresenterFragment<T extends BasePre> extends BaseFragment implements BaseView<T> {
    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mPresenter = initPresenter();
    }

    /**
     * 初始化和View相关联的P层
     */
    protected abstract T initPresenter();

    @Override
    public void setPresenter(T presenter) {
        this.mPresenter = presenter;
    }
}

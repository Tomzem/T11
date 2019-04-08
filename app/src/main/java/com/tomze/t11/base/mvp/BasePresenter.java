package com.tomze.t11.base.mvp;


/**
 * @author Tomze
 * @time 2019年04月06日 11:30
 * @desc 基础P类
 */
public abstract class BasePresenter<T extends BaseView> implements BasePre {
    protected T mView;

    public BasePresenter(T view) {
        this.mView = view;
    }

    /**
     * 设置View层
     */
    public void setView(T mView) {
        this.mView = mView;
    }

    /**
     * 获取View层
     */
    public T getView() {
        return mView;
    }
}

package com.tomze.tiu.base.mvp;


/**
 * @author Tomze
 * @time 2019年04月06日 11:30
 * @desc View
 */
public interface BaseView<T extends BasePre> {
    /**
     * 设置View相关的P层
     */
    void setPresenter(T presenter);
}

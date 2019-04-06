package com.tomze.t11.ui.fragment;

import com.tomze.t11.R;
import com.tomze.t11.base.mvp.BasePresenterFragment;
import com.tomze.t11.ui.pre.SelfPresenter;

/**
 * @author Tomze
 * @time 2019年04月06日 13:50
 * @desc
 */
public class SelfFragment extends BasePresenterFragment<SelfPresenter>{

    @Override
    protected SelfPresenter initPresenter() {
        return new SelfPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_self;
    }
}

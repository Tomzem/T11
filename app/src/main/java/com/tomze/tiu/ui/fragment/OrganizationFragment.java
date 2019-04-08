package com.tomze.tiu.ui.fragment;

import com.tomze.tiu.R;
import com.tomze.tiu.base.mvp.BasePresenterFragment;
import com.tomze.tiu.ui.pre.OrganizationPresenter;

/**
 * @author Tomze
 * @time 2019年04月06日 13:49
 * @desc
 */
public class OrganizationFragment extends BasePresenterFragment<OrganizationPresenter> {
    @Override
    protected OrganizationPresenter initPresenter() {
        return new OrganizationPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_organization;
    }
}

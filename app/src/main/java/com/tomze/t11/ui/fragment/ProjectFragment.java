package com.tomze.t11.ui.fragment;

import com.tomze.t11.R;
import com.tomze.t11.base.mvp.BasePresenterFragment;
import com.tomze.t11.ui.pre.ProjectPresenter;

/**
 * @author Tomze
 * @time 2019年04月06日 13:49
 * @desc
 */
public class ProjectFragment extends BasePresenterFragment<ProjectPresenter> {
    @Override
    protected ProjectPresenter initPresenter() {
        return new ProjectPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }
}

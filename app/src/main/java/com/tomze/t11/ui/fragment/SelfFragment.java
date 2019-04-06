package com.tomze.t11.ui.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tomze.t11.R;
import com.tomze.t11.app.ConfigManager;
import com.tomze.t11.base.mvp.BasePresenterFragment;
import com.tomze.t11.bean.Menu;
import com.tomze.t11.ui.adapter.MenuAdapter;
import com.tomze.t11.ui.pre.SelfPresenter;
import com.tomze.t11.widget.UserInfoCard;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author Tomze
 * @time 2019年04月06日 13:50
 * @desc
 */
public class SelfFragment extends BasePresenterFragment<SelfPresenter>{

    @BindView(R.id.rv_self_menu)
    RecyclerView mRvSelfMenu;

    @BindView(R.id.uic_user_info)
    UserInfoCard mUicUserInfo;

    @Override
    protected SelfPresenter initPresenter() {
        return new SelfPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_self;
    }

    @Override
    protected void initBefore(View view) {
        super.initBefore(view);
        MenuAdapter menuAdapter = new MenuAdapter(ConfigManager.getSelfMenu(), mContext, R.layout.item_menu_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvSelfMenu.setLayoutManager(linearLayoutManager);
        mRvSelfMenu.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        mRvSelfMenu.setAdapter(menuAdapter);
    }
}

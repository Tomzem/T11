package com.tomze.t11.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.tomze.t11.R;
import com.tomze.t11.app.ConfigManager;
import com.tomze.t11.app.MenuData;
import com.tomze.t11.base.mvp.BasePresenterActivity;
import com.tomze.t11.bean.Menu;
import com.tomze.t11.ui.adapter.SelfInfoAdapter;
import com.tomze.t11.ui.pre.SelfInfoPresenter;
import com.tomze.t11.util.T11Utils;

import java.util.List;

import butterknife.BindView;

public class SelfInfoActivity extends BasePresenterActivity<SelfInfoPresenter> implements View.OnClickListener {

    @BindView(R.id.rv_user_info)
    RecyclerView mRvUserInfo;

    @BindView(R.id.btn_out_login)
    Button mBtnOutLogin;

    private SelfInfoAdapter selfInfoAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_self_info;
    }

    @Override
    protected SelfInfoPresenter initPresenter() {
        return new SelfInfoPresenter(this);
    }

    @Override
    protected void initBefore() {
        super.initBefore();
        selfInfoAdapter = new SelfInfoAdapter(T11Utils.getMenu(MenuData.USER_INFO), mContext, R.layout.item_self_info_layout);
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvUserInfo.setLayoutManager(linearLayoutManager);
        mRvUserInfo.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        mBtnOutLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        mRvUserInfo.setAdapter(selfInfoAdapter);
        ConfigManager.CURRENT_USER = mPresenter.getUserInfo(ConfigManager.CURRENT_USER);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_out_login:
                mPresenter.outLogin(ConfigManager.CURRENT_USER);
                break;
        }
    }

    public void updateInfoList(List<Menu> menus) {
        if (menus != null) {
            selfInfoAdapter.refresh(menus);
        }
    }
}

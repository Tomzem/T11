package com.tomze.t11.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tomze.t11.R;
import com.tomze.t11.app.ConfigManager;
import com.tomze.t11.app.MenuData;
import com.tomze.t11.base.BaseActivity;
import com.tomze.t11.ui.adapter.MenuAdapter;

import butterknife.BindView;

public class SelfInfoActivity extends BaseActivity {

    @BindView(R.id.rv_user_info)
    RecyclerView mRvUserInfo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_self_info;
    }

    @Override
    protected void initBefore() {
        super.initBefore();
        //TODO:  为了维护 尽量不用同一个Adapter
        MenuAdapter menuAdapter = new MenuAdapter(ConfigManager.getMenu(MenuData.USER_INFO), mContext, R.layout.item_menu_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvUserInfo.setLayoutManager(linearLayoutManager);
        mRvUserInfo.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        mRvUserInfo.setAdapter(menuAdapter);
    }
}

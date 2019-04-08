package com.tomze.tiu.ui.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tomze.tiu.R;
import com.tomze.tiu.app.MenuData;
import com.tomze.tiu.base.BaseRecycler;
import com.tomze.tiu.base.mvp.BasePresenterFragment;
import com.tomze.tiu.bean.Menu;
import com.tomze.tiu.bean.User;
import com.tomze.tiu.ui.activity.SelfInfoActivity;
import com.tomze.tiu.ui.adapter.MenuAdapter;
import com.tomze.tiu.ui.pre.SelfPresenter;
import com.tomze.tiu.util.T11Utils;
import com.tomze.tiu.widget.UserInfoCard;

import butterknife.BindView;

/**
 * @author Tomze
 * @time 2019年04月06日 13:50
 * @desc
 */
public class SelfFragment extends BasePresenterFragment<SelfPresenter> implements BaseRecycler.Adapter.OnItemClickListener<Menu>{

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

        mUicUserInfo.setUserInfo(new User("1418014016", "毛宁",
                2, "数计学院/体育部"));
        MenuAdapter menuAdapter = new MenuAdapter(T11Utils.getMenu(MenuData.SELF_MENU), mContext, R.layout.item_menu_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvSelfMenu.setLayoutManager(linearLayoutManager);
        mRvSelfMenu.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        mRvSelfMenu.setAdapter(menuAdapter);
        menuAdapter.setOnItemCLickListener(this);
    }

    @Override
    public void onItemClick(BaseRecycler.ViewHolder holder, int position, Menu menu) {
        switch (menu.menuId) {
            case 101:
                T11Utils.jump2ActivityNoFinish(this.getActivity(), SelfInfoActivity.class);
                break;
        }
    }
}

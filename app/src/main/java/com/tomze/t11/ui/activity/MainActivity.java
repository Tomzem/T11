package com.tomze.t11.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tomze.t11.R;
import com.tomze.t11.ui.fragment.OrganizationFragment;
import com.tomze.t11.ui.fragment.ProjectFragment;
import com.tomze.t11.ui.fragment.SelfFragment;
import com.tomze.t11.util.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Tomze
 * @time 2019年04月03日 21:03
 * @desc Activity基类
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ibt_project)
    ImageButton mIbtProject;

    @BindView(R.id.ibt_organization)
    ImageButton mIbtOrganization;

    @BindView(R.id.ibt_self)
    ImageButton mIbtSelf;

    @BindView(R.id.tv_project)
    TextView mTvProject;

    @BindView(R.id.tv_organization)
    TextView mTvOrganization;

    @BindView(R.id.tv_self)
    TextView mTvSelf;

    private OrganizationFragment mFmOrganization;
    private ProjectFragment mFmProject;
    private SelfFragment mFmSelf;
    private Unbinder unbinder;
    private int selectIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        StatusBarUtil.setStatusBarDarkTheme(this, true);
        StatusBarUtil.setStatusBarColor(this, getResources().getColor(R.color.colorBackground));
        unbinder = ButterKnife.bind(this);
        setSelect(0);
    }

    @OnClick({R.id.tab_project,R.id.tab_organization,R.id.tab_self})
    public void onClickTab(View view){
        switch(view.getId()){
            case R.id.tab_project:setSelect(0);break;
            case R.id.tab_organization:setSelect(1);break;
            case R.id.tab_self:setSelect(2);break;
        }
    }

    private void setSelect(int i) {
        if (selectIndex == i) {
            return;
        }
        selectIndex = i;
        resetImg();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                if (mFmProject ==null){
                    mFmProject = new ProjectFragment();
                    transaction.add(R.id.frame_main, mFmProject);
                }
                transaction.show(mFmProject);
                mIbtProject.setImageResource(R.drawable.ic_bottom_project_selected);
                mTvProject.setTextColor(getResources().getColor(R.color.colorBottomIcon));
                break;
            case 1:
                if (mFmOrganization==null){
                    mFmOrganization = new OrganizationFragment();
                    transaction.add(R.id.frame_main,mFmOrganization);
                }
                transaction.show(mFmOrganization);
                mIbtOrganization.setImageResource(R.drawable.ic_bottom_group_selected);
                mTvOrganization.setTextColor(getResources().getColor(R.color.colorBottomIcon));
                break;
            case 2:
                if (mFmSelf ==null){
                    mFmSelf = new SelfFragment();
                    transaction.add(R.id.frame_main, mFmSelf);
                }
                transaction.show(mFmSelf);
                mIbtSelf.setImageResource(R.drawable.ic_bottom_self_selected);
                mTvSelf.setTextColor(getResources().getColor(R.color.colorBottomIcon));
                break;
        }
        transaction.commit();
    }

    /**
     * 将所有Fragment隐藏起来
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (mFmProject!=null){
            transaction.hide(mFmProject);
        }
        if (mFmOrganization!=null){
            transaction.hide(mFmOrganization);
        }
        if(mFmSelf!=null) {
            transaction.hide(mFmSelf);
        }
    }

    /**
     * 将所有图片切换成暗色
     */
    private void resetImg() {
        mIbtProject.setImageResource(R.drawable.ic_bottom_project);
        mIbtOrganization.setImageResource(R.drawable.ic_bottom_group);
        mIbtSelf.setImageResource(R.drawable.ic_bottom_self);
        mTvProject.setTextColor(getResources().getColor(R.color.colorBlack));
        mTvOrganization.setTextColor(getResources().getColor(R.color.colorBlack));
        mTvSelf.setTextColor(getResources().getColor(R.color.colorBlack));
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}

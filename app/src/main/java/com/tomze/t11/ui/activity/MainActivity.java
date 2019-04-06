package com.tomze.t11.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tomze.t11.R;
import com.tomze.t11.ui.fragment.OrganizationFragment;
import com.tomze.t11.ui.fragment.ProjectFragment;
import com.tomze.t11.ui.fragment.SelfFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Tomze
 * @time 2019年04月03日 21:03
 * @desc Activity基类
 */
public class MainActivity extends AppCompatActivity {

    private OrganizationFragment mFmOrganization;
    private ProjectFragment mFmProject;
    private SelfFragment mFmSelf;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSelect(2);
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
                break;
            case 1:
                if (mFmOrganization==null){
                    mFmOrganization = new OrganizationFragment();
                    transaction.add(R.id.frame_main,mFmOrganization);
                }
                transaction.show(mFmOrganization);
                break;
            case 2:
                if (mFmSelf ==null){
                    mFmSelf = new SelfFragment();
                    transaction.add(R.id.frame_main, mFmSelf);
                }
                transaction.show(mFmSelf);
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
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}

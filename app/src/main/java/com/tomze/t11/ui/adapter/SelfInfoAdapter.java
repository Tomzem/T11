package com.tomze.t11.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.tomze.t11.R;
import com.tomze.t11.base.BaseRecycler;
import com.tomze.t11.bean.Menu;

import java.util.List;

/**
 * @author Tomze
 * @time 2019年04月07日 0:17
 * @desc 个人信息Adapter
 */
public class SelfInfoAdapter extends BaseRecycler.Adapter<Menu>{

    public SelfInfoAdapter(List<Menu> mDataSource, Context mContext, int resID) {
        super(mDataSource, mContext, resID);
    }

    @Override
    protected void initView(BaseRecycler.ViewHolder holder, int position) {
        Menu menu = mDataSource.get(position);
        boolean isShow = !(menu.menuId == 0);
        holder.getContentView().setBackgroundColor(mContext.getResources().getColor(isShow ? R.color.colorWhite : R.color.colorTransparent));
        TextView mTvTitle = holder.getView(R.id.tv_title_name);
        mTvTitle.setText(TextUtils.isEmpty(menu.menuName) ? "" : menu.menuName);
        holder.isShow(mTvTitle, !isShow);

        TextView mTvName = holder.getView(R.id.tv_menu_name);
        mTvName.setText(TextUtils.isEmpty(menu.menuName) ? "" : menu.menuName);
        holder.isShow(mTvName, isShow);

        TextView mTvRight = holder.getView(R.id.tv_menu_right);
        mTvRight.setText(TextUtils.isEmpty(menu.menuRight) ? "" : menu.menuRight);
        holder.isShow(mTvRight, isShow);

        ImageView mImgMore = holder.getView(R.id.img_menu_more);
        mImgMore.setImageResource(menu.menuRightPic < 0 ? 0 : menu.menuRightPic);
        holder.isShow(mImgMore, isShow);
    }
}

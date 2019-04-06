package com.tomze.t11.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @author Tomze
 * @time 2019年04月06日 17:56
 * @desc RecyclerView Adapter和ViewHolder基类
 */
public class BaseRecycler {

    public static abstract class Adapter<T> extends RecyclerView.Adapter {

        protected List<T> mDataSource;
        protected Context mContext;
        private int resID;

        public Adapter(List<T> mDataSource, Context mContext, int resID) {
            this.mDataSource = mDataSource;
            this.mContext = mContext;
            this.resID = resID;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new BaseRecycler.ViewHolder(LayoutInflater.from(mContext).inflate(resID, null), mContext);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
            ViewHolder holder = (ViewHolder)viewHolder;
            initView(holder, position);
        }

        protected abstract void initView(ViewHolder holder, int position);

        @Override
        public int getItemCount() {
            return mDataSource == null ? 0 : mDataSource.size();
        }

        public void refresh(List<T> dataSource) {
            mDataSource = dataSource;
            this.notifyDataSetChanged();
        }

        public void deleteList(int position) {
            mDataSource.remove(position);
            this.notifyDataSetChanged();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private View mContentView;
        private SparseArray<View> mSparseArray = new SparseArray<>();
        private Context mContext;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.mContentView = itemView;
            this.mContext = context;
        }

        public View getContentView() {
            return mContentView;
        }

        /**
         * 通过控件的Id获取对于的控件，如果没有则加入mSparseArray
         *
         * @param id
         * @param <T>
         * @return
         */
        public <T extends View> T getView(int id) {
            View view = mSparseArray.get(id);
            if (view == null) {
                view = mContentView.findViewById(id);
                mSparseArray.append(id, view);
            }
            return (T) view;
        }

        /**
         * 为TextView设置数据
         *
         * @param id
         * @param text
         * @return
         */
        public ViewHolder setText(int id, String text) {
            TextView view = getView(id);
            view.setText(Html.fromHtml(text));
            return this;
        }

        public ViewHolder setImageByUrl(int id, String url) {
            ImageView view = getView(id);
            Glide.with(mContext).load(url).into(view);
            return this;
        }

        public ViewHolder setImageResource(int id, int resId) {
            ImageView view = getView(id);
            view.setImageResource(resId);
            return this;
        }

        public ViewHolder setImageBitmap(int id, Bitmap bitmap) {
            ImageView view = getView(id);
            view.setImageBitmap(bitmap);
            return this;
        }

        public ViewHolder isShow(View view, boolean isShow) {
            view.setVisibility(isShow ? View.VISIBLE : View.GONE);
            return this;
        }

        public ViewHolder isShow(int id, boolean isShow) {
            View view = getView(id);
            view.setVisibility(isShow ? View.VISIBLE : View.GONE);
            return this;
        }
    }
}

package com.sidney.multiitem.adapter.holder;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

/**
 * 描 述：Head Foot 的ViewHolderManager
 * 作 者：hxl  2022/1/28 14:55
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 14:55
 * 修改版本：
 */
public class HeadFootHolderManager<T> extends ViewHolderManager<T, BaseViewHolder> {
    private View itemView;

    public HeadFootHolderManager(View view) {
        this.itemView = view;
    }

    public HeadFootHolderManager() {

    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        BaseViewHolder viewHolder = new BaseViewHolder(getItemView(parent));
        return viewHolder;
    }

    @Override
    protected View getItemView(ViewGroup parent) {
        if (itemView != null) {
            return itemView;
        } else {
            return super.getItemView(parent);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, T t) {

    }

    @Override
    protected int getItemLayoutId() {
        return 0;
    }

    @Override
    public boolean isFullSpan() {
        return true;
    }
}

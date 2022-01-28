package com.sidney.multiitem.adapter.holder;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

/**
 * 描 述：ViewHolder的封装
 * 作 者：hxl  2022/1/28 14:51
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 14:51
 * 修改版本：
 */
public abstract class BaseViewHolderManager<T> extends ViewHolderManager<T, BaseViewHolder> {
    @Override
    public abstract void onBindViewHolder(BaseViewHolder holder, T t);

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        BaseViewHolder viewHolder = new BaseViewHolder(getItemView(parent));
        onCreateViewHolder(viewHolder);
        return viewHolder;
    }

    protected void onCreateViewHolder(@NonNull BaseViewHolder holder) {
    }

}
package com.sidney.multiitem.adapter.holder;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * 描 述：数据绑定ViewHolderManager
 * 作 者：hxl  2022/1/28 14:52
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 14:52
 * 修改版本：
 */
public abstract class BindViewHolderManager<T> extends BaseViewHolderManager<T> {
    {
        enableDataBind();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, T data) {
        ViewDataBinding dataBinding = DataBindingUtil.getBinding(holder.itemView);
        onBindViewHolder(dataBinding, data);
//        dataBinding.executePendingBindings();
    }

    /**
     * 绑定数据到视图
     *
     * @param dataBinding item视图对应dataBinding类
     * @param data        数据源
     */
    protected abstract void onBindViewHolder(ViewDataBinding dataBinding, T data);

    @Override
    protected abstract int getItemLayoutId();
}

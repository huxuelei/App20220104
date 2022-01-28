package com.sidney.multiitem.item;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.sidney.multiitem.adapter.holder.BaseViewHolder;

/**
 * 描 述：数据绑定的录入Item
 * 作 者：hxl  2022/1/28 15:27
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:27
 * 修改版本：
 */
public abstract class DataBindItemInput<T extends BaseItemInput> extends BaseItemInput<T> {

    {
        enableDataBind();
    }

    /**
     * @param key 录入对应key
     */
    public DataBindItemInput(String key) {
        super(key);
    }

    @Override
    protected void initInputView(BaseViewHolder holder) {
        ViewDataBinding dataBinding = DataBindingUtil.getBinding(holder.itemView);
        initInputView(dataBinding);
    }

    /**
     * 通过ViewDataBinding初始化Input视图
     *
     * @param dataBinding
     * @see //InputHolderManager#initInputView(BaseViewHolder)
     */
    protected abstract void initInputView(ViewDataBinding dataBinding);

}
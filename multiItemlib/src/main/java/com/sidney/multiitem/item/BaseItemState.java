package com.sidney.multiitem.item;


import androidx.annotation.NonNull;

import com.sidney.multiitem.adapter.holder.BindViewHolderManager;
import com.sidney.multiitem.adapter.holder.ViewHolderManager;
import com.sidney.multiitem.listener.OnStateClickListener;

/**
 * 描 述：基础的状态页Item（如：空白页 错误页...）
 * 作 者：hxl  2022/1/28 15:27
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:27
 * 修改版本：
 */
public abstract class BaseItemState<T extends BaseItemState> extends BindViewHolderManager<T> implements ItemManager {
    protected OnStateClickListener onStateClickListener;


    public OnStateClickListener getOnStateClickListener() {
        return onStateClickListener;
    }

    /**
     * 设置状态页面中按钮的点击监听
     *
     * @param onStateClickListener OnStateClickListener
     */
    public void setOnStateClickListener(OnStateClickListener onStateClickListener) {
        this.onStateClickListener = onStateClickListener;
    }

    @Override
    public ViewHolderManager getViewHolderManager() {
        return this;
    }


    @NonNull
    @Override
    public String getItemTypeName() {
        return toString();
    }


}

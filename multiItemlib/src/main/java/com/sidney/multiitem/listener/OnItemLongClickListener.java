package com.sidney.multiitem.listener;

import android.view.View;

import com.sidney.multiitem.adapter.holder.BaseViewHolder;

/**
 * 描 述：Item长按监听类
 * 作 者：hxl  2022/1/28 15:30
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:30
 * 修改版本：
 */
public abstract class OnItemLongClickListener implements View.OnLongClickListener {

    @Override
    public boolean onLongClick(View v) {
        BaseViewHolder viewHolder = ListenerUtil.getViewHolderByItemView(v);
        if (viewHolder == null) {
            return false;
        }

        onItemLongClick(viewHolder);
        return true;
    }

    /**
     * 点击回调 可以通过viewHolder get到需要的数据
     */
    protected abstract void onItemLongClick(BaseViewHolder viewHolder);

}

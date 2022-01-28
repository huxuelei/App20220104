package com.sidney.multiitem.listener;

import android.view.View;

import com.sidney.multiitem.adapter.holder.BaseViewHolder;

/**
 * 描 述：Item点击监听类
 * 作 者：hxl  2022/1/28 15:29
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:29
 * 修改版本：
 */
public abstract class OnItemClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        BaseViewHolder viewHolder = ListenerUtil.getViewHolderByItemView(v);
        if (viewHolder == null) {
            return;
        }

        onItemClick(viewHolder);
    }

    /**
     * 点击回调 可以通过viewHolder get到需要的数据
     */
    public abstract void onItemClick(BaseViewHolder viewHolder);


}

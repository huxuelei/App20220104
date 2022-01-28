package com.sidney.multiitem.adapter.holder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 描 述：RecyclerView的view holder
 * 增加一些属性和方法，方便使用
 * 作 者：hxl  2022/1/28 14:41
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 14:41
 * 修改版本：
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    public ViewHolderManager viewHolderManager;
    public Object itemData;


    public BaseViewHolder(View itemView) {
        super(itemView);
    }


    public Object getItemData() {
        return itemData;
    }

    /**
     * header和footer的个数也计算在内
     * {@link #getAdapterPosition()}
     */
    public int getItemPosition() {
        return getAdapterPosition();
    }

    public ViewHolderManager getViewHolderManager() {
        return viewHolderManager;
    }

}

package com.sidney.multiitem.listener;

import android.util.Log;
import android.view.View;

import com.sidney.multiitem.adapter.holder.BaseViewHolder;
import com.sidney.multiitem.common.MultiItemConstant;

/**
 * 描 述：
 * 作 者：hxl  2022/1/28 15:29
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:29
 * 修改版本：
 */
public class ListenerUtil {
    /**
     * 通过点击的item view获取到BaseViewHolder
     *
     * @return BaseViewHolder
     */
    public static BaseViewHolder getViewHolderByItemView(View view) {
        Object tag = view.getTag(MultiItemConstant.VIEW_HOLDER_TAG);
        if (tag == null || !(tag instanceof BaseViewHolder)) {
            Log.e("BaseViewHolder", "没有通过item view的tag没获取到ViewHolder");
            return null;
        }
        return (BaseViewHolder) tag;
    }

}

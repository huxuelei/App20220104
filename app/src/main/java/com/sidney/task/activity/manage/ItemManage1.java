package com.sidney.task.activity.manage;

import android.content.Context;
import android.widget.TextView;

import com.sidney.multiitem.adapter.holder.BaseViewHolder;
import com.sidney.multiitem.adapter.holder.BaseViewHolderManager;
import com.sidney.task.R;
import com.sidney.task.model.ManageBean1;

/**
 * 描 述：
 * 作 者：hxl 2022/1/28 15:51
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/28 15:51
 * 修改版本： XXX
 */
public class ItemManage1<T extends ManageBean1> extends BaseViewHolderManager<T> {

    private Context mContext;

    public ItemManage1(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, T t) {
        TextView tv_content = getView(holder, R.id.tv_content);
        tv_content.setText(t.getId());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_manage1;
    }
}

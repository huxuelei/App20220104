package com.sidney.task.activity.manage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.sidney.multiitem.adapter.holder.BaseViewHolder;
import com.sidney.multiitem.adapter.holder.BaseViewHolderManager;
import com.sidney.task.R;
import com.sidney.task.model.ManageBean2;

/**
 * 描 述：
 * 作 者：hxl 2022/1/28 15:51
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/28 15:51
 * 修改版本： XXX
 */
public class ItemManage2<T extends ManageBean2> extends BaseViewHolderManager<T> {

    private Context mContext;

    public ItemManage2(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, T t) {
        View view = getView(holder, R.id.dyn_details_interval_view);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(getScreenWidth(mContext),
                dip2px(mContext, t.getId()));
        view.setLayoutParams(layoutParams);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_manage2;
    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}

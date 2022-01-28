package com.sidney.multiitem.item;

import android.view.View;

/**
 * 描 述：
 * 作 者：hxl  2022/1/28 15:27
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:27
 * 修改版本：
 */
public class BaseItemData implements ItemData {
    protected int visibility = View.VISIBLE;

    @Override
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @Override
    public int getVisibility() {
        return visibility;
    }
}

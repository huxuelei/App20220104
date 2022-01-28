package com.sidney.multiitem.item;

import android.view.View;

/**
 * 描 述：
 * 作 者：hxl  2022/1/28 15:28
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:28
 * 修改版本：
 */
public interface ItemData {

    /**
     * {@link View#setVisibility(int)}
     *
     * @param visibility @Visibility
     */
    void setVisibility(int visibility);

    /**
     * {@link View#getVisibility()}
     *
     * @return @Visibility
     */
    int getVisibility();
}

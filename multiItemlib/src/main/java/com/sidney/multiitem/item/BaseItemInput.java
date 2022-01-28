package com.sidney.multiitem.item;


import androidx.annotation.NonNull;

import com.sidney.multiitem.adapter.holder.InputHolderManager;

/**
 * 描 述：
 * 作 者：hxl  2022/1/28 15:22
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:22
 * 修改版本：
 */
public abstract class BaseItemInput<T extends BaseItemInput> extends InputHolderManager<T> implements ItemInput {
    protected String key;

    /**
     * @param key 录入对应key
     */
    public BaseItemInput(String key) {
        this.key = key;
    }


    @NonNull
    @Override
    public String getItemTypeName() {
        return toString();
    }

    @Override
    public InputHolderManager getViewHolderManager() {
        return this;
    }

    @Override
    public String getKey() {
        return key;
    }

}

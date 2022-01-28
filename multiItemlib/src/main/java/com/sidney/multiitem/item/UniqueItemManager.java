package com.sidney.multiitem.item;

import com.sidney.multiitem.adapter.holder.BaseViewHolder;
import com.sidney.multiitem.adapter.holder.ViewHolderManager;

/**
 * 描 述： 唯一Item
 * getItemTypeName时返回toString作为唯一标示，使得本item对应的ViewHolderManager不可复用
 * 作 者：hxl  2022/1/28 15:13
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:13
 * 修改版本：
 */
public class UniqueItemManager implements ItemManager {
    private ViewHolderManager<? extends UniqueItemManager, ? extends BaseViewHolder> manager;

    public UniqueItemManager(ViewHolderManager<? extends UniqueItemManager, ? extends BaseViewHolder> manager) {
        this.manager = manager;
    }

    @Override
    public String getItemTypeName() {
        return toString();
    }

    @Override
    public ViewHolderManager getViewHolderManager() {
        return manager;
    }
}

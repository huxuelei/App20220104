package com.sidney.multiitem.item;

import androidx.annotation.NonNull;

import com.sidney.multiitem.adapter.holder.ViewHolderManager;

/**
 * 描 述：自定义Item管理类 可以获取item类型标识和ViewHolderManager
 * 作 者：hxl  2022/1/28 15:17
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:17
 * 修改版本：
 */
public interface ItemManager {
    @NonNull
    String getItemTypeName();

    /**
     * 返回自定义的ViewHolderManager，若为null则从根据本class查找注册的ViewHolderManager
     *
     * @return 返回自定义的ViewHolderManager
     */
    ViewHolderManager getViewHolderManager();
}

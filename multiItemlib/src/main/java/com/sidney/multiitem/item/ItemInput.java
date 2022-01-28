package com.sidney.multiitem.item;


import com.sidney.multiitem.adapter.holder.InputHolderManager;

/**
 * 描 述：录入Input Item接口
 * 作 者：hxl  2022/1/28 15:23
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:23
 * 修改版本：
 */
public interface ItemInput extends ItemManager {
    /**
     * 返回InputHolderManager
     *
     * @return InputHolderManager
     * @see InputHolderManager
     */
    @Override
    InputHolderManager getViewHolderManager();

}

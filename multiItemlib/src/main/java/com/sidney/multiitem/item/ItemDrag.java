package com.sidney.multiitem.item;

/**
 * 描 述：数据源Item拖动接口，实现一些move change等定制化的通用控制
 * 作 者：hxl  2022/1/28 15:28
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:28
 * 修改版本：
 */
public interface ItemDrag {
    /**
     * 是否可以在自己的Recycler中move
     *
     * @return boolean
     */
    boolean isCanMove();

    /**
     * 是否可以切换到其他Recycler
     *
     * @return boolean
     */
    boolean isCanChangeRecycler();

    /**
     * 是否可以开启拖动
     *
     * @return boolean
     */
    boolean isCanDrag();
}

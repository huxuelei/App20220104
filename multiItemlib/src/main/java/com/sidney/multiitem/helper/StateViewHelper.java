package com.sidney.multiitem.helper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sidney.multiitem.adapter.BaseItemAdapter;
import com.sidney.multiitem.item.BaseItemState;

/**
 * 描 述：状态页（如空白错误页等）辅助类
 * 状态页展示时会作为RecyclerView的唯一的Item展示在界面中
 * 注意：需要在RecyclerView设置完adapter后在初始化本实例
 * 作 者：hxl  2022/1/28 15:26
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:26
 * 修改版本：
 */
public class StateViewHelper {
    private RecyclerView recyclerView;
    private BaseItemState itemState;

    private RecyclerView.Adapter dataAdapter;
    private BaseItemAdapter stateAdapter;

    /**
     * 需要在RecyclerView设置完adapter后在初始化本实例
     *
     * @param recyclerView
     * @param itemState
     */
    public StateViewHelper(@NonNull RecyclerView recyclerView, @NonNull BaseItemState itemState) {
        this.recyclerView = recyclerView;
        //记住RecyclerView初始的Adapter
        this.dataAdapter = recyclerView.getAdapter();
        if (dataAdapter == null) {
            throw new IllegalArgumentException("请在设置完adapter后在初始化本实例！");
        }
        this.itemState = itemState;
    }

    /**
     * 展示状态页
     * <p>
     * 为RecyclerView设置新的stateAdapter，本adapter中保存唯一的状态页Item{@link BaseItemState}
     */
    public void show() {
        if (stateAdapter != null) {
            return;
        }
        stateAdapter = new BaseItemAdapter();
        stateAdapter.addDataItem(itemState);
        recyclerView.setAdapter(stateAdapter);
    }

    /**
     * 隐藏状态页
     * <p>
     * 将RecyclerView的Adapter设置为初始化时记住的Adapter
     */
    public void hide() {
        if (dataAdapter == null) {
            return;
        }
        stateAdapter = null;
        recyclerView.setAdapter(dataAdapter);
    }

}

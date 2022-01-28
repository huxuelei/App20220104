package com.sidney.multiitem.item;

import com.sidney.multiitem.adapter.holder.BaseViewHolder;

/**
 * 描 述：隐藏域的录入Item
 * 作 者：hxl  2022/1/28 15:22
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 15:22
 * 修改版本：
 */
public class HiddenItemInput extends BaseItemInput {
    protected Object value;

    /**
     * @param key   item对应key
     * @param value item对应value
     */
    public HiddenItemInput(String key, Object value) {
        super(key);
        this.value = value;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, Object o) {

    }

    @Override
    protected int getItemLayoutId() {
        return 0;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    protected void initInputView(BaseViewHolder holder) {

    }
}

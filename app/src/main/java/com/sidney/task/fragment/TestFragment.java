package com.sidney.task.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sidney.framelib.fragment.BaseFragment;
import com.sidney.framelib.mvvm.VmCommand;
import com.sidney.task.R;
import com.sidney.task.activity.TestVM;
import com.sidney.task.databinding.FragmentTestBinding;
import com.sidney.tools.JsonUtils;
import com.sidney.tools.LogUtils;

/**
 * 描 述：
 * 作 者：hxl  2022/1/4 16:00
 * 修改描述：
 * 修 改 人：xxx  2022/1/4 16:00
 * 修改版本：
 */
public class TestFragment extends BaseFragment<FragmentTestBinding, TestVM> {

    @Override
    protected void getVmCommand(VmCommand vmCommand) {
        LogUtils.e("------" + JsonUtils.toJson(vmCommand));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

    }

}
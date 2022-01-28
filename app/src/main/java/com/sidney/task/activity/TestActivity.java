package com.sidney.task.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.sidney.framelib.activity.BaseActivity;
import com.sidney.framelib.mvvm.VmCommand;
import com.sidney.task.R;
import com.sidney.task.databinding.ActivityTestBinding;
import com.sidney.tools.JsonUtils;
import com.sidney.tools.LogUtils;

public class TestActivity extends BaseActivity<ActivityTestBinding, TestVM> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void getVmCommand(VmCommand vmCommand) {
        LogUtils.e("------" + JsonUtils.toJson(vmCommand));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        binding.titlebar.setOnTitleBarListener(new OnTitleBarListener() {

            @Override
            public void onLeftClick(TitleBar titleBar) {
                showToast("左项 View 被点击");

            }

            @Override
            public void onTitleClick(TitleBar titleBar) {
                //showToast("中间 View 被点击");

            }

            @Override
            public void onRightClick(TitleBar titleBar) {
                showToast("右项 View 被点击");
            }
        });
        binding.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VmCommand vmCommand = new VmCommand("tttt", "ttttt");
                viewModel.runCommand(vmCommand);
                CoordinatorActivity.launch(mActivity);
            }
        });
        binding.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VmCommand vmCommand = new VmCommand("pppp", "ppppp");
                viewModel.runCommand(vmCommand);
                MultiActivity.launch(mActivity);
            }
        });
    }

    @Override
    public TitleBar getTitleBar() {
        return binding.titlebar;
    }

}
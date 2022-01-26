package com.sidney.task.activity;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

import com.sidney.framelib.mvvm.BaseVM;
import com.sidney.framelib.mvvm.VmCommand;

/**
 * 描 述：
 * 作 者：hxl 2022/1/14 10:46
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/14 10:46
 * 修改版本： XXX
 */
public class TestVM extends BaseVM {

    public TestVM(@NonNull Application application) {
        super(application);
    }

    @Override
    public void init() {
        VmCommand vmCommand = new VmCommand("123456", "123456");
        runCommand(vmCommand);
    }

    @Override
    public void release() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }


}

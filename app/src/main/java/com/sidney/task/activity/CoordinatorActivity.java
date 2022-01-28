package com.sidney.task.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sidney.task.R;
import com.sidney.task.model.TestBean;
import com.sidney.ui.adapter.recyclerview.CommonAdapter;
import com.sidney.ui.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 描 述：CoordinatorLayout+AppBarLayout 实现折叠式布局
 * 作 者：hxl  2022/1/27 15:46
 * 修改描述：
 * 修 改 人：xxx  2022/1/27 15:46
 * 修改版本：
 */
public class CoordinatorActivity extends AppCompatActivity {

    private RecyclerView rv;

    public static void launch(Context context) {
        Intent intent = new Intent(context, CoordinatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        rv = findViewById(R.id.rv);

        List<TestBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new TestBean("我的test----------" + i));
        }

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new CommonAdapter<TestBean>(CoordinatorActivity.this, R.layout.item_test, list) {
            @Override
            protected void convert(ViewHolder holder, TestBean testBean, int position) {
                holder.setText(R.id.tv_test, testBean.getId());
            }
        });
    }
}
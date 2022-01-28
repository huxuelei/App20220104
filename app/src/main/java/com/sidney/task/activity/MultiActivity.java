package com.sidney.task.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sidney.multiitem.adapter.BaseItemAdapter;
import com.sidney.task.R;
import com.sidney.task.activity.manage.ItemManage1;
import com.sidney.task.activity.manage.ItemManage2;
import com.sidney.task.activity.manage.ItemManage3;
import com.sidney.task.model.ManageBean1;
import com.sidney.task.model.ManageBean2;
import com.sidney.task.model.ManageBean3;

import java.util.ArrayList;
import java.util.List;

public class MultiActivity extends AppCompatActivity {

    private RecyclerView rvView;

    private GridLayoutManager gridLayoutManager;
    private BaseItemAdapter baseAdapter;

    private List totalList;

    public static void launch(Context context) {
        Intent intent = new Intent(context, MultiActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        rvView = findViewById(R.id.rv_view);

        totalList = new ArrayList();

        ManageBean1 bean1 = new ManageBean1();
        bean1.setId("123445677");
        totalList.add(bean1);

        ManageBean2 bean2 = new ManageBean2();
        bean2.setId(10);
        totalList.add(bean2);

        ManageBean3 bean3 = new ManageBean3();
        bean3.setId("9999999");
        totalList.add(bean3);

        gridLayoutManager = new GridLayoutManager(this, 6);
        rvView.setLayoutManager(gridLayoutManager);
        baseAdapter = new BaseItemAdapter();
        baseAdapter.setDataItems(totalList);
        rvView.setAdapter(baseAdapter);

        ItemManage1 itemManage1 = new ItemManage1(this);
        itemManage1.setSpanSize(6);
        baseAdapter.register(ManageBean1.class, itemManage1);

        ItemManage2 itemManage2 = new ItemManage2(this);
        itemManage2.setSpanSize(6);
        baseAdapter.register(ManageBean2.class, itemManage2);

        ItemManage3 itemManage3 = new ItemManage3(this);
        itemManage3.setSpanSize(6);
        baseAdapter.register(ManageBean3.class, itemManage3);


    }
}
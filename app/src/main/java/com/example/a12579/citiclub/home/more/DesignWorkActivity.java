package com.example.a12579.citiclub.home.more;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.home.orderdetails.OrderDetailsActivity;
import com.example.a12579.citiclub.workspace.InitData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DesignWorkActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView back;
    private DesignWorkMoreAdapter adapter;
    private List<Map<String,Object>> list = new LinkedList<>();
    private Spinner spinner_sort,spinner_type;
    private String sort,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_design_work_more);

        back = findViewById(R.id.design_work_more_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        sort = "综合推荐";
        type = "全部";


        spinner_sort = findViewById(R.id.design_work_more_spinner_sort);
        final List<String> listsort = new ArrayList<>();
        listsort.add("综合推荐");
        listsort.add("人气最高");
        listsort.add("参与最多");
        ArrayAdapter<String> arraySortAdapter = new ArrayAdapter<String>(this,R.layout.spinner_display_sort_item,R.id.spinner_sort,listsort);
        arraySortAdapter.setDropDownViewResource(R.layout.spinner_drop_down_sort_item);
        spinner_sort.setAdapter(arraySortAdapter);

        spinner_type = findViewById(R.id.design_work_more_spinner_type);
        final List<String> listtype;
        InitData initData = new InitData();
        listtype = initData.getTypeList();
        ArrayAdapter<String> arrayTypeAdapter = new ArrayAdapter<String>(this,R.layout.spinner_display_type_item,R.id.spinner_type,listtype);
        arrayTypeAdapter.setDropDownViewResource(R.layout.spinner_drop_down_type_item);
        spinner_type.setAdapter(arrayTypeAdapter);

        recyclerView = findViewById(R.id.recycler_design_work_more);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        list = initData.getDisignWorkList();

        adapter = new DesignWorkMoreAdapter(list);
        adapter.setOnItemClickListener(new DesignWorkMoreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(DesignWorkActivity.this, OrderDetailsActivity.class);
                intent.putExtra("data", (Serializable) list.get(position));
                intent.putExtra("flag","已完成");
                startActivity(intent);
            }
        });
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        //recyclerView.addItemDecoration(new SpaceItemDecoration(15));

        spinner_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = listtype.get(i);
                refreshList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                type = "全部";
            }
        });

        spinner_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sort = listsort.get(i);
                refreshList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sort = "综合推荐";
            }
        });
    }

    private void refreshList() {
        InitData initData = new InitData();
        switch (type){
            case "全部":
                list = initData.getDisignWorkList();
                break;
            case "食品":
                list = initData.getDisignWorkFoodList();
                break;
            case "汽车":
                list = initData.getDisignWorkCarList();
                break;
            case "家居":
                list = initData.getDisignWorkHomeList();
                break;
        }

        switch (sort){
            case "综合推荐":
                initData.orderByTuijian(list);
                adapter.setList(list);
                break;
            case "人气最高":
                initData.orderBySee(list);
                adapter.setList(list);
                break;
            case "参与最多":
                initData.orderByFollow(list);
                adapter.setList(list);
                break;
        }
    }
}

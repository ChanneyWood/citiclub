package com.example.a12579.citiclub.workdisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.home.casedetails.CaseDetailActivity;
import com.example.a12579.citiclub.home.more.DesignWorkActivity;
import com.example.a12579.citiclub.home.more.DesignWorkMoreAdapter;
import com.example.a12579.citiclub.home.orderdetails.OrderDetailsActivity;
import com.example.a12579.citiclub.main.MainActivity;
import com.example.a12579.citiclub.workspace.InitData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 12579 on 2018/9/10.
 */

public class WorkDisplayFragment extends Fragment{

    private RecyclerView recyclerView;
    private DesignWorkMoreAdapter adapter;
    private List<Map<String,Object>> list = new LinkedList<>();
    private Spinner spinner_sort,spinner_type;
    private String sort,type;

    public static WorkDisplayFragment newInstance(){
        WorkDisplayFragment fragment = new WorkDisplayFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_workdisplay,container,false);

        sort = "综合推荐";
        type = "全部";

        spinner_sort = view.findViewById(R.id.workdisplay_spinner_sort);
        final List<String> listsort = new ArrayList<>();
        listsort.add("综合推荐");
        listsort.add("人气最高");
        listsort.add("参与最多");
        ArrayAdapter<String> arraySortAdapter = new ArrayAdapter<String>(getContext(),R.layout.spinner_display_sort_item,R.id.spinner_sort,listsort);
        arraySortAdapter.setDropDownViewResource(R.layout.spinner_drop_down_sort_item);
        spinner_sort.setAdapter(arraySortAdapter);

        spinner_type = view.findViewById(R.id.workdisplay_spinner_type);
        final List<String> listtype;
        InitData initData = new InitData();
        listtype = initData.getTypeList();
        ArrayAdapter<String> arrayTypeAdapter = new ArrayAdapter<String>(getContext(),R.layout.spinner_display_type_item,R.id.spinner_type,listtype);
        arrayTypeAdapter.setDropDownViewResource(R.layout.spinner_drop_down_type_item);
        spinner_type.setAdapter(arrayTypeAdapter);

        recyclerView = view.findViewById(R.id.recycler_workdisplay);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        list = initData.getDisignWorkList();

        adapter = new DesignWorkMoreAdapter(list);
        adapter.setOnItemClickListener(new DesignWorkMoreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), WorkDetailActivity.class);
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

        return view;
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

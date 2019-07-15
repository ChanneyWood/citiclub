package com.example.a12579.citiclub.home.more;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.home.casedetails.CaseDetailActivity;
import com.example.a12579.citiclub.workspace.InitData;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 12579 on 2018/7/13.
 */

public class SuccessCaseActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private ImageView back;
    private SuccessCaseMoreAdapter adapter;
    private List<Map<String,Object>> successCaseList = new LinkedList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_success_case_more);

        back = findViewById(R.id.success_case_more_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        recyclerView = findViewById(R.id.recycler_success_case_more);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        InitData initData = new InitData();
        successCaseList = initData.getDisignWorkEndList();

        adapter = new SuccessCaseMoreAdapter(successCaseList);
        adapter.setOnItemClickListener(new SuccessCaseMoreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(SuccessCaseActivity.this, CaseDetailActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }

}

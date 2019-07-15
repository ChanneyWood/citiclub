package com.example.a12579.citiclub.workspace;

import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a12579.citiclub.R;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 12579 on 2018/7/9.
 */

public class WorkspaceFragment extends Fragment{

    private RadioGroup radioGroup;
    private RecyclerView recyclerView;
    private WorkSpaceAdapter workSpaceAdapter;
    private List<Map<String,Object>>list = new ArrayList<>();

    public static WorkspaceFragment newInstance() {
        WorkspaceFragment fragment = new WorkspaceFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workspace,container,false);
        list.clear();
        final InitData initData = new InitData();
        list = initData.getDisignWorkList();

        radioGroup = view.findViewById(R.id.work_space_rg);
        recyclerView = view.findViewById(R.id.work_space_rv);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton button1 = null,button2 = null,button3 = null;

                switch (i){
                    case R.id.workspace_rb_all:
                        button1 = radioGroup.findViewById(R.id.workspace_rb_all);
                        button2 = radioGroup.findViewById(R.id.workspace_rb_run);
                        button3 = radioGroup.findViewById(R.id.workspace_rb_end);
                        //list = initData.getDisignWorkList();
                        workSpaceAdapter.setList(list);
                        break;
                    case R.id.workspace_rb_run:
                        button2 = radioGroup.findViewById(R.id.workspace_rb_all);
                        button1 = radioGroup.findViewById(R.id.workspace_rb_run);
                        button3 = radioGroup.findViewById(R.id.workspace_rb_end);
                        //list = initData.getDisignWorkRunList();
                        workSpaceAdapter.setList(list);
                        break;
                    case R.id.workspace_rb_end:
                        button3 = radioGroup.findViewById(R.id.workspace_rb_all);
                        button2 = radioGroup.findViewById(R.id.workspace_rb_run);
                        button1 = radioGroup.findViewById(R.id.workspace_rb_end);
                        //list = initData.getDisignWorkEndList();
                        workSpaceAdapter.setList(list);
                        break;
                }

//                button1.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
//                button2.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
//                button3.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                button1.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD);
                button2.setTypeface(Typeface.SANS_SERIF);
                button3.setTypeface(Typeface.SANS_SERIF);
            }
        });

        workSpaceAdapter = new WorkSpaceAdapter(list,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(workSpaceAdapter);


        return view;
    }



}

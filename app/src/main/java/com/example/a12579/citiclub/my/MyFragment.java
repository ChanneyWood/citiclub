package com.example.a12579.citiclub.my;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.login.RegisterActivity;
import com.example.a12579.citiclub.main.MainActivity;
import com.example.a12579.citiclub.my.adapter.MultipleItemQuickAdapter;
import com.example.a12579.citiclub.my.bean.MultipleItem;
import com.example.a12579.citiclub.my.cardverification.ui.AddBankMessageActivity;
import com.example.a12579.citiclub.my.cardverification.ui.BankCardActivity;
import com.example.a12579.citiclub.my.widget.CircleImageView;

import java.util.ArrayList;


/**
 */

public class MyFragment extends Fragment{



    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;

    private MultipleItem multipleItem = null;

    private ArrayList<MultipleItem> itemDataList;

    private MultipleItemQuickAdapter multipleItemQuickAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_my, container, false);

//        myCard = view.findViewById(R.id.my_card);
//        balance = view.findViewById(R.id.my_balance_btn);
//
//        myCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent  = new Intent(getContext(), AddBankMessageActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        balance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), RegisterActivity.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mSwipeRefreshLayout = getActivity().findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = getActivity().findViewById(R.id.recyclerView);




        initSwipeRefreshLayout();

        initItemData();

        initRecyclerView();

        initListener();

    }


    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        multipleItemQuickAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                        //YUtils.showToast("刷新完成");
                    }
                }, 2000);
            }
        });
    }


    private void initItemData() {
        itemDataList = new ArrayList<>();

        multipleItem = new MultipleItem(MultipleItem.TYPE_COUNT, 5);
        multipleItem.mString1 = "成为设计师";
        multipleItem.mString2 = "我的钱包";
        itemDataList.add(multipleItem);

        multipleItem = new MultipleItem(MultipleItem.TYPE_ORDER_HEADER, 5);
        multipleItem.mString2 = "type2";
        itemDataList.add(multipleItem);

//        for (int i = 0; i < 4; i++) {
//            multipleItem = new MultipleItem(MultipleItem.TYPE_ORDER, 1);
//
//            if (i == 0) {
//                multipleItem.mString1 = "关注";
//            }
//            else if(i==1){
//                multipleItem.mString1 = "粉丝";
//            }
//            else if(i==2){
//                multipleItem.mString1 = "脑力值";
//            }
//            else{
//                multipleItem.mString1 = "动态";
//            }
//            itemDataList.add(multipleItem);
//        }

        multipleItem = new MultipleItem(MultipleItem.TYPE_BALANCE, 5);

        itemDataList.add(multipleItem);



        multipleItem = new MultipleItem(MultipleItem.TYPE_TOOLS_HEADER, 5);
        multipleItem.mString1 = "type5";
        itemDataList.add(multipleItem);


            multipleItem = new MultipleItem(MultipleItem.TYPE_TOOLS, 1);


                multipleItem.mString1 = "向朋友推荐";


            itemDataList.add(multipleItem);


        multipleItem = new MultipleItem(MultipleItem.TYPE_ORDER, 5);
        multipleItem.mString2 = "type2";
        itemDataList.add(multipleItem);
        }




    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        multipleItemQuickAdapter = new MultipleItemQuickAdapter(itemDataList,getContext());

        View headerView = getHeaderView(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.my_header_image:

                        break;
                    case R.id.my_header_settings:

                        break;
                }
            }
        });

        multipleItemQuickAdapter.addHeaderView(headerView);

        mRecyclerView.setAdapter(multipleItemQuickAdapter);
    }


    private View getHeaderView(View.OnClickListener listener) {
        View headerView = getLayoutInflater().inflate(R.layout.layout_my_header, (ViewGroup) mRecyclerView.getParent(), false);

        CircleImageView myHeaderImage = headerView.findViewById(R.id.my_header_image);
        myHeaderImage.setImageResource(R.drawable.header_image);
        myHeaderImage.setOnClickListener(listener);

        TextView myHeaderName = headerView.findViewById(R.id.my_header_name);
        myHeaderName.setText("账户");

        TextView myHeaderMobile = headerView.findViewById(R.id.my_header_mobile);
        myHeaderMobile.setText("手机号");

        ImageView myHeaderSettings = headerView.findViewById(R.id.my_header_settings);
        myHeaderSettings.setOnClickListener(listener);

        return headerView;
    }


    private void initListener() {
        multipleItemQuickAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return itemDataList.get(position).getSpanSize();
            }
        });

        multipleItemQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {




                if (itemDataList.get(position).getItemType() == MultipleItem.TYPE_TOOLS) {
                    if (itemDataList.get(position).isShow) {
                        itemDataList.get(position).isShow = false;
                        //LogUtil.i("count  =  " + itemDataList.get(position).count);
                        multipleItemQuickAdapter.notifyItemChanged(position + 1);
                    } else
                        itemDataList.get(position).isShow = false;
                }

            }
        });


    }
}

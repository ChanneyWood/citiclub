package com.example.a12579.citiclub.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.home.casedetails.CaseDetailActivity;
import com.example.a12579.citiclub.home.more.DesignWorkActivity;
import com.example.a12579.citiclub.home.more.SuccessCaseActivity;
import com.example.a12579.citiclub.home.orderdetails.OrderDetailsActivity;
import com.example.a12579.citiclub.home.scroll.ScrollFragment;
import com.example.a12579.citiclub.main.MainActivity;
import com.example.a12579.citiclub.workdisplay.WorkDisplayFragment;
import com.example.a12579.citiclub.workspace.InitData;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 12579 on 2018/7/9.
 */

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout sliderLayout;
    //最上面三个功能图标
    private ImageView imageView_design_work,imageView_library_work,imageView_success_case;
    //部分推荐recyclerview
    private RecyclerView successPartRecyclerView,designWorkPartRecyclerView,workCenterPartRecyclerView;
    //滑动流程提示
    private ScrollFragment scrollFragment;
    private SuccessCaseAdapter successCaseAdapter;
    private DesignWorkAdapter designWorkAdapter;
    private WorkCenterAdapter workCenterAdapter;
    private List<String> successCasePartList = new LinkedList<>();
    private List<Map<String,Object>>list = new LinkedList<>();

    private ConstraintLayout success_case_to_more,design_work_to_more,work_center_to_more;

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        successCasePartList.clear();

        //滑动图片
        sliderLayout = view.findViewById(R.id.layout_image_slider);

        HashMap<String,Integer> file_map = new LinkedHashMap<>();
        file_map.put("image1",R.drawable.u42);
        file_map.put("image2",R.drawable.u44);
        file_map.put("image3",R.drawable.u46);
        for (String name:file_map.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .image(file_map.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(this);

        //点击作业库进入作品展示页面
        imageView_library_work = view.findViewById(R.id.img_library_work);
        imageView_library_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                BottomNavigationBar bottomNavigationBar = activity.findViewById(R.id.bottom_navigation_bar);
                bottomNavigationBar.clearAll();
                bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home_u340,"首页").setActiveColor(R.color.colorBlack))
                        .addItem(new BottomNavigationItem(R.drawable.workspace_u335,"工作台").setActiveColor(R.color.colorBlack))
                        .addItem(new BottomNavigationItem(R.drawable.display_u330,"作品展示").setActiveColor(R.color.colorBlack))
                        .addItem(new BottomNavigationItem(R.drawable.personal_u325,"个人中心").setActiveColor(R.color.colorBlack))
                        .setFirstSelectedPosition(2)
                        .initialise();
                FragmentTransaction fm = activity.getSupportFragmentManager().beginTransaction();
                WorkDisplayFragment workDisplayFragment = WorkDisplayFragment.newInstance();
                fm.replace(R.id.replace_layout,workDisplayFragment);
                fm.addToBackStack(null);
                // 执行事务
                fm.commit();
            }
        });

        //点击设计任务查看所有设计任务
        imageView_design_work = view.findViewById(R.id.img_task_work);
        imageView_design_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),DesignWorkActivity.class);
                intent.putExtra("data","dada");//放数据，后台来了再加
                startActivity(intent);
            }
        });

        //点击成功案例查看所有成功案例
        imageView_success_case = view.findViewById(R.id.img_success_work);
        imageView_success_case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SuccessCaseActivity.class);
                intent.putExtra("data","dada");//放数据，后台来了再加
                startActivity(intent);
            }
        });
        //查看更多成功案例
        success_case_to_more = view.findViewById(R.id.success_case_to_more);
        success_case_to_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SuccessCaseActivity.class);
                intent.putExtra("data","dada");//放数据，后台来了再加
                startActivity(intent);
            }
        });


        //成功案例推荐部分
        successPartRecyclerView = view.findViewById(R.id.recycler_success_case_part);
        successPartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        successCasePartList.add("新一代萌杯NONONO大兵萌妹杯");
        successCasePartList.add("大连岛景区旅游形象 打造新浪旅游形象");
        successCasePartList.add("新一代萌杯NONONO大兵萌妹杯");
        successCasePartList.add("大连岛景区旅游形象 打造新浪旅游形象");
        successCasePartList.add("新一代萌杯NONONO大兵萌妹杯");
        successCaseAdapter = new SuccessCaseAdapter(successCasePartList);
        successCaseAdapter.setOnItemClickListener(new SuccessCaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(),CaseDetailActivity.class);
                startActivity(intent);
            }
        });
        successPartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        successPartRecyclerView.setAdapter(successCaseAdapter);




        //查看更多设计任务
        design_work_to_more = view.findViewById(R.id.design_work_to_more);
        design_work_to_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),DesignWorkActivity.class);
                intent.putExtra("data","dada");//放数据，后台来了再加
                startActivity(intent);
            }
        });
        //设计任务推荐部分
        InitData initData = new InitData();
        list = initData.getDisignWorkList();
        designWorkPartRecyclerView = view.findViewById(R.id.recycler_design_work_part);
        designWorkPartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        designWorkAdapter = new DesignWorkAdapter(successCasePartList);
        designWorkAdapter.setOnItemClickListener(new DesignWorkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(),OrderDetailsActivity.class);
                intent.putExtra("data", (Serializable) list.get(position));
                intent.putExtra("flag","已完成");
                startActivity(intent);
            }
        });
        designWorkPartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        designWorkPartRecyclerView.setAdapter(designWorkAdapter);

        //滑动流程提示
        scrollFragment = new ScrollFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.scroll_frag_home,scrollFragment);
        transaction.commit();

        //任务中心部分
        workCenterPartRecyclerView = view.findViewById(R.id.recycler_work_center_part);
        workCenterAdapter = new WorkCenterAdapter(successCasePartList);
        workCenterPartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        workCenterPartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        workCenterPartRecyclerView.setAdapter(workCenterAdapter);

        //查看更多任务
        work_center_to_more = view.findViewById(R.id.work_center_to_more);
        work_center_to_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),DesignWorkActivity.class);
                intent.putExtra("data","dada");//放数据，后台来了再加
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity() ,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

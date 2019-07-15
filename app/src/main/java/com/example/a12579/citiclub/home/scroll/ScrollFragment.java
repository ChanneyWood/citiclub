package com.example.a12579.citiclub.home.scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a12579.citiclub.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12579 on 2018/8/11.
 */

public class ScrollFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    RadioGroup radioGroup;
    ViewPager viewPager;

    //碎片数据源集合
    List<Fragment> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载数据
        list.add(new ReleaseFragment());
        list.add(new DesignFragment());
        list.add(new PropFragment());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.fragment_scroll_page_main,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //实例化控件
        radioGroup = view.findViewById(R.id.scroll_main_rg);
        viewPager = view.findViewById(R.id.scroll_main_vp);

        FragmentStatePagerAdapter adapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        radioGroup.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        View view = radioGroup.findViewById(i);
        String tag = view.getTag().toString();
        viewPager.setCurrentItem(Integer.parseInt(tag));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int id = 0;
//        RadioButton radioButton;
//        radioButton  = radioGroup.findViewById(R.id.scroll_main_release);
//        radioButton.setTextColor(getResources().getColor(R.color.colorBlack));
//        radioButton  = radioGroup.findViewById(R.id.scroll_main_design);
//        radioButton.setTextColor(getResources().getColor(R.color.colorBlack));
//        radioButton  = radioGroup.findViewById(R.id.scroll_main_prop);
//        radioButton.setTextColor(getResources().getColor(R.color.colorBlack));
        switch (position){
            case 0:
                id = R.id.scroll_main_release;
                break;
            case 1:
                id = R.id.scroll_main_design;
                break;
            case 2:
                id = R.id.scroll_main_prop;
                break;
        }
        //radioButton = radioGroup.findViewById(id);
        //radioButton.setTextColor(getResources().getColor(R.color.bigGreen));
        radioGroup.check(id);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}

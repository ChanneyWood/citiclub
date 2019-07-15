package com.example.a12579.citiclub.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a12579.citiclub.R;

import java.util.List;

/**
 * Created by 12579 on 2018/7/12.
 */

public class WorkCenterAdapter extends RecyclerView.Adapter<WorkCenterAdapter.ViewHolder>{


    private List<String> list;
    private int[] listSource = {R.drawable.center_1,R.drawable.center_2};

    public WorkCenterAdapter(List<String>list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work_center_part, parent, false);
        WorkCenterAdapter.ViewHolder viewHolder = new WorkCenterAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(listSource[position%2]);
        holder.textView_title.setText("保护器保护套设计 专注打造品质");
        holder.textView_type.setText("存储器保护套设计");
        holder.textView_salary.setText("¥"+"80000.00");
        holder.btn_enrolment.setText("47"+"人报名");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView_title,textView_type,textView_salary;
        Button btn_enrolment;//报名人数

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_work_center_part);
            textView_type = itemView.findViewById(R.id.textview_type_work_center_part);
            textView_title = itemView.findViewById(R.id.textview_title_work_center_part);
            textView_salary = itemView.findViewById(R.id.textview_salary_work_center_part);
            btn_enrolment = itemView.findViewById(R.id.btn_pepo_num_work_center_part);
        }
    }
}

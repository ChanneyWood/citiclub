package com.example.a12579.citiclub.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a12579.citiclub.R;

import java.util.List;

/**
 * Created by 12579 on 2018/7/12.
 */

public class DesignWorkAdapter extends RecyclerView.Adapter<DesignWorkAdapter.ViewHolder>{

    private List<String> list;
    private int[] listSource = {R.drawable.design_1,R.drawable.design_2,R.drawable.design_3,R.drawable.design_4,R.drawable.design_5};

    public DesignWorkAdapter(List<String>list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design_work_part, parent, false);
        DesignWorkAdapter.ViewHolder viewHolder = new DesignWorkAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.imageView.setImageResource(listSource[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getLayoutPosition();
                onItemClickListener.onItemClick(holder.itemView,pos);
            }
        });
        //holder.textView_title.setText("瓶口分液器设计 助力科研仪器创新");
        //holder.textView_salary.setText("¥"+80000.00);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        //TextView textView_title,textView_salary;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_design_work_part);
            //textView_title = itemView.findViewById(R.id.textview_title_design_work_part);
            //textView_salary = itemView.findViewById(R.id.textview_salary_design_work_part);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(DesignWorkAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}

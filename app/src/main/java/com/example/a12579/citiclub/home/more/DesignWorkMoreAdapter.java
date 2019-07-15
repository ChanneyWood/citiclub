package com.example.a12579.citiclub.home.more;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a12579.citiclub.R;

import java.util.List;
import java.util.Map;

/**
 * Created by 12579 on 2018/8/7.
 */

public class DesignWorkMoreAdapter extends RecyclerView.Adapter<DesignWorkMoreAdapter.ViewHolder>{

    private List<Map<String,Object>>list;
    private int[] resource = {R.drawable.design_more_1,R.drawable.design_more_2,R.drawable.design_more_3,R.drawable.design_more_4,R.drawable.design_more_5,R.drawable.design_more_6,R.drawable.design_more_7,R.drawable.design_more_8};

    //private boolean flag = false;

    public DesignWorkMoreAdapter(List<Map<String,Object>> list){
        this.list = list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design_work_more,parent,false);
        DesignWorkMoreAdapter.ViewHolder viewHolder = new DesignWorkMoreAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.imageView.setImageResource(resource[position]);
        holder.linearLayout.setOnClickListener(null);
//        Map<String,Object>map = list.get(position);
//        holder.textViewTitle.setText(map.get("title").toString());
//        holder.textViewSalary.setText("¥"+map.get("salary"));
//        holder.textViewType.setText(map.get("type").toString());
//        holder.textViewBrowse.setText(""+map.get("see"));
//        holder.textViewFollow.setText(""+map.get("follow"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getLayoutPosition();
                onItemClickListener.onItemClick(holder.itemView,pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        LinearLayout linearLayout;
        //TextView textViewTitle,textViewType,textViewSalary,textViewBrowse,textViewFollow;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_design_work_more);
            linearLayout = itemView.findViewById(R.id.design_work_more_lin);
//            textViewTitle = itemView.findViewById(R.id.textview_title_design_work_more);
//            textViewType = itemView.findViewById(R.id.textview_type_design_work_more);
//            textViewSalary = itemView.findViewById(R.id.textview_salary_design_work_more);
//            textViewBrowse = itemView.findViewById(R.id.textview_num_browse_design_work_more);
//            textViewFollow = itemView.findViewById(R.id.textview_num_follow_design_work_more);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}

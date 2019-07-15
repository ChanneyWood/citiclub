package com.example.a12579.citiclub.workspace;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.home.orderdetails.OrderDetailsActivity;
import com.example.a12579.citiclub.main.MainActivity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 12579 on 2018/8/13.
 */

public class WorkSpaceAdapter extends RecyclerView.Adapter<WorkSpaceAdapter.ViewHolder>{

    private List<Map<String,Object>> list;
    private Context context;

    public WorkSpaceAdapter(List<Map<String,Object>> list,Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workspace,parent,false);
        WorkSpaceAdapter.ViewHolder viewHolder = new WorkSpaceAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Map<String,Object> map = list.get(position);
        holder.imageView.setImageResource(Integer.parseInt(map.get("img").toString()));
        holder.tvCompany.setText(map.get("company").toString());
        holder.tvTtile.setText(map.get("title").toString());
        holder.tvSalary.setText("¥"+map.get("salary"));
        holder.tvTime.setText(map.get("time")+"天");
        int stageNum = Integer.parseInt(map.get("stageNum").toString());
        switch (stageNum){
            case 0:
                holder.tvState.setText("已经结算");
                holder.tvStage.setText("");
                holder.tvStageNum.setText("");
                holder.tvTime.setText("");
                holder.tvDDL.setVisibility(View.GONE);
                break;
            default:
                holder.tvState.setText("进行中");
                holder.tvStageNum.setText("阶段"+map.get("stageNum"));
                String stage = map.get("stage").toString();
                if (stage.equals("安全")){
                    holder.tvStage.setTextColor(Color.parseColor("#00cb63"));
                }else {
                    holder.tvStage.setTextColor(Color.RED);
                }
                holder.tvStage.setText(stage);
                break;
        }




        holder.lMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderDetailsActivity.class);
                intent.putExtra("data", (Serializable) list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvState,tvCompany,tvTtile,tvSalary,tvTime,tvStageNum,tvStage,tvDDL;
        LinearLayout lMore,lStage;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.workspace_image_view);
            tvState = itemView.findViewById(R.id.workspace_tv_state);
            tvCompany = itemView.findViewById(R.id.workspace_tv_company);
            tvTtile = itemView.findViewById(R.id.workspace_tv_title);
            tvSalary = itemView.findViewById(R.id.workspace_tv_salary);
            tvTime = itemView.findViewById(R.id.workspace_tv_time);
            tvStageNum = itemView.findViewById(R.id.workspace_tv_stage_num);
            tvStage = itemView.findViewById(R.id.workspace_tv_stage);
            lMore = itemView.findViewById(R.id.workspace_linear_more);
            lStage = itemView.findViewById(R.id.workspace_linear_stage);
            tvDDL = itemView.findViewById(R.id.workspace_tv_deadline);
        }
    }

}

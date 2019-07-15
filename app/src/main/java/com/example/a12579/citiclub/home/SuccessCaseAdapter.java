package com.example.a12579.citiclub.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a12579.citiclub.R;

import java.util.List;

/**
 * Created by 12579 on 2018/7/11.
 */

public class SuccessCaseAdapter extends RecyclerView.Adapter<SuccessCaseAdapter.ViewHolder>{

    private List<String> list;
    private int[] listSource = {R.drawable.suc_1,R.drawable.suc_2,R.drawable.suc_3,R.drawable.suc_4,R.drawable.suc_5};
    public SuccessCaseAdapter(List<String>list){
        this.list = list;
    }

    @Override
    public SuccessCaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_success_case_part, parent, false);
        SuccessCaseAdapter.ViewHolder viewHolder = new SuccessCaseAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.imageView.setImageResource(listSource[position]);
        //holder.textView.setText(list.get(position));

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

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        //TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_success_case_part);
            //textView = itemView.findViewById(R.id.textview_success_case_part);
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

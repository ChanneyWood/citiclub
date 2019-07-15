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
 * Created by 12579 on 2018/7/13.
 */

public class SuccessCaseMoreAdapter extends RecyclerView.Adapter<SuccessCaseMoreAdapter.ViewHolder>{

    private List<Map<String,Object>>list;

    private int[] resource = {R.drawable.suc_more_1,R.drawable.suc_more_2,R.drawable.suc_more_3,R.drawable.suc_more_4,R.drawable.suc_more_5,R.drawable.suc_more_6,R.drawable.suc_more_7,R.drawable.suc_more_8};

    public SuccessCaseMoreAdapter(List<Map<String,Object>>list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_success_case_more, parent, false);
        SuccessCaseMoreAdapter.ViewHolder viewHolder = new SuccessCaseMoreAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.imageView.setImageResource(resource[position]);
//        Map<String,Object>map = list.get(position);
        holder.linearLayout.setOnClickListener(null);
//        holder.textViewTitle.setText(map.get("title").toString());
//        holder.textViewType.setText(map.get("type").toString());

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
        LinearLayout linearLayout;
        //TextView textViewTitle,textViewType;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_success_case_more);
            linearLayout =itemView.findViewById(R.id.success_suc_bg);
//            textViewTitle = itemView.findViewById(R.id.textview_success_case_title_more);
//            textViewType = itemView.findViewById(R.id.textview_success_case_type_more);
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

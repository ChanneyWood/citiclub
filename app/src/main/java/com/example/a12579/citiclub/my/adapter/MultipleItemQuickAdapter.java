package com.example.a12579.citiclub.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.login.LoginActivity;
import com.example.a12579.citiclub.login.RegisterActivity;
import com.example.a12579.citiclub.main.MainActivity;
import com.example.a12579.citiclub.my.SaveActivity;
import com.example.a12579.citiclub.my.bean.MultipleItem;
import com.example.a12579.citiclub.my.cardverification.ui.AddBankActivity;
import com.example.a12579.citiclub.my.cardverification.ui.AddBankMessageActivity;

import java.util.List;

/**
 */

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    private Context context;

    public MultipleItemQuickAdapter(List data,Context context) {
        super(data);
        this.context = context;
        addItemType(MultipleItem.TYPE_COUNT, R.layout.layout_my_count);
        addItemType(MultipleItem.TYPE_ORDER_HEADER, R.layout.layout_my_order_header);

        addItemType(MultipleItem.TYPE_BALANCE, R.layout.layout_my_balance);
        addItemType(MultipleItem.TYPE_ORDER, R.layout.layout_my_order);
        addItemType(MultipleItem.TYPE_TOOLS_HEADER, R.layout.layout_my_tools_header);
        addItemType(MultipleItem.TYPE_TOOLS, R.layout.layout_my_tools);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TYPE_COUNT:
                helper.setText(R.id.my_favorites, item.mString1).addOnClickListener(R.id.my_favorites);
                helper.setText(R.id.my_bands, item.mString2).addOnClickListener(R.id.my_bands);
                break;
            case MultipleItem.TYPE_ORDER_HEADER:
                //helper.addOnClickListener(R.id.ll_my_order);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SaveActivity.class);
                        context.startActivity(intent);
                    }
                });

                break;
            case MultipleItem.TYPE_ORDER:
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent  = new Intent(context, LoginActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
//                helper.setImageDrawable(R.id.my_order_image, ContextCompat.getDrawable(mContext, R.drawable.ic_launcher));
//                helper.setText(R.id.my_order_name, item.mString1);
//                if (item.isShow) {
//                    helper.getView(R.id.my_order_count).setVisibility(View.VISIBLE);
//                    if (item.count > 0) {
//                        if (item.count < 99) {
//                            helper.setText(R.id.my_order_count, String.valueOf(item.count));
//                        } else {
//                            helper.setText(R.id.my_order_count, String.valueOf(""));
//                        }
//                    } else {
//                        helper.getView(R.id.my_order_count).setVisibility(View.GONE);
//                    }
//                } else {
//                    helper.getView(R.id.my_order_count).setVisibility(View.GONE);
//                }
//                break;
            case MultipleItem.TYPE_BALANCE:
          //      helper.setText(R.id.my_balance_text, item.mString1);
           //     helper.addOnClickListener(R.id.my_balance_btn);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent  = new Intent(context, AddBankActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            case MultipleItem.TYPE_TOOLS_HEADER:
                //helper.setText(R.id.tv_item_name, item.mString1);
                break;
            case MultipleItem.TYPE_TOOLS:
                helper.setImageDrawable(R.id.my_tools_image, ContextCompat.getDrawable(mContext, R.drawable.ic_launcher));
                helper.setText(R.id.my_tools_text, item.mString1);
                if (item.isShow) {
                    helper.getView(R.id.my_tools_count).setVisibility(View.VISIBLE);
                    if (item.count > 0) {
                        if (item.count < 99) {
                            helper.setText(R.id.my_tools_count, String.valueOf(item.count));
                        } else {
                            helper.setText(R.id.my_tools_count, String.valueOf(""));
                        }
                    } else {
                        helper.getView(R.id.my_tools_count).setVisibility(View.GONE);
                    }
                } else {
                    helper.getView(R.id.my_tools_count).setVisibility(View.GONE);
                }
                break;
        }
    }


}

package com.example.a12579.citiclub.home.orderdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.a12579.citiclub.R;

import java.util.Map;

public class OrderDetailsActivity extends AppCompatActivity {

    private ImageView back;
    private LinearLayout run,end_in,end_out;
    private Button state;
    private boolean flag = false;
    Map<String,Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        map = (Map<String, Object>) getIntent().getSerializableExtra("data");

        if (getIntent().getStringExtra("flag")!=null){
            flag = true;
        }

        back = findViewById(R.id.order_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        run = findViewById(R.id.order_detail_salary_run);
        end_in = findViewById(R.id.order_detail_salary_end_in);
        end_out = findViewById(R.id.order_detail_salary_end_out);

        state = findViewById(R.id.order_detail_state);
        if (flag==true){
            state.setText("报名");
            run.setVisibility(View.VISIBLE);
            end_out.setVisibility(View.GONE);
            end_in.setVisibility(View.GONE);
        }else {
            initSalary();
        }
        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"报名成功",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initSalary() {
        switch (map.get("stageNum").toString()){
            case "0":
                state.setText("已结算");
                switch (map.get("bid").toString()){
                    case "0":
                        run.setVisibility(View.GONE);
                        end_out.setVisibility(View.VISIBLE);
                        end_in.setVisibility(View.GONE);
                        break;
                    case "1":
                        run.setVisibility(View.GONE);
                        end_out.setVisibility(View.GONE);
                        end_in.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case "1":
                state.setText(" 进行中 阶段一 ");
                run.setVisibility(View.VISIBLE);
                end_out.setVisibility(View.GONE);
                end_in.setVisibility(View.GONE);
                break;
            case "2":
                state.setText(" 进行中 阶段二 ");
                run.setVisibility(View.VISIBLE);
                end_out.setVisibility(View.GONE);
                end_in.setVisibility(View.GONE);
                break;
        }
    }
}

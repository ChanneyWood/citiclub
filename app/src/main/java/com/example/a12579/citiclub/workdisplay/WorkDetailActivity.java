package com.example.a12579.citiclub.workdisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a12579.citiclub.R;

public class WorkDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back,weixin,weibo,qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_detail);

        back = findViewById(R.id.work_detail_back);
        back.setOnClickListener(this);

        weixin = findViewById(R.id.work_detail_weixin);
        weibo = findViewById(R.id.work_detail_weibo);
        qq = findViewById(R.id.work_detail_qq);
        weixin.setOnClickListener(this);
        qq.setOnClickListener(this);
        weibo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.work_detail_back:
                finish();
                break;
            case R.id.work_detail_weixin:
                Intent wechatIntent = new Intent(Intent.ACTION_SEND);
                wechatIntent.setPackage("com.tencent.mm");
                wechatIntent.setType("text/plain");
                wechatIntent.putExtra(Intent.EXTRA_TEXT, "分享到微信的内容");
                startActivity(wechatIntent);
                break;
            case R.id.work_detail_weibo:
                Intent weiboIntent = new Intent(Intent.ACTION_SEND);
                weiboIntent.setPackage("com.sina.weibo");
                weiboIntent.setType("text/plain");
                weiboIntent.putExtra(Intent.EXTRA_TEXT, "分享到微博的内容");
                startActivity(weiboIntent);
                break;
            case R.id.work_detail_qq:
            Intent qqIntent = new Intent(Intent.ACTION_SEND);
            qqIntent.setPackage("com.tencent.mobileqq");
            qqIntent.setType("text/plain");
            qqIntent.putExtra(Intent.EXTRA_TEXT, "分享到qq的内容");
            startActivity(qqIntent);
            break;

        }
    }
}

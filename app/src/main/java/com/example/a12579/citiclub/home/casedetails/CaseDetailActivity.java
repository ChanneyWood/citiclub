package com.example.a12579.citiclub.home.casedetails;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.a12579.citiclub.R;

import java.io.File;
import java.util.Map;

public class CaseDetailActivity extends AppCompatActivity {

    private ImageView back;
    private VideoView videoView;
    private MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_detail);

        back = findViewById(R.id.case_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        videoView = findViewById(R.id.case_detail_video);
//        mediaController = new MediaController(this);
//        String uri = "android.resource://" + getPackageName() + "/" + R.raw.shipin;
//        videoView.setVideoURI(Uri.parse(uri));
//        videoView.setMediaController(mediaController);
//        mediaController.setMediaPlayer(videoView);

    }



}

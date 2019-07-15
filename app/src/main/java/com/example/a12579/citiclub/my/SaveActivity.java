package com.example.a12579.citiclub.my;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.main.MainActivity;

public class SaveActivity extends AppCompatActivity {

    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        save = findViewById(R.id.save_person_msg);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(SaveActivity.this, MainActivity.class);
//                startActivity(intent);
                SaveActivity.this.finish();
            }
        });
    }
}
